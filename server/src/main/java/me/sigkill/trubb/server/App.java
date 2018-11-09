package me.sigkill.trubb.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class App {
	static final int PORT = 1337;

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(PORT);
		while (true) {
			Socket socket = serverSocket.accept();
			new SocketClientThread(socket).start();
		}
    }
}
