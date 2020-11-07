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
	
	 /* Description This method overrides the toString of this class
	 * @return The information of the PublicPlayList with the format of the superclass and adding the uniqueUser 
	 */
	public String toSting(){
		return super.toString()+
				"\n**  Usuario: "+uniqueUser.getUserName()+
				"\n***************************************";
	}

}
