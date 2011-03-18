package jhgdc.common;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HGDConnectionTest {

	HGDConnection connection;
	
	@Before
	public void setUp() throws Exception {
		connection = new HGDConnection();
	}

	@After
	public void tearDown() throws Exception {
		if (connection.isConnectionEstablished())
			connection.closeConnection();
	}

	@Test
	public void testConnectToServer() {

		try {
		connection.connectToServer();
		assertTrue(	 "The connection has not been established.", connection.isConnectionEstablished() );
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception: " + e.getMessage());
		} 		
	}

	@Test
	public void testCloseConnection() {
		try {
		connection.connectToServer();
		assertTrue("The connection has not been established.", connection.isConnectionEstablished() );
		
		connection.closeConnection();
		assertFalse("The connection can not be closed.", connection.isConnectionEstablished() );
		} catch (Exception e) {
		fail("Error closing connection");
		}
	}

	@Test
	public void testRequestPlaylist() {
		try {
			connection.connectToServer();
			assertTrue("The connection has not been established.", connection.isConnectionEstablished() );
			
			String [] playlist = connection.requestPlaylist();
			
			assertNotNull("Playlist returned null", playlist);
			if (playlist.length > 0) {
				for (String tempItem : playlist)
				System.out.println(tempItem);
			}
			connection.closeConnection();
			assertFalse("The connection can not be closed.", connection.isConnectionEstablished() );
		} catch (Exception e) {
			fail("Error testing ls.");
		}
	}

	@Test
	public void testRequestHud() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRequestVoteOff() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRequestQueue() {
		fail("Not yet implemented"); // TODO
	}

}
