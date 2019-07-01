
package wsbanco;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsbanco package. 
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

    private final static QName _ObtenerCotizacion_QNAME = new QName("http://wsBanco/", "ObtenerCotizacion");
    private final static QName _ObtenerCotizacionResponse_QNAME = new QName("http://wsBanco/", "ObtenerCotizacionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsbanco
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerCotizacion }
     * 
     */
    public ObtenerCotizacion createObtenerCotizacion() {
        return new ObtenerCotizacion();
    }

    /**
     * Create an instance of {@link ObtenerCotizacionResponse }
     * 
     */
    public ObtenerCotizacionResponse createObtenerCotizacionResponse() {
        return new ObtenerCotizacionResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerCotizacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsBanco/", name = "ObtenerCotizacion")
    public JAXBElement<ObtenerCotizacion> createObtenerCotizacion(ObtenerCotizacion value) {
        return new JAXBElement<ObtenerCotizacion>(_ObtenerCotizacion_QNAME, ObtenerCotizacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerCotizacionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsBanco/", name = "ObtenerCotizacionResponse")
    public JAXBElement<ObtenerCotizacionResponse> createObtenerCotizacionResponse(ObtenerCotizacionResponse value) {
        return new JAXBElement<ObtenerCotizacionResponse>(_ObtenerCotizacionResponse_QNAME, ObtenerCotizacionResponse.class, null, value);
    }

}
