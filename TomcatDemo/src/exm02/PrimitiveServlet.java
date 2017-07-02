package exm02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PrimitiveServlet implements Servlet{
	
	@Override
	//servlet容器只调用一次这个方法
	//只需要运行一次的初始化代码，可以放到该方法中,加载数据库驱动，值初始化
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}
	
	@Override
	//在serlvet生命周期中将会被调用多次
	public void service(ServletRequest request, ServletResponse response) 
			throws ServletException, IOException {
		System.out.println("from service");
		PrintWriter out = response.getWriter();
		out.println("Hello. Roses are red");
		out.println("Violets are blue");
	}
	
	@Override
	//从服务中移除一个servlet实例的时候，调用该方法
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}
	
}
