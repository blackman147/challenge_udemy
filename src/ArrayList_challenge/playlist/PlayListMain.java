package ArrayList_challenge.playlist;

import java.util.*;

public class PlayListMain {
    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
        Album album = new Album("African Giant", "BurnaBoy");
        album.addSong("Anybody", 3.53);
        album.addSong("Spiritual", 3.18);
        album.addSong("ye", 4.10);
        album.addSong("African Giant", 2.46);
        album.addSong("Dangote", 3.46);
        album.addSong("Killin Dem", 3.41);
        album.addSong("Secret", 3.24);
        albums.add(album);

        album = new Album("Made in Lagos", "Wizkid");
        album.addSong("Reckless", 3.53);
        album.addSong("Ginger", 3.16);
        album.addSong("Blessed", 4.23);
        album.addSong("Smile", 4.12);
        album.addSong("No Stress", 3.23);
        album.addSong("Essence", 4.08);
        album.addSong("Roma", 3.00);
        album.addSong("LongTime", 4.00);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlaylist("AnyBody", playList);
        albums.get(0).addToPlaylist("ye", playList);
        albums.get(1).addToPlaylist("ginger", playList);
        albums.get(0).addToPlaylist(5, playList);
        albums.get(0).addToPlaylist(1, playList);
        albums.get(0).addToPlaylist(10, playList);

        play(playList);



    }

    private static void play(LinkedList<Song> playList){
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        boolean forward = false;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0){
            System.out.println("No songs added to playlist");
            return;
        }else{
            System.out.println("Now Playing " + listIterator.next().toString());
        }
        while(!quit){
            int action = scan.nextInt();
            scan.nextLine();

            switch(action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    }else{
                        System.out.println("The playlist has ended");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }else{
                        System.out.println("we are at the beginning of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    }else {
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;

                case 6:
                    if (playList.size() > 0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available Actions: \npress");
        System.out.println("0 to quit\n" +
                            "1 - to play next song\n" +
                            "2 - to play previous song\n" +
                            "3 - to replay song\n" +
                            "4 - to list songs\n" +
                            "5 - to print available actions\n"+
                            "6 - to delete current song from playlist");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


}
