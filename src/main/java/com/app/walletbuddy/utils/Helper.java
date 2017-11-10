package com.app.walletbuddy.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.walletbuddy.service.TransactionService;

public class Helper {
	 
	
	public static String getWalletCurrentBallance(int userId, TransactionService transactionService) {
		
		List<Object[]> transRaw = transactionService.listTransactionsMyWalletBallance(userId);	

		float tmp = 0.0f;
		for(Object[] o : transRaw) 
			tmp += Float.parseFloat( o[0].toString() );  
		
		String style = tmp<0? "color:red;" : "color:green";
		
		
		return "<span style='margin-left:-190px; margin-top:10px;font-size:24px; font-weight:bold;position:absolute;"+style+"' >"+String.format("%.02f", tmp)+"</span>";
	}
	
	public static String cleanInputString(String input) {

		String pattern = "\\W"; 
		String pattern2 = "\\d"; 
		String replaceWith = "";
		String result = "";

		Pattern p = Pattern.compile(pattern);

		Matcher m = p.matcher(input);

		StringBuffer sb = new StringBuffer();

		while(m.find()) {
			m.appendReplacement(sb, replaceWith);
		}
		m.appendTail(sb);
		result = sb.toString();

		p = Pattern.compile(pattern2);
		m = p.matcher(result);
		sb = new StringBuffer();
		while(m.find()) {
			m.appendReplacement(sb, replaceWith);
		}
		m.appendTail(sb);

		return sb.toString();
	}

	
	public static boolean validateEmail(String emailStr) {
		Pattern VALID_EMAIL_ADDRESS_REGEX =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
	
	public static String cleanInputStringFromSpecialChars(String input) {
		String result = "";
		
		if(input.length()>33) {
			result = input.substring(0, 33).replaceAll("[^a-zA-Z0-9\\s]","");
			result += "...";
			return result;
		}
		else	
		    return  input.replaceAll("[^a-zA-Z0-9\\s]","");
	} 
	
	public static String checkNumber(String input) {
		
		if(validateInteger(input) || validateFloat(input)) {
			if(input.length() > 7)
				return input.substring(0,7);
			else
			    return input;
		}
		else {  
			String result = input.replaceAll("[^0-9]","");  
			if(result.length() > 7)
				return result.substring(0,7);
			else if(result.length() == 0)
				return "0";
			else
			    return result;
		}
	}
	public static boolean validateInteger(String input) {
		Pattern REGEX =  Pattern.compile("^[0-9]{1,7}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = REGEX .matcher(input);
		return matcher.find();
	}
	public static boolean validateFloat(String input) {
		Pattern REGEX =  Pattern.compile("^[0-9]{1,7}\\.[0-9]{1,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = REGEX .matcher(input);
		return matcher.find();
	}
	
	

}
