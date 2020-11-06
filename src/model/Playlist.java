package model;

public class Playlist {
	public String name;
	public String duration;
	private int mins;
	private int secs;
	public String genre;
	public Song[] songs;
	public boolean publicPlaylist;
	public boolean privatePlaylist;
	
	public static final int AMOUNT_OF_SONGS = 30;
	
	/*
	 * Description This is the constructor method of the PlayList class
	 * @param name The name of the playList
	 * @param mins The minutes of the playList
	 * @param secs The seconds of the playList
	 */
	public Playlist(String name, int mins, int secs) {
		this.name = name;
		this.mins = mins;
		this.secs = secs;
		songs = new Song[AMOUNT_OF_SONGS];
		genre = "unknown  ";
		duration = ""+mins+":"+secs;
		publicPlaylist = false;
		privatePlaylist = false;
	}
	
	/*
	 * Description This method gets the name of the playList
	 * @return The name of the playList
	 */
	public String getName() {
		return name;
	}
	/*
	 * Description This method sets the name of the playList
	 * @param name, the name of the playList
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * Description This method gets the duration of the playlist
	 * @return The duration of the playList
	 */
	public String getDuration() {
		return duration;
	}
	
}