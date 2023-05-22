package usuario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OngDAO { 
	private static final String FILE_SEP = System.getProperty("file.separator");
	private static final String DIR_BASE = "." + FILE_SEP + "seeders" + FILE_SEP 
			+ "ong" + FILE_SEP; 
	private static final String EXT = ".dat";
	public OngDAO() {
		File diretorio = new File(DIR_BASE);
		if (!diretorio.exists()) {
			diretorio.mkdir();
		}
	}
	private File getArquivo(String nomeOng) {
		String nomeArq = DIR_BASE + nomeOng + EXT;
		return new File(nomeArq);		
	}
	private void incluirAux(OngCadastrada ong, File arq) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(arq);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ong);
			oos.writeObject(ong.getInfoContato());
			oos.writeObject(ong.getEnderecoOng());
		} catch (Exception e) {
			throw new RuntimeException("Erro ao incluir a ong");
		} finally {
			try {
				oos.close();
			} catch (Exception e) {}
			try {
				fos.close();
			} catch (Exception e) {}			
		} 		
	}
	public boolean incluirOng(OngCadastrada ong) {
		File arq = getArquivo(ong.getNome());
		if (arq.exists()) {
			return false; 
		}
		incluirAux(ong, arq);
		return true; 
	}
	public boolean alterarOng(OngCadastrada ong) {
		File arq = getArquivo(ong.getNome());
		if (!arq.exists()) {
			return false; 
		}		
		if (!arq.delete()) {
			return false;
		}
		incluirAux(ong, arq);
		return true;
	}
	public OngCadastrada buscarOng(String nomeOng) {
		File arq = getArquivo(nomeOng);
		if (!arq.exists()) {
			return null; 
		}				
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(arq);
			ois = new ObjectInputStream(fis);
			return (OngCadastrada)ois.readObject(); 
		} catch (Exception e) {
			throw new RuntimeException("Erro ao ler a ong");
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