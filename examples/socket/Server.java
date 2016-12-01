import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) throws IOException {
		try {
			ServerSocket server = new ServerSocket(8080);
			System.out.println("Server started on port 8080, waiting for client");
			Socket client = server.accept();
			System.out.println("Client connected...");
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

			String input = in.readLine();
			while (input != null) {
				if(input == null) continue;
				System.out.println("Client sent >>> " + input);
				out.println(input);
				input = in.readLine();
			}
			System.out.println("Client disconnected. I am exiting.");
		} catch (IOException e){
			System.err.println("Error listening on port 8080");
		}

	}
}