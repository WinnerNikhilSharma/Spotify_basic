import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album al = new Album("Singer", "Album_new");
        al.addSong("abc", 3.6);
        al.addSong("def", 3.6);
        al.addSong("ghi", 3.6);

        LinkedList<Song> myPlayList = new LinkedList<>();
        al.addToPlayList("abc", myPlayList);
        al.addToPlayList(3,myPlayList);

        play(myPlayList);
    }
    public static void printList(LinkedList <Song> playList){ // New Method out of other Method area;
        for (Song song : playList) {
            System.out.println(song);
        }
    }

    public static void printMenu(){
        System.out.println("0. Exit");
        System.out.println("1. Print Menu");
        System.out.println("2. Show all songs");
        System.out.println("3. Play next song");
        System.out.println("4. Play previous song");
        System.out.println("5. Repeat song");
        System.out.println("6. Delete song");
    }

    public static void play (LinkedList<Song>al){
        Scanner scn = new Scanner(System.in);
        ListIterator<Song> itr = al.listIterator();
        if (!itr.hasNext()){
            System.out.println("No song");
        }
        System.out.println("You are listening to: "+itr.next());
        printMenu();

        boolean forward = true;

        while(true){
            int option = scn.nextInt();

            switch(option){
                case 0:
                    System.out.println("Thanks for listening");
                    return;

                case 1:
                    printMenu();
                    break;

                case 2:
                    printList(al);
                    break;

                case 3:
                    if(!forward){
                        if(itr.hasNext())
                            itr.next();
                    }
                    if(!itr.hasNext())
                        System.out.println("End of playlist");
                    else{
                        System.out.println("you are listening to "+itr.next());
                    }
                    forward = true;
                    break;

                case 4:
                  if (forward){
                      if(itr.hasPrevious())
                          itr.previous();
                  }
                      if(!itr.hasPrevious())
                          System.out.println("End of playlist");
                      else{
                          System.out.println("you are listening to "+itr.previous());
                      }
                      forward = false;
                      break;

                      case 5:
                          if(forward){
                              if(itr.hasPrevious()){
                                  System.out.println("Now playing "+itr.previous().toString());
                                  forward = false;
                              }
                              else{
                                  System.out.println("We are at start of list");
                              }
                          }
                          else {
                              if(itr.hasNext()){
                                  System.out.println("Now playing "+itr.next().toString());
                                  forward = true;
                              }
                              else{
                                  System.out.println("We are at end of list");
                              }
                          }
                        break;

                case 6:
                    if (al.size() > 0){
                        itr.remove();
                        if(itr.hasNext()){
                            System.out.println("You are listening to "+itr.next());
                        }
                        else{
                            if(itr.hasPrevious()){
                                System.out.println("You are listening to "+itr.previous());
                            }
                        }
                    }
                  }
            }
        }
    }
