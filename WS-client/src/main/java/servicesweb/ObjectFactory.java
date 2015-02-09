
package servicesweb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servicesweb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AfficheLyliaResponse_QNAME = new QName("http://servicesWeb/", "afficheLyliaResponse");
    private final static QName _AgeLyliaResponse_QNAME = new QName("http://servicesWeb/", "ageLyliaResponse");
    private final static QName _AgeLylia_QNAME = new QName("http://servicesWeb/", "ageLylia");
    private final static QName _AfficheLylia_QNAME = new QName("http://servicesWeb/", "afficheLylia");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servicesweb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AfficheLyliaResponse }
     * 
     */
    public AfficheLyliaResponse createAfficheLyliaResponse() {
        return new AfficheLyliaResponse();
    }

    /**
     * Create an instance of {@link AgeLylia }
     * 
     */
    public AgeLylia createAgeLylia() {
        return new AgeLylia();
    }

    /**
     * Create an instance of {@link AgeLyliaResponse }
     * 
     */
    public AgeLyliaResponse createAgeLyliaResponse() {
        return new AgeLyliaResponse();
    }

    /**
     * Create an instance of {@link AfficheLylia }
     * 
     */
    public AfficheLylia createAfficheLylia() {
        return new AfficheLylia();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AfficheLyliaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicesWeb/", name = "afficheLyliaResponse")
    public JAXBElement<AfficheLyliaResponse> createAfficheLyliaResponse(AfficheLyliaResponse value) {
        return new JAXBElement<AfficheLyliaResponse>(_AfficheLyliaResponse_QNAME, AfficheLyliaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgeLyliaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicesWeb/", name = "ageLyliaResponse")
    public JAXBElement<AgeLyliaResponse> createAgeLyliaResponse(AgeLyliaResponse value) {
        return new JAXBElement<AgeLyliaResponse>(_AgeLyliaResponse_QNAME, AgeLyliaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgeLylia }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicesWeb/", name = "ageLylia")
    public JAXBElement<AgeLylia> createAgeLylia(AgeLylia value) {
        return new JAXBElement<AgeLylia>(_AgeLylia_QNAME, AgeLylia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AfficheLylia }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicesWeb/", name = "afficheLylia")
    public JAXBElement<AfficheLylia> createAfficheLylia(AfficheLylia value) {
        return new JAXBElement<AfficheLylia>(_AfficheLylia_QNAME, AfficheLylia.class, null, value);
    }

}
