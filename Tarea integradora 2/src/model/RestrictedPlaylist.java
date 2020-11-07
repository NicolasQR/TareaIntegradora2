package model;

public class RestrictedPlaylist extends Playlist{
	
	private User[] users;
	public final static int SIZE_OF_USERS = 5;
	
	/*
	 * Description This is the constructor method of the PlayList class
	 * @param name, the name of the public playList
	 * @param mins, the minutes of the public playList
	 * @param secs, the seconds of the public playList
	 * @param users, the array of the users of the playList
	 */
	public RestrictedPlaylist(String name, int mins, int secs, User[] users) {
		super(name, mins, secs);
		this.users = new User[SIZE_OF_USERS];
		this.users = users;
	}
	/*
	 * Description This method gets the users from the array
	 * @return Message with the name of the users
	 */
	public String getUsers() {
		String names = "";
		
		for (int i = 0; i < users.length; i++) {
			if (users[i] != null) {
				names += users[i].getUserName()+", ";
			}
		}
		
		return names;
	}
	
	/*
	 * Description This method sets users of the PlayList
	 * @param users, the array of the users
	 */
	public void setUsers(User[] users) {
		this.users = users;
	}
	 /* Description This method overrides the toString of this class
		 * @return The information of the PublicPlayList with the format of the superclass and adding the users 
		 */
	public String toSting(){
		return super.toString()+
				"\n**  Usuarios: "+getUsers().substring(0, getUsers().length()-2)+
				"\n***************************************";
	}
}
