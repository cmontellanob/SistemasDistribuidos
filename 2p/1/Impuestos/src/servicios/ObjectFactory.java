
package servicios;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servicios package. 
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

    private final static QName _ObtenerDeuda_QNAME = new QName("http://servicios/", "obtenerDeuda");
    private final static QName _ObtenerDeudaResponse_QNAME = new QName("http://servicios/", "obtenerDeudaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servicios
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerDeuda }
     * 
     */
    public ObtenerDeuda createObtenerDeuda() {
        return new ObtenerDeuda();
    }

    /**
     * Create an instance of {@link ObtenerDeudaResponse }
     * 
     */
    public ObtenerDeudaResponse createObtenerDeudaResponse() {
        return new ObtenerDeudaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerDeuda }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "obtenerDeuda")
    public JAXBElement<ObtenerDeuda> createObtenerDeuda(ObtenerDeuda value) {
        return new JAXBElement<ObtenerDeuda>(_ObtenerDeuda_QNAME, ObtenerDeuda.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerDeudaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "obtenerDeudaResponse")
    public JAXBElement<ObtenerDeudaResponse> createObtenerDeudaResponse(ObtenerDeudaResponse value) {
        return new JAXBElement<ObtenerDeudaResponse>(_ObtenerDeudaResponse_QNAME, ObtenerDeudaResponse.class, null, value);
    }

}
