package servicesWeb;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MonServiceWeb {
	
	@WebMethod
	public void afficheLylia();
	
	@WebMethod
	public int ageLylia();
}