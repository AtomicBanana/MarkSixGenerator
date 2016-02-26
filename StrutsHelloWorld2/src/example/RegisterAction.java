package example;
//import statements
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RegisterAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
 			HttpServletRequest request, HttpServletResponse response)
 					throws IOException, ServletException {
		String target = new String("success");
		String password = null;
		String email = null;
		
 	 	if ( form != null ) {
 	 	 	// Use the NameForm to get the request parameters
 	 		RegisterForm registerForm = (RegisterForm)form;
 	 		password = registerForm.getPassword();
 	 		email = registerForm.getEmail();
 	 	}	 
 	 	// if no mane supplied Set the target to failure
 	 	if ( password == null || email == null) {
 	 	 	target = new String("failure");
 	 	}
 	 	else {
 	 	 	request.setAttribute("PASSWORD", password);
 	 	 	request.setAttribute("EMAIL", email);
 	 	}
 	return (mapping.findForward(target));
	}
}