package me.sigkill.trubb.client;

import me.sigkill.trubb.common.models.request.GameGuessRequest;
import me.sigkill.trubb.common.models.response.GameStateResponse;
import me.sigkill.trubb.common.util.PropertiesUtil;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
	static final int PORT = 1337;
	private static Socket socket;

	public static void main(String[] args) throws IOException, InterruptedException {
		PropertiesUtil properties = new PropertiesUtil();
		socket = new Socket(properties.getGameHost(), properties.getGamePort());

		//socket.connect(new InetSocketAddress("127.0.0.1", PORT));

		clearScreen();
		System.out.println("Connected to remote host.");
		/*
		ObjectOiutputStream ous = new ObjectOutputStream(socket.getOutputStream());
		TrubbRequest req = new TrubbRequest();
		req.setName("Trubb");
		ous.writeObject(req);
		ous.close();
		*/
		AsciiArtHelper asciiArtHelper = new AsciiArtHelper();
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream ous = new ObjectOutputStream(socket.getOutputStream());

		while (true) {
			checkConnection();
			GameStateResponse gameState = getGameState(ois);

			if (gameState == null) {
				Thread.sleep(100);
				continue;
			}

			if (gameState.getCorrectGuessCount().equals(gameState.getWordLetterCount()))
				break;

			clearScreen();
			asciiArtHelper.print((gameState.getTries().getRemaining() - 10) * -1);
			showMenu(gameState);
			Scanner s= new Scanner(System.in);
			char x = s.next().charAt(0);
			sendGuess(x, ous);
		}

		ous.close();
		ois.close();
    }

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	private static void showMenu(GameStateResponse state) {
		String guessedLetters = state.getGuessedLetters().stream().collect(Collectors.joining(" "));
		System.out.print(String.format("%n%n(%s)%n[%d/%d] > ", guessedLetters, state.getTries().getRemaining(), state.getTries().getTotal()));
	}

    private static GameStateResponse getGameState(ObjectInputStream ois) {
		try {
			checkConnection();
			Object obj = ois.readObject();
			if (obj instanceof GameStateResponse)
				return (GameStateResponse)obj;
			else if (obj instanceof Exception)
				throw new RuntimeException((Exception)obj);
			return  null;
		} catch (IOException | ClassNotFoundException e) {
			return null;
		}
	}

	private static void sendGuess(char c, ObjectOutputStream ous) throws IOException {
		checkConnection();
		GameGuessRequest req = new GameGuessRequest();
		req.setLetter(c);

		ous.writeObject(req);
		ous.flush();
	}

    private static void print(String message) {
		System.out.println(message);
	}

	private static void checkConnection() {
		if (!socket.isConnected())
			throw new RuntimeException("Socket disconnected");
	}
}
