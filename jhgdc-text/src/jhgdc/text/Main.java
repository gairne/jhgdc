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
package jhgdc.text;

import jargs.gnu.CmdLineParser;
import jhgdc.library.HGDConsts;

/**
 * The command line jhgdc client.
 * 
 * @author Carlos Eduardo da silva
 * @since 29/03/2011
 *
 */
public class Main {

	private static void printUsage() {
		System.out.println(
				  "Usage: java jhgdc-text [opts] command [args]\n\n"
				+ "  Options include:\n"
				//+ "    -e\t\t\tAlways require encryption\n"
				//+ "    -E\t\t\tRefuse to use encryption\n"
				+ "    -h\t\t\tShow this message and exit\n"
				+ "    -p port\t\tSet connection port\n"
				+ "    -s host/ip\t\tSet connection address\n"
				+ "    -u username\t\tSet username\n"
				//+ "    -x level\t\tSet debug level (0-3)\n"
				+ "    -v\t\t\tShow version and exit\n"
				//+ "    -e\t\t\tEnable Encryption\n"
				+ "  Commands include:\n"
				+ "    q <filename>\tQueue a track\n"
				+ "    vo\t\t\tVote-off current track\n"
				+ "    ls\t\t\tShow playlist\n\n"
				);
	}
	
	private static void printVersion() {
		System.out.println("jhgdc-text Version 0.1");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CmdLineParser parser = new CmdLineParser();
		//Options
		CmdLineParser.Option help = parser.addBooleanOption('h', "help");
		CmdLineParser.Option port = parser.addIntegerOption('p', "port");
		CmdLineParser.Option host = parser.addStringOption('h', "host");
		CmdLineParser.Option username = parser.addStringOption('u', "username");
		CmdLineParser.Option version = parser.addBooleanOption('v', "version");
				
		try {
			parser.parse(args);
		} catch (CmdLineParser.OptionException e) {
			System.err.println(e.getMessage());
			printUsage();
			System.exit(2);
		}
		
		Boolean helpValue = (Boolean)parser.getOptionValue(help, Boolean.FALSE);
		Integer portValue = (Integer)parser.getOptionValue(port, 
				new Integer(HGDConsts.DEFAULT_PORT));
		String hostValue = (String)parser.getOptionValue(host);
		String usernameValue = (String)parser.getOptionValue(username);
		Boolean versionValue = (Boolean)parser.getOptionValue(version, 
				Boolean.FALSE);
		
		System.out.println("Options received");
		if (helpValue) {
			System.out.println("help: " + helpValue);
			printUsage();
			System.exit(0);
		}
		
		if (versionValue) {
			System.out.println("version: " + versionValue);
			printVersion();
			System.exit(0);
		}
		
		System.out.println("port: " + portValue);
		System.out.println("host: " + hostValue);
		System.out.println("username: " + usernameValue);
		
		
		//Commands
		String[] otherArgs = parser.getRemainingArgs();
		System.out.println("Commands received");
		for (int i = 0; i < otherArgs.length; i++){
			System.out.println(otherArgs[i]);
		}
		
		System.exit(0);
	}

}
