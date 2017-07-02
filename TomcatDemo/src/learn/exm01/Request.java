package learn.exm01;

import java.io.IOException;
import java.io.InputStream;
/**
 * A HTTP Request Demo
 * <tr>
 * POST /examples/default.jsp HTTP/1.1   
 * Accept: text/plain; text/html
 * Accept-Language:en-gb
 * Conncetion:keep-Alive
 * Host:localhost
 * User-Agent: Mozilla/4.0(compatible;MSIE 4.01;Windows 98)
 * Content-Length:33
 * Content-Type: application/x-www-form-urlencoded
 * Accept-Encoding:gzip,delfate
 * 
 * lastName=Franks&firstName=Michael
 * <tr>
 * @author lile
 *
 */
public class Request {
	
	private InputStream input;
	private String uri;
	
	public Request(InputStream input){
		this.input = input;
	}
	
	public void parse(){
		//Read a set of characters from the socket
		//why use the StringBuffer
		//the difference between StringBuilder StringBuffer String 
		StringBuffer request = new StringBuffer(2048);
		int i;
		byte[] buffer = new byte[2048];
		try{
			i = input.read(buffer);
		}
		catch(IOException e){
			e.printStackTrace();
			i = -1;
		}
		for(int j = 0; j < i; j++){
			request.append((char)buffer[j]);
		}
		System.out.println(request.toString());
		uri = parseUri(request.toString());
	}
	
	private String parseUri(String requestString){
		int index1, index2;
		//the index of the first occurrence of the character in the character sequence 
		//represented by this object, or -1 if the character does not occur.
		index1 = requestString.indexOf(' ');
		if(index1 != -1){
			index2 = requestString.indexOf(' ', index1 + 1);
			if(index2 > index1){
				return requestString.substring(index1 + 1, index2);
			}
		}
		return null;
	}
	
	public String getUri(){
		return uri;
	}
}
