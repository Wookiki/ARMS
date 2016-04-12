package arms.web.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.login.svc.GiveHostIdService;
import arms.web.login.vo.UserInfo;

public class GrantHostIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		UserInfo userInfo = new UserInfo();
		userInfo.setU_hostId(request.getParameter("hId"));
		
		modifyHostIdService giveHostIdService = new modifyHostIdService(); 
		boolean giveSuccess = 
		
		
		return null;
	}

}
