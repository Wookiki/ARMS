package arms.web.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.login.svc.JoinService;
import arms.web.login.vo.UserInfo;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		JoinService joinService = new JoinService();
		UserInfo userInfo = new UserInfo();
		ActionForward forward = new ActionForward();
		forward.setUrl("loginMain.jsp");
		return forward;
	}

}
