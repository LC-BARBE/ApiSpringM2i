package com.m2i.apispring.BO;

import java.util.ArrayList;

public abstract class SongList extends ArrayList<Song> {

    private static ArrayList<Song> songList = new ArrayList<Song>();

    public static ArrayList<Song> getList() {
        return songList;
    }

    public static void setSongList(ArrayList<Song> sgList) {
        songList = sgList;
    }

    public static void addSong(Song song) {
        songList.add(song);
        songList.get(songList.indexOf(song)).setRank(songList.indexOf(song)+1);
    }

    public static Song getSongByRank(int rank) {
        for (Song song : songList) {
            if (song.getRank() == rank) {
                return song;
            }
        }
        return null;
    }

    public static void rmSong(Song song) {
        songList.remove(song);
    }
}
