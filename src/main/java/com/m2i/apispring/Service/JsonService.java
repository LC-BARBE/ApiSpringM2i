package com.m2i.apispring.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.apispring.BO.Song;
import com.m2i.apispring.BO.SongList;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;

public abstract class JsonService {

    final static ObjectMapper objectMapper = new ObjectMapper();

    public static void getSongByJsonFile() throws FileNotFoundException, JsonProcessingException {
        JSONObject jsonObject = new JSONObject(new JSONTokener(new FileReader("src\\main\\resources\\songs.json")));
        String jsonSongs = objectMapper.writeValueAsString(jsonObject.toString());
        Song[] songs = objectMapper.readValue(jsonObject.getJSONArray("songs").toString(), Song[].class);
        for (Song song : songs) {
            SongList.addSong(song);
        }
    }

    public static String deserializeSong(Song song) throws JsonProcessingException {
        return objectMapper.writeValueAsString(song);
    }
    public static Song serializeSong(String str) throws JsonProcessingException {
        return objectMapper.readValue(str, Song.class);
    }

}
