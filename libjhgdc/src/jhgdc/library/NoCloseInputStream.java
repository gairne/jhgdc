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
 * This class is a wrapper for an input stream.
 * 
 * Closing an InputStream that is assigned to a socket
 * will close the socket. This may be undesirable.
 * 
 * Instead we ignore the call to close the buffer.
 * 
 * @author Matthew Mole
 * @since 21/01/2012
 *
 */
public class NoCloseInputStream extends InputStream {

	protected InputStream input;

	public NoCloseInputStream(InputStream input) {
		this.input = input;
	}

	@Override
	public int available() throws IOException {
		return input.available();
	}

	@Override
	public void close() throws IOException {}
	
	@Override
	public void mark(int readlimit) {
		input.mark(readlimit);
	}
	
	@Override
	public boolean markSupported() {
		return input.markSupported();
	}
	
	@Override
	public int read() throws IOException {
		return input.read();
	}

	@Override
	public int read(byte[] b) throws IOException {
		return input.read(b);
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		return input.read(b, off, len);
	}
	
	@Override
	public void reset() throws IOException {
		input.reset();
	}

	@Override
	public long skip(long n) throws IOException {
		return input.skip(n);
	}
}

