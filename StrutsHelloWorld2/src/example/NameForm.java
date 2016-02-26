package example;
//import statements
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class NameForm extends ActionForm{
	private String name = null;
	
	public String getName() {
	 	 	return (name);
	 }	 
 	public void setName(String name) {
 	 	this.name = name;
 	}	 
 	public void reset(ActionMapping mapping, HttpServletRequest request) {
 	 	this.name = null;
 	}	 
}
