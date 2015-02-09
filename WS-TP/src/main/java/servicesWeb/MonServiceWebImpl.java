package servicesWeb;

import javax.jws.WebService;

@WebService(endpointInterface = "servicesWeb.MonServiceWeb")
public class MonServiceWebImpl implements MonServiceWeb{
	
	@Override
	public void afficheLylia(){
		System.out.println("Test Lylia");
	}

	@Override
	public int ageLylia() {		
		return 22;
	}
}