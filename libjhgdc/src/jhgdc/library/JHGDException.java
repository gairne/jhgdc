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

/**
 * This class represents an error message returned by the hgd daemon.
 *
 * @author Carlos Eduardo da Silva
 * @since 22/03/2011
 */
public class JHGDException extends Exception {

	public JHGDException(){
		super();
	}
	
	public JHGDException(String message) {
		super(message);
	}
	
	public JHGDException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public JHGDException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2779009794457307771L;

}
