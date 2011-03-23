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

package jhgdc;


import static org.junit.Assert.*;
import jhgdc.common.HGDConsts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains the test cases related with the
 * request playlist command.
 *
 * @author Carlos Eduardo da Silva
 * @version 0.1.0
 *
 */
public class HGDClientTestPlaylist {

	/**
	 * The client.
	 */
	HGDClient client;
	
	/**
	 * A bogus client.
	 */
	HGDClient bogusClient;
	
	/**
	 * Creates a new client, and opens a connection before execution 
	 * of each test case.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		client = new HGDClient();
		client.connect(HGDConsts.DEFAULT_HOST);
	}

	/**
	 * Disconnects the client, in case it is still connected at
	 * the end of the test case.
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		if (client.isConnected())
			client.disconnect(true);
	}

	/**
	 * Test the request playlist command.
	 * @throws Exception
	 */
	@Test
	public void testRequestPlaylist() throws Exception {
		String[] playlist = client.requestPlaylist();
		assertNotNull("Method returned null playlist", playlist);
		
		//Make sure we don't have null items in the playlist
		if (playlist.length > 0) {
			for (int i = 0; i < playlist.length; i++) {
				assertNotNull("Item number " + i + " is null", playlist[i]);
			}
		}
	}

	/**
	 * Test the request playlist command in an invalid state.
	 * @throws Exception
	 */
	@Test (expected=IllegalStateException.class)
	public void testRequesPlaylistInvalidState() throws Exception {
		bogusClient = new HGDClient();
		bogusClient.requestPlaylist();
		fail("IllegalStateException expected");
	}
	
}
