package Week8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Song {
    private String title;
    private String artist;
    private String genre;

    public Song(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }
}

class GenreFilterIterator implements Iterator<Song> {
    private List<Song> playlist;
    private String targetGenre;
    private int currentIndex;

    public GenreFilterIterator(List<Song> playlist, String targetGenre) {
        this.playlist = playlist;
        this.targetGenre = targetGenre;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < playlist.size()) {
            if (playlist.get(currentIndex).getGenre().equals(targetGenre)) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public Song next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more songs with the target genre.");
        }
        return playlist.get(currentIndex++);
    }
}

public class SongSystem {
    public static void main(String[] args) {

        List<Song> playlist = new ArrayList<>();
        playlist.add(new Song("Rolling in the Deep", "Adele", "Pop"));
        playlist.add(new Song("Smells like Teen Spirit", "Nirvana", "Rock"));
        playlist.add(new Song("Let You Down", "NF", "Pop"));
        playlist.add(new Song("Slow Down", "One For All", "Hip-Hop"));
        playlist.add(new Song("Iron Man", "Black Sabbath", "Rock"));


        GenreFilterIterator iterator = new GenreFilterIterator(playlist, "Rock");

        while (iterator.hasNext()) {
            Song song = iterator.next();
            System.out.println("Title: " + song.getTitle() + " / Artist: " + song.getArtist() + " / Genre: " + song.getGenre());
        }
    }
}

