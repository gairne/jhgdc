/*
* Copyright (c) 2011, Carlos Eduardo da Silva <kaduardo@gmail.com>
*
*
* This file is part of jhgdc-text.
*
* jhgdc-text is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* jhgdc-text is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with jhgdc-text. If not, see <http://www.gnu.org/licenses/>.
*/
package jhgdc.text.commands;

/**
 * An abstract class that opens the connection with the server, and delegates 
 * the command to the concrete class that implements it.
 * 
 * @author Carlos Eduardo da Silva
 * @since 07/04/2011
 */
public abstract class AbstractCommand {

	private int numberOfArguments;
	private boolean authenticationRequired;
	
	public void execute(String[] args) {
		
	}
	
	protected abstract void doCommand(String[] args) ;
	
	
}
