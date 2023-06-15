package ong.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import geral.entidade.Endereco;
import geral.entidade.InfoContato;
import ong.entidade.OngCadastrada;
import ong.negocio.OngMediator;

public class OngDAO implements Serializable{ 
	private static final String FILE_SEP = System.getProperty("file.separator");
	private static final String DIR_BASE = "." + FILE_SEP + "ong" + FILE_SEP + "ongs" + FILE_SEP;
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
			oos.writeObject(ong.getEndereco());
		} catch (Exception e) {
			throw new RuntimeException("Erro ao incluir a ong " + e.getMessage());
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
		System.out.println(arq.getAbsolutePath());
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
	
	public OngCadastrada[] buscarOngsPorTag(String[] tags) {
		
		File diretorio = new File(DIR_BASE);
		
		if (!diretorio.exists()) {
			return null;
		}
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			
			File[] files = diretorio.listFiles((dir, name) -> name.toLowerCase().endsWith(".dat"));
			
			if(files.length == 0) {
				return new OngCadastrada[0];
			}
			
			OngCadastrada[] ongs = new OngCadastrada[files.length];
			
			int cont = 0;
			int qnt = tags.length;
					
			for(File file: files) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);	
				Object objeto = ois.readObject();
				if(objeto instanceof OngCadastrada) {
					Integer contSimilaridade = 0;
					OngCadastrada ong = (OngCadastrada) objeto;
					for(String tagOng:ong.getTags()) {
						for(String tagParam:tags) {
							if(tagParam.equals(tagOng)) {
									contSimilaridade++;
							}
							
						}
					}
					if(contSimilaridade == qnt) {				
						ongs[cont] = ong;
						cont += 1;
					}
				}
			}
			return  ongs;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao ler chave " + e.getMessage());
		} finally {
			try {
				ois.close();
			} catch (Exception e) {
			}
			try {
				fis.close();
			} catch (Exception e) {
			}
		}
	}
	public OngCadastrada[] buscarOngsPorTag(Boolean semFiltros) {
        if(semFiltros == false) {
            return null;
        }

        File diretorio = new File(DIR_BASE);

        if (!diretorio.exists()) {
            return null;
        }
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {

            File[] files = diretorio.listFiles((dir, name) -> name.toLowerCase().endsWith(".dat"));

            if(files.length == 0) {
                return new OngCadastrada[0];
            }

            OngCadastrada[] ongs = new OngCadastrada[files.length];

            int cont = 0;

            for(File file: files) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                Object objeto = ois.readObject();
                if(objeto instanceof OngCadastrada) {
                    OngCadastrada ong = (OngCadastrada) objeto;
                    ongs[cont] = ong;
                    cont += 1;
                }
            }
            return  ongs;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler chave " + e.getMessage());
        } finally {
            try {
                ois.close();
            } catch (Exception e) {
            }
            try {
                fis.close();
            } catch (Exception e) {
            }
        }
    }
	
	public static void main(String[] args) {
		InfoContato infoContato = new InfoContato("leo@gmail.com", "celulardeleo", "leoenterprises", "leomail.com", "leodelas", "leo");
		Endereco endereco = new Endereco("Rua Bione", "Cidade de Bione", "Estado de Bione", "5205011", 123, "Pais B1");
		String[] tags = new String[2];
		tags[0] = "Tag1";
		tags[1] = "Tag2";
		OngCadastrada ong = new OngCadastrada("OngTeste", tags, "Descrição massa", "Pix Teste", infoContato, endereco);
		OngMediator mediator = OngMediator.getInstance();
		mediator.incluirOng(ong);
		//System.out.println(file.getAbsolutePath());
		String[] tagsParam = new String[2];
		tagsParam[0] = "Tag1";
		tagsParam[1] = "Tag2";
		OngCadastrada[] ongsBusca = mediator.ongDAO.buscarOngsPorTag(tagsParam);
		System.out.println(ongsBusca[0]);
	}
}