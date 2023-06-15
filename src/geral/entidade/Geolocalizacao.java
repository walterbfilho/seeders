package geral.entidade;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import ong.entidade.OngCadastrada;
import ong.negocio.OngMediator;
import usuario.entidade.Usuario;

public class Geolocalizacao {

	public OngCadastrada[] ordenarOngsPorDistancia(Usuario usuario) {
		OngMediator mediatorOng = OngMediator.getInstance();
		OngCadastrada[] todasOngs = mediatorOng.ongDAO.buscarOngsPorTag(true);
		Double[] doubleLst = new Double[todasOngs.length];
		int contLstDouble = 0;
		
		for(OngCadastrada ong:todasOngs) {
			System.out.println(ong.getNome());
		}
		
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
        
		return lstOngReturn;
	}
	
    public static void main(String[] args) {
        Endereco enderecoDeLeo = new Endereco("Rua Guilherme Salazar", "Recife", "Pernambuco",
                "52050020", 0, "Brasil");
        Usuario usuario = new Usuario("Leo Endereco", "LeoSenha", "LeoCPF", "teste@gmail.com", enderecoDeLeo);
        Geolocalizacao geolocation = new Geolocalizacao();
        geolocation.ordenarOngsPorDistancia(usuario);
    }

    public static void LatitudeLongitudeCalculator(Endereco endereco) {
        try {
            String enderecoNaoTratado = endereco.toString();
            String enderecoTratado = enderecoNaoTratado.replace(" ", "+");

            String url = "https://api.opencagedata.com/geocode/v1/json?q=" +
                    enderecoTratado +
                    "&key=fd0b231d6c7646e4ab242416a5542e65&language=pt&pretty=1";
            System.out.println(url);

            URL apiURL = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) apiURL.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse JSON response
                Map<String, Object> jsonResponse = parseJsonResponse(response.toString());
                System.out.println(jsonResponse);
                if (jsonResponse.containsKey("geometry") && jsonResponse.containsKey("lng")) {
                    String latitudeNaoTratada = jsonResponse.get("geometry").toString();
                    latitudeNaoTratada = latitudeNaoTratada.replace(" ", "").replace("lat", "").replace("{", "").replace(":", "").replace("\"", "");
                    Double latitude = Double.parseDouble(latitudeNaoTratada);

                    String longitudeNaoTratada = jsonResponse.get("lng").toString();
                    longitudeNaoTratada = longitudeNaoTratada.replace(" ", "").replace("}", "").replace("]", "");
                    Double longitude = Double.parseDouble(longitudeNaoTratada);
                    Endereco enderecoRetorno = endereco;
                    enderecoRetorno.setLatitude(latitude);
                    enderecoRetorno.setLongitude(longitude);
                }
            }
            conn = null;
            responseCode = 0;
            apiURL = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Object> parseJsonResponse(String jsonResponse) {
        Map<String, Object> map = null;
        try {
            jsonResponse = jsonResponse.trim();
            if (jsonResponse.startsWith("{") && jsonResponse.endsWith("}")) {
                map = new HashMap<>();
                jsonResponse = jsonResponse.substring(1, jsonResponse.length() - 1);
                String[] keyValuePairs = jsonResponse.split(",");
                for (String pair : keyValuePairs) {
                    String[] keyValue = pair.split(":", 2);
                    if (keyValue.length == 2) {
                        String key = keyValue[0].trim().replaceAll("\"", "");
                        String value = keyValue[1].trim();
                        if (value.startsWith("{") && value.endsWith("}")) {
                            value = value.substring(1, value.length() - 1);
                            Map<String, Object> nestedMap = parseJsonResponse(value);
                            map.put(key, nestedMap);
                        } else {
                            map.put(key, value);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
    
    public static double distance(double lat1, double lat2, double lon1,
            double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        distance = Math.pow(distance, 2);

        return Math.sqrt(distance);
    }
    
}