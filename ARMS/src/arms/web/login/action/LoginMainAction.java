package arms.web.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.login.svc.LoginMainService;

public class LoginMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		LoginMainService loginMainService = new LoginMainService(); 
		loginMainService.getLogin();
		
		
		ActionForward forward = new ActionForward();
		forward.setUrl("loginMain.jsp");
		return forward;
	}

}
