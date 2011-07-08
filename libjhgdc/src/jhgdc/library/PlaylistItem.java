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

/**
 * A class representing a PlaylistItem AT THE POINT OF INSTANTIATION.
 * If data obtained by a call to libjhgdc is left for a large period of time
 * then a PlaylistItem object created from it, the PlaylistItem will be out of date.
 */
public class PlaylistItem {

	private String trackId, filename, artist, title, user;
	
	/**
	 * @author Matthew Mole
	 * @param trackId The ID of the song, typically an incrementing natural
	 * @param filename The filename of the uploaded song
	 * @param artist The song's artist
	 * @param title The song's title
	 * @param user The user who uploaded the file
	 */
	public PlaylistItem(String trackId, String filename, String artist, String title, String user) {
		this.trackId = trackId;
		this.filename = filename;
		this.artist = artist;
		this.title = title;
		this.user = user;
	}
	
	/**
	 * @author Matthew Mole
	 * @return The trackId
	 */
	public String getId() {
		return this.trackId;
	}
	
	/**
	 * @author Matthew Mole
	 * @return The filename
	 */
	public String getFilename() {
		return this.filename;
	}
	
	/**
	 * @author Matthew Mole
	 * @return The artist
	 */
	public String getArtist() {
		return this.artist;
	}
	
	/**
	 * @author Matthew Mole
	 * @return The song title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * @author Matthew Mole
	 * @return The user who enqueued the file
	 */
	public String getUser() {
		return this.user;
	}
	
	/**
	 * @author Matthew Mole
	 * @return True if there is no current song playing
	 */
	public boolean isEmpty() {
		return false;
	}
}
