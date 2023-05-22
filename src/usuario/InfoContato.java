package usuario;
import java.lang.reflect.Field;

public class InfoContato {
	private String email;
	private String celular;
	private String linkedin;
	private String site;
	private String instagram;
	private String facebook;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	
    public boolean verificarAtributos(Object objeto) {
        Class<?> classe = objeto.getClass();
        Field[] campos = classe.getDeclaredFields();

        for (Field campo : campos) {
            if (campo.getType() == String.class) {
                campo.setAccessible(true);

                try {
                    String valor = (String) campo.get(objeto);
                    if (valor != null && !valor.isEmpty()) {
                        return true;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

}

