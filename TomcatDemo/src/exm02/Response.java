package exm02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
/*
  A HTTP Response exmaple:
  <tr>
  HTTP/1.1 200 OK
  Server: Microsoft-IIS/4.0
  Date: Mon, 5 Jan 2004 13:13:33 GMT
  Content-Type: text/html
  Last-Modified: Mon, 5 Jan 2004 13:13:12 GMT
  Content-Length: 112
  
  <html>
  <head>
  <title>HTTP Response Example</title>
  </head>
  <body>
  Welcome to Neo's HTTPServer
  </body>
  </html>
  <!-- the head and the content are seprated by CRLF-->
 
 */
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class Response implements ServletResponse{
	
	private static final int BUFFER_SIZE = 1024;
	OutputStream output;
	Request request;
	PrintWriter writer;
	

	Response(OutputStream output){
		this.output = output;
	}
	
	public void setRequest(Request request) {
		this.request = request;
	}

	public void sendStaticResource() throws IOException {
		byte[]bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try{
			File file = new File(HttpServer1.WEB_ROOT,request.getUri());
			if(file.exists()){
				fis = new FileInputStream(file);
				int ch = fis.read(bytes, 0, BUFFER_SIZE);
				while( ch != -1){
					output.write(bytes, 0, ch);
					ch = fis.read(bytes, 0, BUFFER_SIZE);
				}
			}
			else{
				//file not found
				String errorMessage = 
						"HTTP/1.1 404 File Not Found\r\n"+
						"Content-Type: text/html\r\n"+
						"Content-Length: 23\r\n" + 
						"\r\n" + 
						"<h1> File Not Found</h1>";
				output.write(errorMessage.getBytes());
			}
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		finally{
			if(fis != null)
				fis.close();
		}
	}

	/*implementation of ServletResponse*/
	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		//autoflush is true, println() will flush
		//but print() will not
		writer = new PrintWriter(output,true);
		return writer;
	}

	@Override
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetBuffer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBufferSize(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContentLength(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContentType(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLocale(Locale arg0) {
		// TODO Auto-generated method stub
		
	}
}
