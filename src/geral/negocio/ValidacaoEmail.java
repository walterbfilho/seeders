package geral.negocio;

import java.util.regex.*;    

public class ValidacaoEmail{  
    public static Boolean validacaoEmail(String email){     
        String regex = "^(.+)@(.+)$";  
        Pattern pattern = Pattern.compile(regex);  
            //Create instance of matcher   
            Matcher matcher = pattern.matcher(email);  
            return matcher.matches();
    }  
}   
