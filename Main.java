package Project01;


import java.util.*;


public class Main {
	 private static ArrayList<Album> albums= new ArrayList<>();
	    public static void main(String[] args) {

	Album album=new Album("Album1","AC/DC");

	        album.addSong("TNT",4.5);
	        album.addSong("Higheay to hell",3.5);
	        album.addSong("ThunderStruck",5.0);
	        albums.add(album);

	       album=new Album("Album2","Eminem");

	        album.addSong("Rap God",4.5);
	        album.addSong("Not Afriad",3.5);
	        album.addSong("Lose yourself",4.5);
	        albums.add(album);

	        LinkedList<Song> playList_1=new LinkedList<>();

	        albums.get(0).addToPlayList("TNT",playList_1);
	        albums.get(0).addToPlayList("Higheay to hell",playList_1);
	        albums.get(1).addToPlayList("Rap God",playList_1);
	        albums.get(1).addToPlayList("Not Afriad",playList_1);

	        play(playList_1);
	    }
	    private static void play(LinkedList<Song>playList){
	Scanner sc=new Scanner(System.in);
	boolean quit=false;
	boolean forward=true;
	        ListIterator<Song> listIterator = playList.listIterator();

	        if(playList.size()==0){
	            System.out.println("This playlist have no song");
	        }else{
	            System.out.println("Now Playing "+listIterator.next().toString());
	            printMenu();
	        }
	        while(!quit){
	            int action= sc.nextInt();
	            sc.nextLine();

	            switch(action){

	                case 0:
	                    System.out.println("PlayList Complete");
	                    quit = true;
	                    break;

	                case 1:
	                    if(!forward){
	                        if(listIterator.hasNext()){
	                            listIterator.next();
	                        }
	                        forward = true;
	                    }
	                    if(listIterator.hasNext()){
	                        System.out.println("Now playing"+listIterator.next().toString());
	                    }else{
	                        System.out.println("no song available, reached to the end of the list.");
	                        forward = false;
	                    }
	                    break;
	                case 2:
	                    if(forward){
	                        if(listIterator.hasPrevious()){
	                            listIterator.previous();
	                        }
	                        forward = false;
	                    }
	                    if(listIterator.hasPrevious()){
	                        System.out.println("Now Playing "+listIterator.previous());
	                    }else{
	                        System.out.println("We are the first song");
	                        forward=false;
	                    }
	                    break;

	                case 3:
	                    if(forward){
	                        if(listIterator.hasPrevious()){
	                            listIterator.previous();
	                        }
	                        forward = false;
	                    }
	                    if(listIterator.hasPrevious()){
	                        System.out.println("Now Playing "+listIterator.previous());
	                    }else{
	                        System.out.println("We have reached to the end of the list");
	                        forward=false;
	                    }
	                    break;

	                case 4:
	                printlist(playList);
	                break;
	                case 5:
	                    printMenu();
	                    break;
	                case 6:
	                    if(playList.size()>0){
	                        listIterator.remove();
	                        if(listIterator.hasNext()){
	                            System.out.println("now playing"+listIterator.next().toString());
	                        }else{
	                            if(listIterator.hasPrevious())
	                                System.out.println("now playing "+listIterator.toString());
	                        }
	                    }

	            }
	        }
	    }
	    private static void printMenu(){
	        System.out.println("Available options\n press");
	        System.out.println("0 - to quit\n"+
	                "1 - to play next song\n"+
	                "2 - to play previous song\n"+
	                "3 - to replay the current song\n"+
	                "4 - list of all songs \n"+
	                "5 - print all available option\n"+
	                "6 - delete current song");
	    }
	    private static void printlist(LinkedList<Song>playList){
	        Iterator<Song> itorator =playList.iterator();
	        System.out.println("-------------------------------");

	        while(itorator.hasNext()){
	            System.out.println(itorator.next());
	        }
	        System.out.println("-------------------------------");
	    }
	}