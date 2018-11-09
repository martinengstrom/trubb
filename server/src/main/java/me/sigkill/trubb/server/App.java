package me.sigkill.trubb.server;

import me.sigkill.trubb.common.util.PropertiesUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class App {
	static final int PORT = 1337;

	public static void main(String[] args) throws IOException {
		PropertiesUtil propertis = new PropertiesUtil();
		ServerSocket serverSocket = new ServerSocket(propertis.getGamePort());
		while (true) {
			Socket socket = serverSocket.accept();
			new SocketClientThread(socket).start();
		}
    }
}
