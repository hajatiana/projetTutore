package servicesWeb;

import javax.xml.ws.Endpoint;

public class Main {

	public static void main(String[] args) {
		MonServiceWeb monServiceWeb = new MonServiceWebImpl();
		Endpoint.publish("http://localhost:8080/WS/MonServiceWeb",monServiceWeb);		
		System.out.println("Server en marche");		
	}	
}
