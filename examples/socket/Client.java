import java.io.*;
import java.net.*;
import java.util.Scanner;


//10.150.0.172

public class Client {
	public static void main(String[] args){
		if(args.length != 1){
			System.err.println("Usage: java Client <host name>");
			System.exit(1);
		}

		String host = args[0];
		Scanner scanner = new Scanner(System.in);
		try {
			Socket client = new Socket(host, 8080);
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

			System.out.println("Tell the server someting ('exit' to quit)\n");
			System.out.print("Client <<< ");
			String line = scanner.nextLine();
			while(!(line.equals("exit"))){

				out.println(line);
				System.out.println("Server responded >>> " + in.readLine());
				System.out.print("Client <<< ");
				line = scanner.nextLine();
			}
		} catch (UnknownHostException e){
			System.out.println("Unknown host " + host);
			System.exit(1);
		} catch (IOException e){
			System.out.println("Error reading. Exiting");
			System.exit(1);
		}
	}
}