package tr.com.huseyinaydin.spring.soap.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import tr.com.huseyinaydin.spring.soap.api.loaneligibility.Acknowledgement;
import tr.com.huseyinaydin.spring.soap.api.loaneligibility.CustomerRequest;

//بسم الله الرحمن الرحيم

/**
* 
* @author Huseyin_Aydin
* @since 1994
* @category Java, Spring Boot, SOAP(Simple Object Access) Web Services.
* 
*/

@Service
public class SoapClient {

	@Autowired
	private Jaxb2Marshaller marshaller;

	private WebServiceTemplate template;

	public Acknowledgement getLoanStatus(CustomerRequest request) {
		template = new WebServiceTemplate(marshaller);
		Acknowledgement acknowledgement = (Acknowledgement) template.marshalSendAndReceive("http://localhost:8080/ws",
				request);
		return acknowledgement;
	}
}