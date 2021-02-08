package net.gondr.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import net.gondr.domain.BoardVO;
import net.gondr.domain.UserVO;
import net.gondr.service.BoardService;

public class CheckIsUser implements HandlerInterceptor {
	
	@Autowired
	private BoardService service;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if(session != null) {
			UserVO user = (UserVO) session.getAttribute("user");
			if(user != null) {
				Map<?, ?> pathVariables = (Map<?, ?>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
//				System.out.println(pathVariables.get("id"));
				int id = Integer.parseInt((String) pathVariables.get("id"));
				BoardVO board = service.viewArticle(id);
//				System.out.println("board.getWriter(): " + board.getWriter());
//				System.out.println("user.getUserid(): " + user.getUserid());
				if(board.getWriter().equals(user.getUserid())) {
					return true;
				} else {
					response.sendRedirect("/");
					return false;
				}
				
			}
		}
		
		response.sendRedirect("/user/login");
		return false;
	}
}
