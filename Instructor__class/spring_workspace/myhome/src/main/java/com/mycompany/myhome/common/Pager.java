package com.mycompany.myhome.common;

import javax.servlet.http.HttpServletRequest;

//  <%=Pager.makeTag(request, 10, 32)%>
//    첫번째 파라미터, request 객체
//    두번째 파라미터, 한 페이지당 보여야 할 데이터 개수 
//    세번째 파라미터, 전체 데이터개수, 페이지 수 계산하려고 
//                  전체 데이터: 340, 한페이지당 라인수 : 10개면 
//                  34페이지가 있어야 한다 

public class Pager {
		
	//함수, 페이지 태그를 만드는 함수 
	//<a href= .....
	public static String makeTag(HttpServletRequest request , int pageSize , int total) {
		String Tag = "" ; 
		String contextPath = request.getContextPath();
		
		// << < 1 2 3 4 5 6 7 8 9 10 > >> 
		
		int cpage; //현재페이지 정보
		// 12/10 -> ceiling(1.2) -> 2   
		int pageTotal; //전체 페이지 개수  - 전체데이터개수/페이지사이즈 
		int pageGroupSize = 10; 	//한 그룹당 보여질 페이지 수 
		
		//1 ~10 
		//11 ~ 20
		//21 ~ 30
		int pageGroupStart; //1,6,11,16,... 그룹의 시작
		int pageGroupEnd;   //5,10,15,.... 그룹의 끝

		String path="";
		//System.out.println(path);
		String beginLabel 	= "<<";
		String prevLabel 	= "<";
		String nextLabel 	= ">";
		String endLabel 	= ">>";	

		
		try {

			StringBuffer sb = new StringBuffer();
			
			//http://localhost:9000/MyHome/freeboard.do?pg=1
			//페이지 파라미터를 pg로 넘겨야 한다 
			String page = request.getParameter("pg") ;
			page = ( page == null ) ? "0" : page ; 
			
//			setPg(Integer.parseInt(page)) ; 
//			setTotalCnt(Integer.parseInt(totCnt)) ; 
	
			cpage = Integer.parseInt(page) ; 

			pageTotal = (int)Math.ceil((total - 1) / pageSize);
			//total - 전체 데이터 건수 
			//전체 페이지 개수 구하기 
            
			//페이지 그룹값 설정하기 만일 현재 12페이지라면 그룹은 2가 되어야 한다 
			//그룹의 시작 : 11 이어야 한다. 현재페이지/그룹크기 * 그룹의 사이즈 
			pageGroupStart = (int) (cpage / pageGroupSize) * pageGroupSize;
			pageGroupEnd = pageGroupStart + pageGroupSize;
			
			//마지막 그룹일때는 그룹의 마지막페이지는 그룹의 전체 페이지 지정
			if (pageGroupEnd > pageTotal) {
				pageGroupEnd = pageTotal + 1;
			}
            //0~4, 5~9, 10~14, 15~19
			//앞서 이동할 페이지가 있는지 확인하기 위한 변수들 
			//현재페이지 - 그룹사이즈 가 0보다 크면 앞으로 이동할 페이지가있는거라
			//true 아니면 false값 
			boolean hasPreviousPage = cpage - pageGroupSize >= 0;
			//이동할 앞 그룹이 있는지 여부를 판단한다 
			boolean hasNextPage = pageGroupStart + pageGroupSize < pageTotal;
			
			
			sb.append("<ul class='pagination'>\r\n") ;  
			
			sb.append((cpage > 0) ? makeLink(0, beginLabel) : 
				        "<li class=\"page-item\"><a class=\"page-link\"  href='#'>"+beginLabel+"</a></li>");
			sb.append(hasPreviousPage ? makeLink(pageGroupStart - 1, prevLabel) : 
				        "<li class=\"page-item\"><a class=\"page-link\"  href='#'>"+prevLabel+"</a></li>");
			
			for (int i = pageGroupStart; i < pageGroupEnd; i++) {
				if (i == cpage) {
					//sb.append(i + 1); 
					sb.append(makeLink(i, (i + 1) + ""));
				} else {
					sb.append(makeLink(i, (i + 1) + ""));
				}
			}
			

			sb.append(hasNextPage ? makeLink(pageGroupEnd, nextLabel) : 
				"<li class=\"page-item\"> <a class=\"page-link\" href='#'>"+nextLabel+"</a></li>");
			sb.append((cpage < pageTotal) ? makeLink(pageTotal, endLabel) : 
				"<li class=\"page-item\"><a class=\"page-link\"  href='#'>"+endLabel+"</a></li>");
		
			sb.append("</ul>\r\n") ;  		
			Tag = sb.toString() ; 	
		} catch ( Exception e ) {
			e.printStackTrace() ; 
		}
			
		return Tag ; 
	}

	public static String makeLink(int page, String label) 
	{
		StringBuffer tmp = new StringBuffer();
		tmp.append("<li class=\"page-item\"><a class=\"page-link\"  href=\"javascript:goPage('" + page + "')\">").append(label).append("</a></li>");
		return tmp.toString();
	}
	
	
	
	
	
}
