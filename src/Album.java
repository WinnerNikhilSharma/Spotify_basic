import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name, artist;
    private ArrayList<Song> song; // Line number 28;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.song = new ArrayList <>();
    }

    public boolean findSong(String title){
        for (Song currSong : this.song){
            if (title.equals(currSong.getTitle())){
                return true;
            }
        }
        return false;
    }

    public boolean addSong(String title, double duration){
        if (findSong(title) == true){
            System.out.println("Song already exists");
            return false;
        }
        Song s = new Song(title, duration);
        this.song.add(s); // IMP.
        return true;
    }

    public boolean addToPlayList (String title, LinkedList<Song> playList){
        for (Song s : this.song){
            if (s.getTitle().equals(title)){
                playList.add(s);
                return true;
            }
        }
        return false;
    }

    public boolean addToPlayList (int trackNumber, LinkedList <Song> playList){
        int index = trackNumber-1;
        if (index >=0 && index<this.song.size()){
            playList.add(this.song.get(index));
            System.out.print("Song Added");
            return true;
        }
        return false;
    }
}
