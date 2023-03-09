package com.m2i.apispring.BO;

public class Song {

    String artist;
    String year;
    String album;
    int rank;
    String title;

    public Song() {
    }

    public Song(String artist, String year, String album, int rank, String title) {
        this.artist = artist;
        this.year = year;
        this.album = album;
        this.rank = rank;
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Song{" +
                "artist='" + artist + '\'' +
                ", year='" + year + '\'' +
                ", album='" + album + '\'' +
                ", rank=" + rank +
                ", title='" + title + '\'' +
                '}';
    }
}
