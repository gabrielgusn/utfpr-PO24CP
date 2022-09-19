import java.util.Scanner;

public class Book{
    private String title;
    private Chapter[] chap;
    private int numOfChapters;

    public Book(String title, int totalChapters){
        this.title = title;
        this.chap = new Chapter[totalChapters];
        this.numOfChapters = 0;
    }

    public void addChapter(){
        Scanner read = new Scanner(System.in);
        String t = read.nextLine();
        this.chap[numOfChapters] = new Chapter(t);
        numOfChapters++;

        read.close();
    }

    public void printChapters(){
        for(int i = 0; i<numOfChapters; i++){
           chap[i].printChapter();
        }
    }
}