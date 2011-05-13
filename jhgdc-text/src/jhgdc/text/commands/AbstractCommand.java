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

import java.util.List;

import jhgdc.library.HGDClient;

/**
 * An abstract class for commands.
 * For each command available to the user, this class must be extended
 * implementing the logic responsible for the command in the doCommand
 * method.
 * 
 * @author Carlos Eduardo da Silva
 * @since 07/04/2011
 */
public abstract class AbstractCommand {

	// The number of arguments of this command
	private int numberOfArguments;

	// A flag indicating the need for authentication
	private boolean authenticationRequired;

	public void execute(List<String> args, HGDClient clientConnection)
			throws Exception {
		doCommand(args, clientConnection);
	}

	public boolean checkNumberOfArguments(List<String> arguments) throws Exception {
		if (arguments.size() != numberOfArguments) {
			throw new Exception("Wrong number of arguments");
		}
		return true;
	}

	/**
	 * Method responsible for executing the command. This method must be 
	 * implemented by each concrete Command class. 
	 * 
	 * @param args The arguments used by the command.
	 * @param clientConnection The connection with the server.
	 * @throws Exception
	 */
	protected abstract void doCommand(List<String> args, HGDClient clientConnection)
			throws Exception;

	protected void setNumberOfArguments(int numberOfArguments) {
		this.numberOfArguments = numberOfArguments;
	}

	/**
	 * Method to recover the number of arguments expected by the command.
	 * 
	 * @return The number of arguments of the command.
	 */
	public int getNumberOfArguments() {
		return this.numberOfArguments;
	}

	protected void setAuthenticationRequired(boolean authenticationRequired) {
		this.authenticationRequired = authenticationRequired;
	}

	/**
	 * Method to query if the command requires authentication
	 * 
	 * @return True if authentication is required, False otherwise.
	 */
	public boolean isAuthenticationRequired() {
		return this.authenticationRequired;
	}
}
