package arms.web.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.login.svc.LoginMainService;
import arms.web.login.vo.UserInfo;

public class LoginMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		UserInfo loginUser = null;
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		
		LoginMainService loginMainService = new LoginMainService();
		loginUser = loginMainService.checkLogin(id, passwd);
		
		ActionForward forward = new ActionForward();
		if(loginUser !=null){
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setUrl("main.jsp");
		}
		return forward;
	}

}
