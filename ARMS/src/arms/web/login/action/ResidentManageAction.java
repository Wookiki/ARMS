package arms.web.login.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.login.svc.ResidentListService;
import arms.web.login.vo.UserInfo;

public class ResidentManageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ResidentListService residentListService = new ResidentListService();
		ArrayList<UserInfo> residentList = residentListService.getResidentList();
		ActionForward forward = new ActionForward();
		request.setAttribute("residentList", residentList);
		forward.setUrl("residentManagement.jsp");
		return forward;
	}

}
