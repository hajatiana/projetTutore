
package servicesweb;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MonServiceWebImplService", targetNamespace = "http://servicesWeb/", wsdlLocation = "http://localhost:8080/WS/MonServiceWeb?wsdl")
public class MonServiceWebImplService
    extends Service
{

    private final static URL MONSERVICEWEBIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException MONSERVICEWEBIMPLSERVICE_EXCEPTION;
    private final static QName MONSERVICEWEBIMPLSERVICE_QNAME = new QName("http://servicesWeb/", "MonServiceWebImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WS/MonServiceWeb?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MONSERVICEWEBIMPLSERVICE_WSDL_LOCATION = url;
        MONSERVICEWEBIMPLSERVICE_EXCEPTION = e;
    }

    public MonServiceWebImplService() {
        super(__getWsdlLocation(), MONSERVICEWEBIMPLSERVICE_QNAME);
    }

    public MonServiceWebImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MONSERVICEWEBIMPLSERVICE_QNAME, features);
    }

    public MonServiceWebImplService(URL wsdlLocation) {
        super(wsdlLocation, MONSERVICEWEBIMPLSERVICE_QNAME);
    }

    public MonServiceWebImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MONSERVICEWEBIMPLSERVICE_QNAME, features);
    }

    public MonServiceWebImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MonServiceWebImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MonServiceWeb
     */
    @WebEndpoint(name = "MonServiceWebImplPort")
    public MonServiceWeb getMonServiceWebImplPort() {
        return super.getPort(new QName("http://servicesWeb/", "MonServiceWebImplPort"), MonServiceWeb.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MonServiceWeb
     */
    @WebEndpoint(name = "MonServiceWebImplPort")
    public MonServiceWeb getMonServiceWebImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servicesWeb/", "MonServiceWebImplPort"), MonServiceWeb.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MONSERVICEWEBIMPLSERVICE_EXCEPTION!= null) {
            throw MONSERVICEWEBIMPLSERVICE_EXCEPTION;
        }
        return MONSERVICEWEBIMPLSERVICE_WSDL_LOCATION;
    }

}
