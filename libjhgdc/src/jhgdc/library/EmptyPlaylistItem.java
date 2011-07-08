/*
 * Copyright (c) 2011 Matthew Mole <code@gairne.co.uk>
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

import jhgdc.library.PlaylistItem;

/**
 * A class representing a PlaylistItem AT THE POINT OF INSTANTIATION.
 * If data obtained by a call to libjhgdc is left for a large period of time
 * then a PlaylistItem object created from it, the PlaylistItem will be out of date.
 * 
 * This class represents a null version of PlaylistItem - when no song is playing.
 */
public class EmptyPlaylistItem extends PlaylistItem {

	/**
	 * @author Matthew Mole
	 */
	public EmptyPlaylistItem() {
		super("","","","","");
	}
	
	@Override
	public String getId() {
		return "";
	}
	
	@Override
	public String getFilename() {
		return "";
	}
	
	@Override
	public String getArtist() {
		return "";
	}
	
	@Override
	public String getTitle() {
		return "";
	}
	
	@Override
	public String getUser() {
		return "";
	}
	
	@Override
	public boolean isEmpty() {
		return true;
	}
}
