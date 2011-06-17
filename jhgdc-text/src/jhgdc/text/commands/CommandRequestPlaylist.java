/*
 * Copyright (c) 2011, Carlos Eduardo da Silva <kaduardo@gmail.com>
 *
 * 
 *  This file is part of jhgdc-text.
 * 
 *  jhgdc-text is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  jhgdc-text is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with jhgdc-text.  If not, see <http://www.gnu.org/licenses/>.
 */

package jhgdc.text.commands;

import java.util.List;

import jhgdc.library.HGDClient;

/**
 * Class implementing the request playlist command.
 *
 * @author Carlos Eduardo da Silva
 * @version 13/05/2011
 *
 */
public class CommandRequestPlaylist extends AbstractCommand {

	/**
	 * 
	 */
	public CommandRequestPlaylist() {
		super();
		this.setAuthenticationRequired(false);
		this.setNumberOfArguments(0);
	}

	/* (non-Javadoc)
	 * @see jhgdc.text.commands.AbstractCommand#doCommand(java.lang.String[], jhgdc.library.HGDClient)
	 */
	@Override
	protected void doCommand(List<String> args, HGDClient clientConnection)
			throws Exception {
		String playlist[] = clientConnection.requestPlaylist();
		for (String playlistItem : playlist ){
			System.out.println("Item: " + playlistItem);
		}
	}

}
