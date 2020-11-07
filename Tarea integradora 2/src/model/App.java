package model;

import java.util.Date;

public class App {
	private User[] users;
	private Song[] poolOfSongs;
	private Playlist[] playlists;
	
	public static final int SIZE_OF_USERS = 10;
	public static final int AMOUNT_OF_SONGS = 30;
	public static final int AMOUNT_OF_PLAYLISTS = 20;
	
	/*
	*Description This is the constructor method of the App class
	*/
	public App() {
		users = new User[SIZE_OF_USERS];
		poolOfSongs = new Song[AMOUNT_OF_SONGS];
		playlists = new Playlist[AMOUNT_OF_PLAYLISTS];
	}
	
	
	/*
	*Description this method looks for a user comparing between their names
	*@param userName is the name of the user
	*@return The user that found, if it does return null
	*/
	public User findUser(String userName) {
		User toFind = null;
		boolean found = false;
		
		for (int i = 0; i < users.length && !found; i++) {
			if (users[i] != null) {
				if (users[i].getUserName().equalsIgnoreCase(userName)) {
					toFind = users[i];
					found = true;
				}
			}
		}
		
		return toFind;
	}
	
	/*
	* Description This method adds a new user to the app 
	* @param userName, is the user name of the user
	* @param password, It is the user's password
	* @param age, It is the user's age
	* @return message if the user is added or not
	*/
	
	
	public String addUser(String userName, String password, int age) {
		String msg = "";
		
		if (!userName.contains(" ") && findUser(userName) == null) {
			msg = "ERROR: No fue posible añadir el usuario. La lista de usuarios está completa";
			boolean added = false;
			User us = new User(userName, password, age, Category.newbie);
			
			for (int i = 0; i < users.length && !added; i++) {
				if (users[i] == null) {
					users[i] = us;
					added = true;
					msg = "Usuario agregado con éxito";
				}
			}
		}else {
			msg = "ERROR: No fue posible añadir el usuario. \n Este nombre ya está en uso o tiene espacios";
		}
		
		return msg;
	}
	
	/*
	* Description This method steps through the user array 
	* and saves them to a variable to display
	* @return Message with the information of the user
	*/
	public String showUsers() {
		String info = "";
		
		for (int i = 0; i < users.length; i++) {
			if(users[i] != null) {
				info += users[i]+"\n";
			}
		}
		
		if (info.equals("")) {
			info = "No hay usuarios añadidos a la lista";
		}
		return info;
	}
	
	
	/*
	* Description This method finds the song with the name of the artist and the title of the song
	* @param title, the title of the song
	* @param artist, the artist of the song
	* @return The song found, if it is not it returns null
	*/
	public Song findSong(String title, String artist) {
		Song toFind = null;
		boolean found = false;
		
		for (int i = 0; i < poolOfSongs.length && !found; i++) {
			if (poolOfSongs[i] != null) {
				if (poolOfSongs[i].getTitle().equalsIgnoreCase(title) && poolOfSongs[i].getArtist().equalsIgnoreCase(artist)) {
					toFind = poolOfSongs[i];
					found = true;
				}
			}
		}
		
		return toFind;
	}
	
	
	/*
	* Description This method adds a new song, first check that it is not added before
	* @param userName, the userName of the contributor  
	* @param title, the title of the song
	* @param artist, the name of the artist of the song
	* @param day, song release day 
	* @param month, son release month
	* @param year, song release year
	* @param mins, the duration of the song in minutes
	* @param secs, the duration of the song in seconds
	* @param genre, the genre of the song
	* @return message that advises if the song was added or not  
	*/
	public String addSong(String userName, String title, String artist, int day, int month, int year, int mins, int secs, Genre genre) {
		String msg = "ERROR. No fue posible agregar la canción: la canción ya está en la lista";
		boolean added = false;
		
		if (findSong(title, artist) == null) {
			msg = "ERROR. No fue posible añadir el usuario. la lista de canciones está completa";
			
			for (int i = 0; i < poolOfSongs.length && !added; i++) {
				if (poolOfSongs[i] == null) {
					User contributor = findUser(userName);
					contributor.setContribution(contributor.getContribution()+1);
					Date date = new Date(day+"/"+month+"/"+year);
					poolOfSongs[i] = new Song(title, artist, date, mins, secs, genre);
					added = true;
					msg = "Se agregó la canción correctamente";
				}
			}
		}
		
		return msg;
	}
	
	/*
	* Description This method show of the songs
	* @return Message with the information of the songs
	*/
	public String showSongs() {
		String info = "";
		
		for (int i = 0; i < poolOfSongs.length; i++) {
			if(poolOfSongs[i] != null) {
				info += poolOfSongs[i]+"\n";
			}
		}
		
		if (info.equals("")) {
			info = "No hay canciones añadidas a la lista";
		}
		
		return info;
	}
	
	/*
	* Description This method find a playList 
	* @param name, the name of the playList
	* @return playList found, if not found returns null
	*/
	public Playlist findPlaylist(String name) {
		Playlist toFind = null;
		boolean found = false;
		
		for (int i = 0; i < playlists.length && !found; i++) {
			if (playlists[i] != null) {
				if (playlists[i].getName().equalsIgnoreCase(name)) {
					toFind = playlists[i];
					found = true;
				}
			}
		}
		
		return toFind;
	}
	
