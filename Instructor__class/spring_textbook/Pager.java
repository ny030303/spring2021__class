package com.mycompany.myhome.common;

import javax.servlet.http.HttpServletRequest;

//  <%=Pager.makeTag(request, 10, 32)%>
//    ù��° �Ķ����, request ��ü
//    �ι�° �Ķ����, �� �������� ������ �� ������ ���� 
//    ����° �Ķ����, ��ü �����Ͱ���, ������ �� ����Ϸ��� 
//                  ��ü ������: 340, ���������� ���μ� : 10���� 
//                  34�������� �־�� �Ѵ� 

public class Pager {
		
	//�Լ�, ������ �±׸� ����� �Լ� 
	//<a href= .....
	public static String makeTag(HttpServletRequest request , int pageSize , int total) {
		String Tag = "" ; 
		String contextPath = request.getContextPath();
		
		// << < 1 2 3 4 5 6 7 8 9 10 > >> 
		
		int cpage; //���������� ����
		// 12/10 -> ceiling(1.2) -> 2   
		int pageTotal; //��ü ������ ����  - ��ü�����Ͱ���/������������ 
		int pageGroupSize = 10; 	//�� �׷�� ������ ������ �� 
		
		//1 ~10 
		//11 ~ 20
		//21 ~ 30
		int pageGroupStart; //1,6,11,16,... �׷��� ����
		int pageGroupEnd;   //5,10,15,.... �׷��� ��

		String path="";
		//System.out.println(path);
		String beginLabel 	= "<<";
		String prevLabel 	= "<";
		String nextLabel 	= ">";
		String endLabel 	= ">>";	

		
		try {

			StringBuffer sb = new StringBuffer();
			
			//http://localhost:9000/MyHome/freeboard.do?pg=1
			//������ �Ķ���͸� pg�� �Ѱܾ� �Ѵ� 
			String page = request.getParameter("pg") ;
			page = ( page == null ) ? "0" : page ; 
			
//			setPg(Integer.parseInt(page)) ; 
//			setTotalCnt(Integer.parseInt(totCnt)) ; 
	
			cpage = Integer.parseInt(page) ; 

			pageTotal = (int)Math.ceil((total - 1) / pageSize);
			//total - ��ü ������ �Ǽ� 
			//��ü ������ ���� ���ϱ� 
            
			//������ �׷찪 �����ϱ� ���� ���� 12��������� �׷��� 2�� �Ǿ�� �Ѵ� 
			//�׷��� ���� : 11 �̾�� �Ѵ�. ����������/�׷�ũ�� * �׷��� ������ 
			pageGroupStart = (int) (cpage / pageGroupSize) * pageGroupSize;
			pageGroupEnd = pageGroupStart + pageGroupSize;
			
			//������ �׷��϶��� �׷��� �������������� �׷��� ��ü ������ ����
			if (pageGroupEnd > pageTotal) {
				pageGroupEnd = pageTotal + 1;
			}
            //0~4, 5~9, 10~14, 15~19
			//�ռ� �̵��� �������� �ִ��� Ȯ���ϱ� ���� ������ 
			//���������� - �׷������ �� 0���� ũ�� ������ �̵��� ���������ִ°Ŷ�
			//true �ƴϸ� false�� 
			boolean hasPreviousPage = cpage - pageGroupSize >= 0;
			//�̵��� �� �׷��� �ִ��� ���θ� �Ǵ��Ѵ� 
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
