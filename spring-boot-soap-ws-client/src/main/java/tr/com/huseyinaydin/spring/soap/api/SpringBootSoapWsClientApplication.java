package tr.com.huseyinaydin.spring.soap.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tr.com.huseyinaydin.spring.soap.api.client.SoapClient;
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

@SpringBootApplication
@RestController
public class SpringBootSoapWsClientApplication {

	@Autowired
	private SoapClient client;
	
	@PostMapping("/getLoanStatus")
	public Acknowledgement invokeSoapClientToGetLoanStatus(@RequestBody CustomerRequest request) {
		return client.getLoanStatus(request);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapWsClientApplication.class, args);
	}
}