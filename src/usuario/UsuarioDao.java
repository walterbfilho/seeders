package usuario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UsuarioDao { 
	private static final String FILE_SEP = System.getProperty("file.separator");
	private static final String DIR_BASE = "." + FILE_SEP + "seeders" + FILE_SEP 
			+ "usuario" + FILE_SEP; 
	private static final String EXT = ".dat";
	public UsuarioDao() {
		File diretorio = new File(DIR_BASE);
		if (!diretorio.exists()) {
			diretorio.mkdir();
		}
	}
	private File getArquivo(String cpf) {
		String nomeArq = DIR_BASE + cpf + EXT;
		return new File(nomeArq);		
	}
	private void incluirAux(Usuario usuario, File arq) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(arq);
			oos = new ObjectOutputStream(fos);
			if(usuario.getEndereco() == null) {
				oos.writeObject(usuario);
			}else {
				oos.writeObject(usuario);
				oos.writeObject(usuario.getEndereco());
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao incluir usuário");
		} finally {
			try {
				oos.close();
			} catch (Exception e) {}
			try {
				fos.close();
			} catch (Exception e) {}			
		} 		
	}
	public boolean incluirUsuario(Usuario usuario) {
		File arq = getArquivo(usuario.getCpf());
		if (arq.exists()) {
			return false; 
		}
		incluirAux(usuario, arq);
		return true; 
	}
	public boolean alterarUsuario(Usuario usuario) {
		File arq = getArquivo(usuario.getCpf());
		if (!arq.exists()) {
			return false; 
		}		
		if (!arq.delete()) {
			return false;
		}
		incluirAux(usuario, arq);
		return true;
	}
	public Usuario buscarUsuario(String cpf) {
		File arq = getArquivo(cpf);
		if (!arq.exists()) {
			return null; 
		}				
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(arq);
			ois = new ObjectInputStream(fis);
			return (Usuario)ois.readObject(); 
		} catch (Exception e) {
			throw new RuntimeException("Erro ao ler o usuário");
		} finally {
			try {
				ois.close(); 
			} catch (Exception e) {}
			try {
				fis.close(); 
			} catch (Exception e) {}			
		}
	}
}