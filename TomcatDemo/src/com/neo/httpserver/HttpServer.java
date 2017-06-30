package com.neo.httpserver;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
	public static final String WEB_ROOT = 
			System.getProperty("user.dir") + File.separator + "webroot";
	public static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	Request request;
	Response response;
	ServerSocket serverSocket;
	private boolean shutdown = false;

	public static void main(String[] args) {
		HttpServer server = new HttpServer();
		server.await();
	}
	public void await() {
		int port = 80;
		Socket socket = null;
		InputStream input = null;
		OutputStream output = null;
		try {
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		//Loop waiting for a request
		while(!shutdown){	
			try {
				socket  = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				Request request = new Request(input);
				request.parse();
				Response  response = new Response(output);
				response.setRequest(request);
				response.sendStaticResource();
				shutdown = request.getRequest().equals(SHUTDOWN_COMMAND);
			} catch (Exception e) {
				e.printStackTrace();
				continue;	//if catch a exception, continue after dealing with it
			}
		}
	}

}
