package ui;

import java.util.Scanner;

import model.App;
import model.Genre;

public class Main {
	private App controller;
	Scanner reader;

	public static void main(String[] args) {
		Main m = new Main();
	}
	
	public Main() {
		System.out.println(showBanner());
		reader = new Scanner(System.in);
		controller = new App();
		boolean exit = false;
		
		do {
			showMenu();
			int option = reader.nextInt();
			reader.nextLine();
			
			switch (option) {
			case 1:
				createUser();
				break;
				
			case 2:
				showUsers();
				break;
				
			case 3:
				createSong();
				break;

			case 4:
				showSongs();
				break;

			case 5:
				createPlaylist();
				break;
				
			case 6:
				addSongToPlaylist();
				break;
				
			case 7:
				rateAPlaylist();
				break;

			case 8:
				showPlaylist();
				break;

			case 9:
				
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~ Gracias por usar la aplicación ~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				exit = true;
				
				break;

			default:
				System.out.println("Opción incorrecta. por favor seleccione una opción válida");
				break;
			}
		} while (!exit);
		
	}
	
	public String showBanner() {
		return "(((((((((((((((((((((((((((((((((((((((((((((((((\r\n" + 
				"((((((((((((((((/((((((((((((((((((((((((((((((((\r\n" + 
				"(((/  .(((((((*  .((((((*        (((((/      /(((\r\n" + 
				"(((/   .((((((.  .(((((   ,((((((((((*  .((((((((\r\n" + 
				"(((/    /((((/   .((((/  ,(((((((((((.  /((((((((\r\n" + 
				"(((/     ((((*   .((((*  ,(((((((((((/   ((((((((\r\n" + 
				"(((/  *  *(((     ((((*  ,((((((((((((,  .(((((((\r\n" + 
				"(((/  /.  ((*     ((((*  *(((((((((((((,   ((((((\r\n" + 
				"(((/  //  ,(  .   ((((*  *((((((((((((((/   /((((\r\n" + 
				"(((/  *(*  ,  (   ((((*  *((((((((((((((((   /(((\r\n" + 
				"(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   (((\r\n" + 
				"(((/  .((    ((   /((((  .(((((((((((((((((.  /((\r\n" + 
				"(((/  .((.  .((.  *((((,  *((((((((((((((((   /((\r\n" + 
				"(((/  .((((((((.  *(((((   *((((/,/(((((((/   (((\r\n" + 
				"(((/  .((((((((.  *((((((.        *((   .   .((((\r\n" + 
				"(((((((((((((((/*/((((((((((///(((((((////(((((((\r\n" + 
				"(((((((((((((((((((((((((((((((((((((((((((((((((\r\n" + 
				"               ./(###((///((###(*                \r\n" + 
				"           *#(,                   *((,           \r\n" + 
				"        ,#/                           ((         \r\n" + 
				"      .#*          .**/////*,.          ((       \r\n" + 
				"     *(.      .//////////////////*       *#      \r\n" + 
				"    .#,     *///////////////////////,     /(     \r\n" + 
				"    /(    *///////////////////////////    .#.    \r\n" + 
				"  ,/////,*/////////////////////////////,*////*.  \r\n" + 
				"  /////////////////////////*,...,/////////////,  \r\n" + 
				"  //////*,,,********,,.............,,,,,//////,  \r\n" + 
				"  //////*.........//*........//*.......,//////,  \r\n" + 
				"  //////*.........,,.........,,........,//////,  \r\n" + 
				"  //////*..............................,//////,  \r\n" + 
				"   *///*  ........,/.........**.......  .*///,   \r\n" + 
				"            .......,/*.....,/*.......            \r\n" + 
				"               ........,,,,.......               \r\n" + 
				"                    .........                    \r\n" + 
				"     \r\n" + 
				"*************************************************\r\n";
	}
	
	public void showMenu() {
		System.out.println("********************************************************");
		System.out.println("**** Bienvenido, por favor seleccione una opción. ******");
		System.out.println("1. Crear nuevo usuario.");
		System.out.println("2. Mostrar usuarios en la lista.");
		System.out.println("3. Crea y comparte una nueva canción.");
		System.out.println("4. Mostrar canciones en la pool.");
		System.out.println("5. Crear nueva Playlist.");
		System.out.println("6. Añadir canción a la playlist.");
		System.out.println("7. Califica una playlist pública.");
		System.out.println("8. Mostrar playlist en lista.");
		System.out.println("9. Exit.");
		System.out.println("********************************************************");
	}
	
	public void createUser() {
		System.out.println("Ingresa tu nombre de usuario:");
		String username = reader.nextLine();
		System.out.println("Ingresa tu contraseña:");
		String password = reader.nextLine();
		System.out.println("Ingresa tu edad:");
		int age = reader.nextInt();
		reader.nextLine();
		
		System.out.println(controller.addUser(username, password, age));
	}
	
	public void showUsers() {
		System.out.println(controller.showUsers());
	}
	
