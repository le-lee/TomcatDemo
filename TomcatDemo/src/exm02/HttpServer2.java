package exm02;


import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer2 {
	
	
	public static final String WEB_ROOT = 
			System.getProperty("user.dir") + File.separator + "webroot";
	//shutdown command
	public static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	
	//the shutdown command received
	private boolean shutdown = false;
	
//	ServerSocket serverSocket = null;

	public static void main(String[] args) {
		HttpServer2 server = new HttpServer2();
		server.await();
	}
	public void await() {
		ServerSocket serverSocket = null;
		int port = 8080;
//		Socket socket = null;
//		InputStream input = null;
//		OutputStream output = null;
//		差别所在
		try {
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		//Loop waiting for a request
		while(!shutdown){
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			try {
				socket  = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				
				//create Request object and parse
				Request request = new Request(input);
				request.parse();
				System.out.println(request.getUri());
				
				
				//create Response object
				Response  response = new Response(output);
				response.setRequest(request);
				response.sendStaticResource();
				
				//check if this is a request for a serlvet or a static resource
				//a request for a servlet begins with "/servlet/"
				if(request.getUri().startsWith("/servlet")){
					ServletProcessor1 processor = new ServletProcessor1();
					processor.process(request,response);
				}
				else{
					StaticResourceProcessor processor = 
							new StaticResourceProcessor();
					processor.process(request,response);
				}
				
				//Close the socket
				socket.close();
				
				//check if the previous URI is a shutdown command
				shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
			} catch (Exception e) {
				e.printStackTrace();
				continue;	//if catch a exception, continue after dealing with it
			}
		}
	}

}

