package example;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class LuckyDrawForm extends ActionForm{
	private String numbers = null;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
 	 	this.setNumbers(null);
 	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}
	
}
