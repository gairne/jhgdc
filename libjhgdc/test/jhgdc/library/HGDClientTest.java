/*
 * Copyright (c) 2011, Carlos Eduardo da Silva <kaduardo@gmail.com>
 *
 * 
 *  This file is part of libjhgdc.
 * 
 *  libjhgdc is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  libjhgdc is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with libjhgdc.  If not, see <http://www.gnu.org/licenses/>.
 */
package jhgdc.library;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
