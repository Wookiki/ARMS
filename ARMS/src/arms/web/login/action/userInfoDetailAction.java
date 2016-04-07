package arms.web.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.login.svc.UserInfoDetailService;
import arms.web.login.vo.UserInfo;

public class userInfoDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		UserInfo userInfoView = new UserInfo();
		
		String id = request.getParameter("id");
		
		
		UserInfoDetailService userInfoDetailService = new UserInfoDetailService();
		userInfoView = userInfoDetailService.getUserInfo(id);
		
		request.setAttribute("userInfoView", userInfoView);
		ActionForward forward = new ActionForward();
		forward.setUrl("main.jsp");
		
		return forward;
	}

}
