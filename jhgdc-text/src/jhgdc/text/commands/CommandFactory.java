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

/**
 * Singleton responsible for creating the appropriate Command object.
 * 
 *
 * @author Carlos Eduardo da Silva
 * @version 13/05/2011
 *
 */
public class CommandFactory {

	public static AbstractCommand createCommand(String name) throws Exception{
		if (name == null || name.isEmpty() ) {
			throw new Exception("Empty command name");
		}
		//Request playlist
		if (name.equals("ls")) {
			return new CommandRequestPlaylist();
		}
		
		//Queue
		if (name.equals("q")) {
			return new CommandRequestQueue();
		}
		
		//Voteoff
		if (name.equals("vo")) {
			return new CommandRequestVoteOff();
		}
		
		throw new Exception("No such command name");	
	}
}
