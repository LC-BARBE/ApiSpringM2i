package com.m2i.apispring.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.apispring.BO.SongList;
import com.m2i.apispring.Service.JsonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
public class songController {

    final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/byRank")
    public String getSongByRank(@RequestParam(name = "rank") int rank) throws JsonProcessingException {
        System.out.println(rank);
        return JsonService.deserializeSong(SongList.getSongByRank(rank));
    }

    @GetMapping("/all")
    public String getAllSong() throws JsonProcessingException {
        return objectMapper.writeValueAsString(SongList.getList());
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity addSong(@RequestBody String request) {
        try {
            SongList.addSong(JsonService.serializeSong(request));
        } catch (Exception e) {
            return ResponseEntity.ok(HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity rmSong(@RequestBody String request) {
        try {
            SongList.rmSong(JsonService.serializeSong(request));
        } catch (Exception e) {
            return ResponseEntity.ok(HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity updateSong(@RequestBody String request) {
        try {
            SongList.upDateSong(JsonService.serializeSong(request));
        } catch (Exception e) {
            return ResponseEntity.ok(HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
