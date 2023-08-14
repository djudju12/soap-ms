
package products;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="response" type="{http://www.soapws.com/products}deleteResponse"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "response"
})
@XmlRootElement(name = "DeleteProductResponse", namespace = "http://www.soapws.com/products")
public class DeleteProductResponse {

    @XmlElement(namespace = "http://www.soapws.com/products", required = true)
    protected DeleteResponse response;

    /**
     * Obtém o valor da propriedade response.
     * 
     * @return
     *     possible object is
     *     {@link DeleteResponse }
     *     
     */
    public DeleteResponse getResponse() {
        return response;
    }

    /**
     * Define o valor da propriedade response.
     * 
     * @param value
     *     allowed object is
     *     {@link DeleteResponse }
     *     
     */
    public void setResponse(DeleteResponse value) {
        this.response = value;
    }

}
