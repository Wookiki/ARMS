package arms.web.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;

public class joinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String u_id = request.getParameter("id");
		String u_passwd = request.getParameter("passwd");
		String u_name = request.getParameter("dong");
		int u_ho = Integer.parseInt(request.getParameter("ho"));
		String u_tel = request.getParameter("tel");
		int u_car = Integer.parseInt(request.getParameter("car"));
		
		
		return null;
	}

}
