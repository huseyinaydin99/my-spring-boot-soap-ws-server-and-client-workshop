package tr.com.huseyinaydin.spring.soap.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import tr.com.huseyinaydin.spring.soap.api.loaneligibility.Acknowledgement;
import tr.com.huseyinaydin.spring.soap.api.loaneligibility.CustomerRequest;
import tr.com.huseyinaydin.spring.soap.api.service.LoanEligibilityService;

//بسم الله الرحمن الرحيم

/**
* 
* @author Huseyin_Aydin
* @since 1994
* @category Java, Spring Boot, SOAP(Simple Object Access) Web Services.
* 
*/

@Endpoint
public class LoanEligibilityindicatorEndpoint {

	private static final String NAMESPACE = "http://www.huseyinaydin.com.tr/spring/soap/api/loanEligibility";
	
	@Autowired
	private LoanEligibilityService service;

	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkLoanEligibility(request);
	}
}