	/*
	* Description This method add a private playList
	* @param name, the name of the playList
	* @param mins, minutes of playList duration 
	* @param secs, seconds of playList duration
	* @param userName, userName of the contributor
	* @return message that advises if it is added or not
	*/
	public String addPrivatePlaylist(String name, int mins, int secs, String userName) {
		String msg = "ERROR. No fue posible crear la Playlist privada: No se encontró al usuario";
		User unique = findUser(userName);
		
		if (unique != null) {
			boolean added = false;
			msg = "ERROR. No fue posible crear la Playlist privada: La lista de reproducción está completa";
			
			if (findPlaylist(name) == null) {
				for (int i = 0; i < playlists.length && !added; i++) {
					if (playlists[i] == null) {
						PrivatePlaylist toAdd = new PrivatePlaylist(name, mins, secs, unique);
						playlists[i] = toAdd;
						added = true;
						msg = "Playlist creada correctamente";
					}
				}
			}else {
				msg = "ERROR. No fue posible crear la Playlist privada: El nombre está en uso, por favor elija otro nombre";
			}
		}
		
		return msg;
	}
	
	/*
	* Description This method add a public playList
	* @param name, the name of the playList
	* @param mins, minutes of playList duration 
	* @param secs, seconds of playList duration
	*/
	public String addPublicPlaylist(String name, int mins, int secs) {
		boolean added = false;
		String msg = "ERROR. No fue posible crear la Playlist pública: La lista de reproducción está completa";
		
		if (findPlaylist(name) == null) {
			for (int i = 0; i < playlists.length && !added; i++) {
				if (playlists[i] == null) {
					PublicPlaylist toAdd = new PublicPlaylist(name, mins, secs);
					playlists[i] = toAdd;
					added = true;
					msg = "Playlist creada correctamente";
				}
			}
		}else {
			msg = "ERROR. No fue posible crear la Playlist pública: El nombre está en uso, por favor elija otro nombre";
		}
		
		return msg;
	}
	
	
	/*
	* Description This method adds grades to a public PlayList
	* @param gardes, the rating between 1 and 5
	* @return message that advises if it is added or not
	*/
	public String addGradeToPublicPlaylist(String playlistName, int grade) {
		String msg = "ERROR. El grado debe ser mayor o igual a (1) e inferior o igual a (5)";
		
		if (grade >= 1 && grade <= 5) {
			msg = "ERROR. La Playlist seleccionada no es pública o no existe";
			Playlist toGrade = findPlaylist(playlistName);
			if (toGrade != null && toGrade.isPublicPlaylist()) {
				PublicPlaylist graded = (PublicPlaylist) toGrade;
				graded.setGrade(grade);
				msg = "Grado de la Playlist añadido correctamente";
			}
		}
		
		return msg;
	}
	
	
	/*
	* Description This method add a public playList
	* @param name, the name of the playList
	* @param mins, minutes of playList duration 
	* @param secs, seconds of playList duration
	* @param userName, contributor userName
	* @param userName2, contributor userName2. Can be empty 
	* @param userName3, contributor userName3. Can be empty 
	* @param userName4, contributor userName4. Can be empty 
	* @return message that advises if it is added or not
	*/
	public String addRestrictedPlaylist(String name, int mins, int secs, String userName, String userName2, String userName3, String userName4, String userName5) {
		String msg = "ERROR. No fue posible crear la Playlist restringida: usuarios no encontrados";
		User first = findUser(userName);
		User second = findUser(userName2);
		User third = findUser(userName3);
		User fourth = findUser(userName4);
		User fifth = findUser(userName5);
		User[] accesibles = {first, second, third, fourth, fifth};
		
		if (accesibles[0] != null || accesibles[1] != null || accesibles[2] != null || accesibles[3] != null || accesibles[4] != null) {
			boolean added = false;
			msg = "ERROR. No fue posible crear la Playlist restringida: La lista de resproducción está completa";
			
			if (findPlaylist(name) == null) {
				for (int i = 0; i < playlists.length && !added; i++) {
					if (playlists[i] == null) {
						RestrictedPlaylist toAdd = new RestrictedPlaylist(name, mins, secs, accesibles);
						playlists[i] = toAdd;
						added = true;
						msg = "Playlist agregada correctamente";
					}
				}
			}else {
				msg = "ERROR. No fue posible crear la Playlist pública: El nombre está en uso, por favor elija otro nombre";
			}
		}
		
		return msg;
	}
	
	/*
	* Description This method add a song to playList
	* @param tite, title of the song
	* @param artist, artist of the song
	* @param playlistName, playList name to add
	* @return message that advises if it is added or not
	*/
	public String addSongToPlaylist(String title, String artist, String playlistName) {
		String msg = "ERROR. No fue posible añadir la canción a la Playlist elegida: Playlist no encontrada";
		Playlist selectedPlaylist = findPlaylist(playlistName);
		
		if (selectedPlaylist != null) {
			Song chosenSong = findSong(title, artist);
			msg = "ERROR. No fue posible agregar la canción elegida a la Playlist: canción no encontrada";
			
			if (chosenSong != null) {
				selectedPlaylist.addSong(chosenSong);
				msg = "Canción agregada exitosamente";
			}
		}
		
		return msg;
	}
	
	/*
	* Description This method show information of the playList
	* @return message with the playList information
	*/
	public String showPlaylists() {
		String info = "";
		
		for (int i = 0; i < playlists.length; i++) {
			if(playlists[i] != null) {
				if (playlists[i].isPublicPlaylist()) {
					PublicPlaylist toshow = (PublicPlaylist) playlists[i];
					info += toshow.toSting()+"\n";
				}else if (playlists[i].isPrivatePlaylist()) {
					PrivatePlaylist toshow = (PrivatePlaylist) playlists[i];
					info += toshow.toSting()+"\n";
				}else {
					RestrictedPlaylist toshow = (RestrictedPlaylist) playlists[i];
					info += toshow.toSting()+"\n";
				}
			}
		}
		
		if (info.equals("")) {
			info = "No hay playlist añadidas a la lista";
		}
		
		return info;
	}
}
