package com.neo.httpserver;

import java.io.OutputStream;
/**
 * @author lile
 */
public class Response {
	/**
	 * A HTTP Response exmaple:
	 * <tr>
	 * HTTP/1.1 200 OK
	 * Server: Microsoft-IIS/4.0
	 * Date: Mon, 5 Jan 2004 13:13:33 GMT
	 * Content-Type: text/html
	 * Last-Modified: Mon, 5 Jan 2004 13:13:12 GMT
	 * Content-Length: 112
	 * 
	 * <html>
	 * <head>
	 * <title>HTTP Response Example</title>
	 * </head>
	 * <body>
	 * Welcome to Neo's HTTPServer
	 * </body>
	 * </html>
	 * <!-- the head and the content are seprated by CRLF-->
	 *
	 */
	OutputStream os;
	Request request;
	

	Response(OutputStream os){
		this.os = os;
	}
	
	public void response(){
		
	}
	
	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public void sendStaticResource() {
		
	}
}
