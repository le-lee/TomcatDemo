package exm01.learn;

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

public class Response {
	
	private static final int BUFFER_SIZE = 1024;
	OutputStream output;
	Request request;

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
			File file = new File(HttpServer.WEB_ROOT,request.getUri());
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
}
