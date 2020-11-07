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
	/*
	 * Description This method sets the duration of the playList
	 * @param The duration of the playList
	 */
	public void setDuration(String duration) {
		String[] durationA = duration.split(":");
		int minsN = Integer.parseInt(durationA[0]);
		int secsN = Integer.parseInt(durationA[1]);
		int minsO = mins;
		int secsO = secs;
		
		int minsT = minsN + minsO;
		int secsT = secsN + secsO;
		
		if (secsT > 60) {
			minsT++;
			secsT = secsT - 60;
		}
		
		setMins(minsT);
		setSecs(secsT);
		
		this.duration = ""+minsT+":"+secsT;
	}
	/*
	 * Description This method gets the minutes of the playList 
	 * @return The minutes of the playList
	 */
	public int getMins() {
		return mins;
	}
	/*
	 * Description This method sets the minutes of the playList
	 * @param The minutes of the playList
	 */
	public void setMins(int mins) {
		this.mins = mins;
	}
	/*
	 * Description This method gets the seconds of the playList
	 * @return The seconds of the playList
	 */
	public int getSecs() {
		return secs;
	}
	/*
	 * Description This method sets the seconds of the playList
	 * @param The seconds of the playList
	 */
	public void setSecs(int secs) {
		this.secs = secs;
	}
	/*
	 * Description This method gets the genre of the playList
	 * @return The genre of the playList
	 */
	public String getGenre() {
		return genre;
	}
	/*
	 * Description This method sets the genre of the playList
	 */
	public void setGenre() {
		String sGenre = "";
		for (int i = 0; i < songs.length; i++) {
			if (songs[i] != null) {
				sGenre += songs[i].getGenre()+", ";
			}
		}
		genre = sGenre;
	}
	/*
	 * Description This method gets the songs of the playList
	 * @return The array of the songs
	 */
	public Song[] getSongs() {
		return songs;
	}
	/*
	 * Description This method sets the songs of the playList
	 * @param  The array of the songs
	 */
	public void setSongs(Song[] songs) {
		this.songs = songs;
	}
	/*
	 * Description This method adds the songs to the playList
	 * @param toAdd, is the song to add
	 * @return boolean, true for yes added, false if no
	 */
	
	public boolean addSong(Song toAdd) {
		boolean added = false;
		
		for (int i = 0; i < songs.length && !added; i++) {
			if (songs[i] == null) {
				songs[i] = toAdd;
				added = true;
				setGenre();
				setDuration(toAdd.getDuration());
			}
		}
		
		return added;
	}

	/*
	 * Description This method is to know if it is a public PlayList or not
	 * @return boolean, true if is a public PlayList, false if not
	 */
	public boolean isPublicPlaylist() {
		return publicPlaylist;
	}
	
	/*
	 * Description This method is to know if it is a private PlayList or not
	 * @return boolean, true if is a private PlayList, false if not
	 */
	public boolean isPrivatePlaylist() {
		return privatePlaylist;
	}
	
	/*
	 * Description This method overwrites the class toString
	 * @return All playList information 
	 */
	public String toString() {
		return "**************  Playlist **************\n"+
				"**  Titulo: "+name+
				"\n**  Duración: "+duration+
				"\n**  Genero: "+genre.substring(0, genre.length()-2);
	}

}
