package usuario.negocio;

import geral.entidade.StringUtil;
import geral.negocio.ValidacaoEmail;
import geral.negocio.ValidadorCPF;
import usuario.dao.UsuarioDao;
import usuario.entidade.Usuario;

public class UsuarioMediator {
	
	private static UsuarioMediator usuarioMediatorInstance;
	
	private UsuarioDao usuarioDao;
	
	private UsuarioMediator() {
		this.usuarioDao = new UsuarioDao();
	}
	
	
	public static synchronized UsuarioMediator getInstance() {
		if (usuarioMediatorInstance == null)
			usuarioMediatorInstance = new UsuarioMediator();

		return usuarioMediatorInstance;
	}
	
	public void incluirUsuario(Usuario usuario) {
		String valido = validarUsuario(usuario);
		
		if(valido == null) {
			usuarioDao.incluirUsuario(usuario); 
		}
	} 
	
	public String alterarUsuario(Usuario usuario) {
		String valido = validarUsuario(usuario);
		if(valido == null) {
			usuarioDao.alterarUsuario(usuario);
		}
		return valido;
	}
	
	public String validarUsuario(Usuario usuario) {
		
		if(!ValidadorCPF.ehCpfValido(usuario.getCpf())){
			return "CPF inválido!!!";
		}
		else if(StringUtil.ehNuloOuBranco(usuario.getNome())) {
			return "Nome completo é obrigatório!!!";
		}else if(!ValidacaoEmail.validacaoEmail(usuario.getEmail())){
			return "Email no formato inválido!!!";
		}else if(StringUtil.validarSenha(usuario.getSenha())){
			return "A senha deve conter pelo menos 8 caracteres e pelo menos uma letra maiúscula!!!";
		}else {
			return null;
		}
	}
	
	
}
