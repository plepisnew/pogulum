package com.example.pogulum.controllers;

import com.example.pogulum.model.Game;
import com.example.pogulum.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @PostMapping("/api/game")
    public ResponseEntity<Game> addGame(@RequestBody Game game){
        return new ResponseEntity<>(gameService.saveGame(game), HttpStatus.OK);
    }

    @GetMapping("/api/game")
    public ResponseEntity<Game> getGameById(@RequestParam("id") Long id){
        return new ResponseEntity<>(gameService.getGame(id), HttpStatus.OK);
    }

    @GetMapping("/api/games")
    public ResponseEntity<List<Game>> getGames(){
        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK);
    }
     @PutMapping("/api/game")
public ResponseEntity<Game> updateGame(@RequestBody Game game){
        return new ResponseEntity<>(gameService.saveGame(game), HttpStatus.OK);
    }

    @DeleteMapping("/api/game")
    public ResponseEntity<Game> deleteGameById(@RequestParam("id") Long id){
        return new ResponseEntity<>(gameService.deleteGame(id), HttpStatus.OK);
    }

}
