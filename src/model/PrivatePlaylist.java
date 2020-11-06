package model;

public class PrivatePlaylist extends Playlist{
	
	private User uniqueUser;
	
	/*
	 * Description This is the constructor method of the PlayList class
	 * @param name, the name of the public playList
	 * @param mins, the minutes of the public playList
	 * @param secs, the seconds of the public playList
	 * @param uniqueUser, playList user
	 */
	public PrivatePlaylist(String name, int mins, int secs, User uniqueUser) {
		super(name, mins, secs);
		this.uniqueUser = uniqueUser;
		privatePlaylist = true;
	}
	/*
	 * Description This method gets the uniqueUser of the private PlayList
	 * @return uniqueUser of the private PlayList
	 */
	public User getUniqueUser() {
		return uniqueUser;
	}
	/*
	 * Description Thus method sets the uniqueUser of the private playList
	 * @param uniqueUser, the uniqueUser of the private PlayList
	 */
	public void setUniqueUser(User uniqueUser) {
		this.uniqueUser = uniqueUser;
	}
	
}