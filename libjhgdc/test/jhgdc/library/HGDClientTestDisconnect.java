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
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains the test cases for the disconnection command.
 *
 * @author Carlos Eduardo da Silva
 * @version 0.1.0
 *
 */
public class HGDClientTestDisconnect {

	/**
	 * The client.
	 */
	HGDClient client;
	
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
	 * Sets the client to null.
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		client = null;
	}

	@Test
	public void testDisconnect() {
		try {
			client.disconnect(true);
			assertFalse("Client still connected", client.isConnected());
			//Test the flags
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test (expected=IllegalStateException.class)
	public void testDisconnectIllegaState() throws Exception {
		client.disconnect(true);
		assertFalse("Client still connected", client.isConnected());
		
		client.disconnect(true);
		fail("IllegalStateException not thrown");
	}
}
