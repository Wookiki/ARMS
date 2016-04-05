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
		String u_id = request.getParameter("id");
		
		LoginMainService loginMainService = new LoginMainService();
		UserInfo loginUser = loginMainService.getLoginUser(u_id);
		ActionForward forward = new ActionForward();
		if(loginUser !=null){
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setUrl("main.jsp");
		}
		return forward;
	}

}
