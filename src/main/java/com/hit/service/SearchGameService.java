package com.hit.service;

import java.util.ArrayList;

import com.hit.algorithm.IAlgoStringMatching;
import com.hit.dm.Game;
import com.hit.field_util.GameField;
import com.hit.server.Request;
import com.hit.server.Request.*;
import com.hit.server.Response;

public class SearchGameService implements Services{

    private IAlgoStringMatching iAlgoStringMatching;
    private GameField gameField;
    private Response response;
    private ArrayList<Game> gamesList;

    
    public SearchGameService(IAlgoStringMatching iAlgoStringMatching, GameField gameField) {
        this.iAlgoStringMatching = iAlgoStringMatching;
        this.gameField = gameField;
        this.response = new Response(new Header("search-game-list"), new Body());
        this.gamesList = new ArrayList<>();
    }


    @Override
    public Response executeService(Request request) {
        gamesList = request.getBody().getGameList();
        for(Game game : gamesList) {
            if(!iAlgoStringMatching.searchStringMatching(request.getBody().getPattern(), 
                gameField.getGameField(game))){
                    gamesList.remove(game);
                }
        }
        response.getBody().setUser(request.getBody().getUser());
        response.getBody().setGameList(gamesList);
        return response;
    }
    
}
