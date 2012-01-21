/*
 * Copyright (c) 2011, Carlos Eduardo da Silva <kaduardo@gmail.com>, Matthew Mole <code@gairne.co.uk>
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

import java.io.*;

/**
 * This class is a wrapper for an output stream.
 * 
 * Closing an OutputStream that is assigned to a socket
 * will close the socket. This may be undesirable.
 * 
 * Instead we ignore the call to close the buffer.
 * 
 * @author Matthew Mole
 * @since 21/01/2012
 *
 */
public class NoCloseOutputStream extends OutputStream {

	protected OutputStream output;

	public NoCloseOutputStream(OutputStream output){
		this.output = output;
	}

	@Override
	public void close() throws IOException {}

	@Override
	public void flush() throws IOException {
		output.flush();
	}
	
	@Override
	public void write(byte[] b) throws IOException {
		output.write(b);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		output.write(b, off, len);
	}
	
	@Override
	public void write(int b) throws IOException {
		output.write(b);
	}
}

