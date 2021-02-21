package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        Song tempSong = findSong(title);
        if (tempSong == null) {
            tempSong = new Song(title, duration);
            this.songs.add(tempSong);
            return true;
        } else {
            return false;
        }

    }

    private Song findSong(String titleOfSong) {
        for (int i = 0; i < this.songs.size(); i++) {
            Song song = this.songs.get(i);
            if (song.getTitle().equals(titleOfSong)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumberOfSongsInTheAlbum, LinkedList<Song> thePlaylist) {
        int index = trackNumberOfSongsInTheAlbum -1;
        if ((index > 0) && (index<=this.songs.size())){
            thePlaylist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumberOfSongsInTheAlbum);
        return false;
    }

    public boolean addToPlayList(String titleOfSong, LinkedList<Song> thePlaylist) {
        Song tempSong = findSong(titleOfSong);
        if (tempSong != null){
            thePlaylist.add(tempSong);
            return true;

        }
        System.out.println("The song " + titleOfSong + " is not in the album");
        return false;
    }

}
