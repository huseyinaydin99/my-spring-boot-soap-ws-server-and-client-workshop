package tr.com.huseyinaydin.spring.soap.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
public class LoanEligibilityService {

	public Acknowledgement checkLoanEligibility(CustomerRequest request) {
		Acknowledgement acknowledgement = new Acknowledgement();
		List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();

		if (!(request.getAge() > 30 && request.getAge() <= 60)) {
			mismatchCriteriaList.add("Kişinin yaşı 30 ila 60 arasında olmalıdır");
		}
		if (!(request.getYearlyIncome() > 200000)) {
			mismatchCriteriaList.add("Asgari gelir 200000'den fazla olmalı");
		}
		if (!(request.getCibilScore() > 500)) {
			mismatchCriteriaList.add("Düşük cibil puanı lütfen 6 ay sonra deneyin. CIBIL Puanı, kredi geçmişiniz, notunuz ve raporunuzun 3 haneli sayısal özetidir ve 300 ile 900 arasında değişir. Puanınız 900'e ne kadar yakınsa kredi notunuz o kadar iyidir. CIBIL'de kredi geçmişi ve kredi raporu ne anlama geliyor? Kredi istediğinizde kendinize CIBIL puanım kaç diye sormalısınız.");
		}

		if (mismatchCriteriaList.size() > 0) {
			acknowledgement.setApprovedAmount(0);
			acknowledgement.setIsEligible(false);
		} else {
			acknowledgement.setApprovedAmount(500000);
			acknowledgement.setIsEligible(true);
			mismatchCriteriaList.clear();
		}
		return acknowledgement;
	}
}