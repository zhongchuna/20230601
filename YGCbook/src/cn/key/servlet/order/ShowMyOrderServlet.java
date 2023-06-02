package cn.key.servlet.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.key.dao.OrderMainDAO;
import cn.key.entity.CustomerInfo;
import cn.key.entity.OrderMain;

public class ShowMyOrderServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerInfo customer = (CustomerInfo) session.getAttribute("customer");
		String path = "/background/Error.jsp";
		String returnPath = "/egou/login.jsp";
		String title = "����û�е�¼�������ȵ�¼";
		if(customer != null) {
			OrderMainDAO dao = new OrderMainDAO();
			List<OrderMain> mains = dao.findById(customer.getCustomerId());
			if (mains.size() != 0) {
				request.setAttribute("orderMains", mains);
				path = "customerOrderForm.jsp";
			}else{
				title = "�������κζ�����������ѡ�����ǵ���Ʒ��";
				returnPath = "/FindBookTypeServlet";
			}
		}
		request.setAttribute("title",title);
		request.setAttribute("returnPath",returnPath);
		request.getRequestDispatcher(path).forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
