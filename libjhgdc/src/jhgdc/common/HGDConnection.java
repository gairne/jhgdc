package jhgdc.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class HGDConnection {
	
	private String username;
	private String password;
	
	private String host;
	private int port;
	
	private BufferedReader input;
	private BufferedWriter output;
	
	private Socket clientSocket;
	
	private boolean connectionEstablished = false;
	
	public HGDConnection() {
		this("", "", HGDConsts.DEFAULT_HOST, HGDConsts.DEFAULT_PORT);
	}
	
	public HGDConnection(String username, String password, String host, int port) {
		this.username = username;
		this.password = password;
		this.host = host;
		this.port = port;
	}
	
	
	/*
	 * Util methods
	 */
	/**
	 * Opens a connection to the server
	 */
	private void openSocket() throws IOException {
		//Debug - attempting connection
		
		//Check encryption
		
		clientSocket = new Socket(InetAddress.getByName(host), port);
		
		output = new BufferedWriter( 
				new OutputStreamWriter(clientSocket.getOutputStream()));
		output.flush();
		
		input = new BufferedReader (
				new InputStreamReader (clientSocket.getInputStream()));
		
		//Debug - done
	}
	
	/**
	 * Opens a connection to the HGD daemon.
	 * 
	 * This methods checks whether encryption is necessary, authenticate
	 * the user and recover the streams that will be used to send/received
	 * data.
	 * 
	 * @throws IOException
	 */
	public void connectToServer() throws JHGDException {
		
		//Check if already connected
		if (connectionEstablished) {
			return;
		}
		
		//Check encryption necessity
		
		try {
			//Open socket 
			openSocket();
		
			//	Authenticate user

			String returnMessage = (String) input.readLine();
			//System.out.println("Connect - returned: '" + returnMessage + "'");
		
			if ( checkServerResponse(returnMessage) == HGDConsts.SUCCESS ) {
				//System.out.println("Connection established");
				connectionEstablished = true;
			} else {
				throw new JHGDException("Error establishing connection.");
			}
		} catch (Exception e) {
			throw new JHGDException("Error establishing connection", e);
		}
		
	}
	
	private void cleanConnection() {
		try {
			//close streams
			if (input != null ) input.close();
			if (output != null) output.close();
		
			//close socket
			if (!clientSocket.isClosed()) clientSocket.close();
		} catch (Exception e) {
			System.out.println("Error closing socket");
		}
	}
	
	/**
	 * This method closes the connection.
	 */
	public void closeConnection() {
	
		try {
			output.write("bye");
			output.newLine();
			output.flush();
			
			String returnMessage = (String) input.readLine();
			//System.out.println("closeConnection - returned: "+returnMessage);
			if (checkServerResponse(returnMessage) == HGDConsts.SUCCESS ) {
				
			}
			
			cleanConnection();
		} catch (IOException ioException ){
			ioException.printStackTrace();
		} finally {
			connectionEstablished = false;
		}
	}
	
	/**
	 * This method recovers the playlist from the daemon and
	 * returns it as an array of string.
	 * 
	 * {"ls", 0, 0, hgd_req_playlist},
	 */
	public String[] requestPlaylist() throws JHGDException {
		//Check if the connection is established
		if (!connectionEstablished) 
			throw new JHGDException("Connection is not established.");
		
		try {
			output.write("ls");
			output.newLine();
			output.flush();
			
			String returnMessage = (String) input.readLine();
			//	Debug
			//System.out.println("req_playlist - returned: "+returnMessage);
		
			String returnList [];
			
			if ( checkServerResponse(returnMessage) == HGDConsts.SUCCESS ) {
				int numberOfItems = Integer.parseInt(returnMessage.split("\\|")[1]);
				returnList = new String[numberOfItems];
				
				if (numberOfItems > 0) {
					String returnedItem;
				
					for (int i = 0 ; i < numberOfItems; i++) {
						returnedItem = (String) input.readLine();
						returnList[i] = returnedItem;
					}
				}
				return returnList;
			} else {
				throw new JHGDException("Error recovering the playlist.");
			}
		}catch (IOException ioe) {
			throw new JHGDException("Error recovering the playlist.", ioe);
		}
	}

	/**
	 * {"hud", 0, 0, hgd_req_hud}, 
	 */
	public void requestHud() {}
	
	/**
	 * {"vo", 0, 1, hgd_req_vote_off}, 
	 */
	public void requestVoteOff() {
		
	}
	
	/**
	 * {"q", 1, 1, hgd_req_queue},
	 */
	public void requestQueue(File file) {
		//Check if the connection is established
		
		//Check if file exist
	}

	/*
	 * Getters and Setters
	 */
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	public boolean isConnectionEstablished() {
		return connectionEstablished;
	}

	private int checkServerResponse(String message) {
		if ( message.split("\\|")[0].equalsIgnoreCase("ok") ) {
			return HGDConsts.SUCCESS;
		}
		return HGDConsts.FAILURE;
	}
}

