package jhgdc;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import jhgdc.common.HGDConsts;
import jhgdc.common.JHGDException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HGDClientTest {

	HGDClient client;
	
	@Before
	public void setUp() throws Exception {
		client = new HGDClient();
	}

	@After
	public void tearDown() throws Exception {
		if (client.isConnected())
			client.disconnect(true);
	}

	

	//@Test
	public void testDisconnect() {
		try {
		client.connect(HGDConsts.DEFAULT_HOST);
		assertTrue("The connection has not been established.", client.isConnected() );
		
		client.disconnect(true);
		assertFalse("The connection can not be closed.", client.isConnected() );
		} catch (Exception e) {
		fail("Error closing connection");
		}
	}

	@Test
	public void testRequestPlaylist() {
		try {
			client.connect(HGDConsts.DEFAULT_HOST);
			assertTrue("The connection has not been established.", client.isConnected() );
			
			String [] playlist = client.requestPlaylist();
			
			assertNotNull("Playlist returned null", playlist);
			if (playlist.length > 0) {
				for (String tempItem : playlist)
				System.out.println(tempItem);
			}
		} catch (Exception e) {
			fail("Error testing ls.");
		}
	}

	@Test
	public void testLoginWithoutPassword() {
		try {
			client.connect(HGDConsts.DEFAULT_HOST);
			assertTrue("The connection has not been established.", client.isConnected() );
			
			client.login("kaduardo", "");
			assertTrue("Client not authenticated", client.isAuthenticated());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test (expected=JHGDException.class)
	public void testLoginWrongPassword() throws Exception {
		client.connect(HGDConsts.DEFAULT_HOST);
		assertTrue("Connection can not be established", client.isConnected());
		client.login("kaduardo", "password");
		assertFalse("Client authenticated", client.isAuthenticated());
	}
	
	//@Test
	public void testRequestVoteOff() {
		fail("Not yet implemented"); // TODO
	}

	//@Test
	public void testRequestQueue() {
		fail("Not yet implemented"); // TODO
	}

}
