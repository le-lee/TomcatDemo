package exm02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;

public class RequestFacade implements ServletRequest{
	private ServletRequest request = null;
	public RequestFacade(Request request) { 
		this.request = request; 
	}

	/*implementation of ServletRequest*/
	@Override
	public Object getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return request.getAttribute(arg0);
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return request.getAttributeNames();
	}

	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return request.getCharacterEncoding();
	}

	@Override
	public int getContentLength() {
		// TODO Auto-generated method stub
		return request.getContentLength();
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return request.getContentType();
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return request.getInputStream();
	}

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return request.getLocale();
	}

	@Override
	public Enumeration<Locale> getLocales() {
		// TODO Auto-generated method stub
		return request.getLocales();
	}

	@Override
	public String getParameter(String arg0) {
		// TODO Auto-generated method stub
		return request.getParameter(arg0);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		return request.getParameterMap();
	}

	@Override
	public Enumeration<String> getParameterNames() {
		// TODO Auto-generated method stub
		return request.getAttributeNames();
	}

	@Override
	public String[] getParameterValues(String arg0) {
		// TODO Auto-generated method stub
		return request.getParameterValues(arg0);
	}

	@Override
	public String getProtocol() {
		// TODO Auto-generated method stub
		return request.getProtocol();
	}

	@Override
	public BufferedReader getReader() throws IOException {
		// TODO Auto-generated method stub
		return request.getReader();
	}

	@Override
	public String getRealPath(String arg0) {
		// TODO Auto-generated method stub
		return request.getRealPath(arg0);
	}

	@Override
	public String getRemoteAddr() {
		// TODO Auto-generated method stub
		return request.getRemoteAddr();
	}

	@Override
	public String getRemoteHost() {
		// TODO Auto-generated method stub
		return request.getRemoteHost();
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String arg0) {
		// TODO Auto-generated method stub
		return request.getRequestDispatcher(arg0);
	}

	@Override
	public String getScheme() {
		// TODO Auto-generated method stub
		return request.getScheme();
	}

	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return request.getServerName();
	}

	@Override
	public int getServerPort() {
		// TODO Auto-generated method stub
		return request.getServerPort();
	}

	@Override
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return request.isSecure();
	}

	@Override
	public void removeAttribute(String arg0) {
		// TODO Auto-generated method stub
		request.removeAttribute(arg0);
	}

	@Override
	public void setAttribute(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		request.setAttribute(arg0, arg1);
	}

	@Override
	public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(arg0);
	}

}
