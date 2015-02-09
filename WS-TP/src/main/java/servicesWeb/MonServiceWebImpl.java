package servicesWeb;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "servicesWeb.MonServiceWeb")
public class MonServiceWebImpl implements MonServiceWeb{
	
	@WebMethod
	public void afficheLylia(){
		System.out.println("Test Lylia");
	}

	@WebMethod
	public int ageLylia() {		
		return 22;
	}
}