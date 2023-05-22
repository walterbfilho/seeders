package usuario;

public class OngMediator {
	
	private static OngMediator ongMediatorInstance;
	
	private OngDAO ongDAO;
	
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
		}
	} 
	
	public String alterarOng(OngCadastrada ong) {
		String valido = validarOng(ong);
		if(valido == null) {
			ongDAO.alterarOng(ong);
		}
		return valido;
	}
	
	private String validarOng(OngCadastrada ong) {
		
		if(StringUtil.ehNuloOuBranco(ong.getNome())) {
			return "Nome da ong é obrigatório!!!";
		}else if(StringUtil.ehNuloOuBranco(ong.getDescricao())) {
			return "Descrição da ong é obrigatória!!!";
		}else if(ong.getEnderecoOng() == null) {
			return "O endereço da ong deve ser inserido!!!";
		}else if(ong.getInfoContato() == null) {
			return "A ong deve possuir as informações de contato!!!";
		}else if(StringUtil.ehNuloOuBranco(ong.getInfoContato().getCelular()) ||
		StringUtil.ehNuloOuBranco(ong.getInfoContato().getEmail()) || 
		StringUtil.ehNuloOuBranco(ong.getInfoContato().getLinkedin()) ||
		StringUtil.ehNuloOuBranco(ong.getInfoContato().getSite()) ||
		StringUtil.ehNuloOuBranco(ong.getInfoContato().getInstagram())) {
			return "Insira pelo menos uma informação de contato!!!";
		}
		else if(!StringUtil.ehNuloOuBranco(ong.getInfoContato().getEmail()) && ValidacaoEmail.validacaoEmail(ong.getInfoContato().getEmail())){
			return "Email no formato inválido!!!";
		}else if(ong.getTags().length == 0){
			return "A ong deve ter pelo menos uma tag!!!";
		}else {
			return null;
		}
	}
	
	
}
