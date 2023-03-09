package com.m2i.apispring.BO;

import com.m2i.apispring.Service.JsonService;

import java.util.ArrayList;

public abstract class SongList extends ArrayList<Song> {

    private static ArrayList<Song> songList = new ArrayList<Song>();

    public static ArrayList<Song> getList() {
        return songList;
    }

    public static void setSongList(ArrayList<Song> sgList) {
        songList = sgList;
    }

    public static Boolean addSong(Song song) {
        if (!songList.contains(song)) {
            songList.add(song);
            songList.get(songList.indexOf(song)).setRank(songList.indexOf(song) + 1);
            return true;
        }
        return false;
    }

    public static Song getSongByRank(int rank) {
        for (Song song : songList) {
            if (song.getRank() == rank) {
                return song;
            }
        }
        return null;
    }

    public static Boolean rmSong(Song song) {
        for (Song sg : songList) {
            if (sg.rank == song.rank) {
                songList.remove(sg);
                return true;
            }
        }
        return false;
    }
}
