package main;

import javax.xml.ws.WebServiceRef;

import servicesweb.MonServiceWeb;
import servicesweb.MonServiceWebImplService;

public class Main {
	@WebServiceRef(wsdlLocation="http://localhost:8080/helloservice/hello?wsdl")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MonServiceWebImplService serviceImpl = new MonServiceWebImplService();
		MonServiceWeb monServiceWeb = serviceImpl.getMonServiceWebImplPort();
		monServiceWeb.afficheLylia();
		System.out.println("Elle a "+monServiceWeb.ageLylia()+" ans");
	}

}
