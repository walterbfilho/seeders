package geral.entidade;

public class StringUtil {

  private StringUtil() {
  }

  public static boolean ehNuloOuBranco(String str) {
    if (str == null) {
      return true;
    }

    String strSemEspacos = str.trim();
    return strSemEspacos.isEmpty();
  }
  
  public static boolean validarSenha(String senha) {
	  return senha.length() >= 8 && senha.matches(".[A-Z].");
  }	  
	  
}