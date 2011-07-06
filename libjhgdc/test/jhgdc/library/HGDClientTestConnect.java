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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains the test cases for the connect command.
 *
 * @author Carlos Eduardo da Silva
 * @version 0.1.0
 *
 */
public class HGDClientTestConnect {

	/**
	 * The client.
	 */
	HGDClient client;
	
	
	/**
	 * Creates a new client before execution of each test case.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		client = new HGDClient();
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
	 * Testing a successful connection.
	 */
	@Test
	public void testConnect() throws Exception {
			client.connect(HGDConsts.DEFAULT_HOST);
			assertTrue(	 "The connection has not been established.", client.isConnected() );
			System.out.println("Connection established");
	}

	/**
	 * Testing a connection to the wrong port.
	 * @throws Exception
	 */
	@Test (expected=IOException.class)
	public void testConnectWrongPort() throws Exception {
		client.connect(HGDConsts.DEFAULT_HOST, HGDConsts.DEFAULT_PORT+1);
		assertFalse("Connection should not be established", client.isConnected());
		fail("IOException not thrown");
	}
	
	/**
	 * Testing a connection to the wrong address
	 * @throws Exception
	 */
	@Test (expected=IOException.class)
	public void testConnectWrongHost() throws Exception {
		client.connect("invalidaddress");
		assertFalse("Connection should not be established", client.isConnected());
		fail("IOException not thrown");
	}
	
	/**
	 * Testing a connect call when the client is already connected.
	 * @throws Exception
	 */
	@Test (expected=IllegalStateException.class)
	public void testConnectInvalidState() throws Exception {
		client.connect(HGDConsts.DEFAULT_HOST);
		assertTrue(	 "The connection has not been established.", client.isConnected() );
		
		client.connect(HGDConsts.DEFAULT_HOST);
		fail("IllegalStateException not thrown");
	}
}