	public void createSong() {
		System.out.println("Ingresa el nombre de usuario del contribuidor:");
		String userName = reader.nextLine();
		System.out.println("Ingresa el titulo de la canción:");
		String title = reader.nextLine();
		System.out.println("Ingresa el artista de la canción:");
		String artist = reader.nextLine();
		System.out.println("Ingresa el día de lanzamiento de la canción:");
		int day = reader.nextInt();
		reader.nextLine();
		System.out.println("Ingresa el mes de lanzamiento de la canción:");
		int month = reader.nextInt();
		reader.nextLine();
		System.out.println("Ingresa el año de lanzamiento de la canción:");
		int year = reader.nextInt();
		reader.nextLine();
		System.out.println("Ingresa los minutos de duración de la canción");
		int mins = reader.nextInt();
		reader.nextLine();
		System.out.println("Ingresa los segundos de duración de la canción:");
		int secs = reader.nextInt();
		reader.nextLine();
		showGenres();
		int genreNum = reader.nextInt();
		reader.nextLine();
		Genre genre = Genre.unknown;
		switch (genreNum) {
		case 1:
			genre = Genre.Rock;
			break;
			
		case 2:
			genre = Genre.HipHop;
			break;
			
		case 3:
			genre = Genre.Clasica;
			break;
			
		case 4:
			genre = Genre.Reggae;
			break;
			
		case 5:
			genre = Genre.Salsa;
			break;
			
		case 6:
			genre = Genre.Metal;
			break;
			
		default:
			System.out.println("Opción incorrecta. por favor seleccione una opción válida");
			break;
		}
		
		if (!genre.equals(Genre.unknown)) {
			System.out.println(controller.addSong(userName, title, artist, day, month, year, mins, secs, genre));
		}
	}
	
	public void showGenres() {
		System.out.println("Elija para la canción uno de los siguientes géneros:");
		System.out.println("1. Rock");
		System.out.println("2. HipHop");
		System.out.println("3. Clasica");
		System.out.println("4. Reggae");
		System.out.println("5. Salsa");
		System.out.println("6. Metal");
	}
	
	public void showSongs() {
		System.out.println(controller.showSongs());
	}

	public void createPlaylist() {
		System.out.println("Elige qué tipo de playlist quieres crear:");
		System.out.println("1. Pública");
		System.out.println("2. Privada");
		System.out.println("3. Restringida");
		
		int type = reader.nextInt();
		reader.nextLine();
		
		switch (type) {
		case 1:
			createPublicPlaylist();
			break;
			
		case 2:
			createPrivatePlaylist();
			break;
			
		case 3:
			createRestrictedPlaylist();
			break;

		default:
			System.out.println("Opción incorrecta. por favor seleccione una opción válida");
			break;
		}
	}
	
	public void createPublicPlaylist() {
		System.out.println("Ingresa el nombre de la playlist que vas a crear");
		String name = reader.nextLine();
		System.out.println(controller.addPublicPlaylist(name, 0, 0));
	}
	
	public void createPrivatePlaylist() {
		System.out.println("Ingresa el nombre de la playlist que vas a crear");
		String name = reader.nextLine();
		System.out.println("Ingrese el nombre de usuario para el usuario único de la playlist:");
		String userName = reader.nextLine();
		
		System.out.println(controller.addPrivatePlaylist(name, 0, 0, userName));
	}
	
	public void createRestrictedPlaylist() {
		System.out.println("Ingresa el nombre de la playlist creada");
		String name = reader.nextLine();
		System.out.println("Ingresa el nombre de usuario del primer usuario de la playlist: (OBLIGATORIO)");
		String userName = reader.nextLine();
		System.out.println("ingrese el nombre de usuario del segundo usuario de la playlist: ");
		String userName2 = reader.nextLine();
		System.out.println("ingrese el nombre de usuario del tercer usuario de la playlist:");
		String userName3 = reader.nextLine();
		System.out.println("ingrese el nombre de usuario del cuarto usuario de la playlist:");
		String userName4 = reader.nextLine();
		System.out.println("ingrese el nombre de usuario del quinto usuario de la playlist:");
		String userName5 = reader.nextLine();
		
		System.out.println(controller.addRestrictedPlaylist(name, 0, 0, userName, userName2, userName3, userName4, userName5));
	}
	
	public void addSongToPlaylist() {
		System.out.println("Ingresa el titulo de la canción:");
		String title = reader.nextLine();
		System.out.println("Ingresa el nombre del artista:");
		String artist = reader.nextLine();
		System.out.println("Ingresa el nombre de la playlist:");
		String playlistName = reader.nextLine();
		
		System.out.println(controller.addSongToPlaylist(title, artist, playlistName));
	}
	
	public void rateAPlaylist() {
		System.out.println("Ingresa el nombre de la playlist:");
		String playlistName = reader.nextLine();
		System.out.println("Ingresa la calificación: (1-5)");
		int grade = reader.nextInt();
		reader.nextLine();
		
		System.out.println(controller.addGradeToPublicPlaylist(playlistName, grade));
	}
	
	public void showPlaylist() {
		System.out.println(controller.showPlaylists());
	}
}
