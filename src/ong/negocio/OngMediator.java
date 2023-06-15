package ong.negocio;

import java.util.HashMap;
import java.util.Map;

import geral.entidade.GeoLocatorWrapper;
import geral.entidade.Geolocalizacao;
import geral.entidade.StringUtil;
import geral.negocio.ValidacaoEmail;
import ong.dao.OngDAO;
import ong.entidade.OngCadastrada;
import usuario.entidade.Usuario;

public class OngMediator {
	
	private static OngMediator ongMediatorInstance;
	
	public OngDAO ongDAO;
	
	private OngMediator() {
		this.ongDAO = new OngDAO();
	}
	
	
	public static synchronized OngMediator getInstance() {
		if (ongMediatorInstance == null)
			ongMediatorInstance = new OngMediator();

		return ongMediatorInstance;
	}
	
	public void incluirOng(OngCadastrada ong) {
		String valido = validarOng(ong);
		if(valido == null) {
			ongDAO.incluirOng(ong); 
		}else {
			System.out.println("Deu merda parceiro");
		}
	} 
	
	public String alterarOng(OngCadastrada ong) {
		String valido = validarOng(ong);
		if(valido == null) {
			ongDAO.alterarOng(ong);
		}
		return valido;
	}
	
	public String validarOng(OngCadastrada ong) {
		
		if(StringUtil.ehNuloOuBranco(ong.getNome())) {
			return "Nome da ong é obrigatório!!!";
		}else if(StringUtil.ehNuloOuBranco(ong.getDescricao())) {
			return "Descrição da ong é obrigatória!!!";
		}else if(ong.getEndereco() == null) {
			return "O endereço da ong deve ser inserido!!!";
		}else if(ong.getInfoContato() == null) {
			return "A ong deve possuir as informações de contato!!!";
		}/*else if(ong.getInfoContato().verificarAtributos(ong.getInfoContato())) {
			return "Insira pelo menos uma informação de contato!!!";
		}*/
		else if(!ValidacaoEmail.validacaoEmail(ong.getInfoContato().getEmail())){
			return "Email no formato inválido!!!";
		}else if(ong.getTags().length == 0){
			return "A ong deve ter pelo menos uma tag!!!";
		}else {
			return null;
		}
	}
	public GeoLocatorWrapper ordenarOngsPorDistancia(Usuario usuario) {
		GeoLocatorWrapper wrapper= new GeoLocatorWrapper();
		OngCadastrada[] todasOngs = this.ongDAO.buscarOngsPorTag(true);
		Double[] doubleLst = new Double[todasOngs.length];
		int contLstDouble = 0;
		
		Geolocalizacao geo = new Geolocalizacao();
		Map<Double, OngCadastrada> mapOngDistancia = new HashMap<>();
		for(OngCadastrada ong:todasOngs) {
			Double distanciaMetros = geo.distance(usuario.getEndereco().getLatitude(), ong.getEndereco().getLatitude(), usuario.getEndereco().getLongitude(), ong.getEndereco().getLongitude());
			mapOngDistancia.put(distanciaMetros, ong);
			doubleLst[contLstDouble] = distanciaMetros;
			contLstDouble++;
		}
		
        for (int i = 0; i < doubleLst.length - 1; i++) {
            for (int k = i + 1; k < doubleLst.length; k++) {
                if (doubleLst[i] > doubleLst[k]) {
                    Double aux = doubleLst[i];
                    doubleLst[i] = doubleLst[k];
                    doubleLst[k] = aux;
                }
            }
        }
        
        OngCadastrada[] lstOngReturn = new OngCadastrada[todasOngs.length];
        for(int i=0;i<doubleLst.length;i++) {
        	lstOngReturn[i] = mapOngDistancia.get(doubleLst[i]);
        }
        wrapper.ongs = lstOngReturn;
        wrapper.distancias = doubleLst;
		return wrapper;
	}
	
}
