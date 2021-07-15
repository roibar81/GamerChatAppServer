package dao;

import static org.junit.Assert.*;
import java.util.ArrayList;
import com.hit.dao.*;
import com.hit.dm.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddGameTest {
    private Game game;
    private Game game2;
    private Game game3;
    private Game game4;
    private Game game5;
    private ArrayList<Game> gamesList;
    private DbHandle dbHandle;

    @Before
    public void beforeTest() {
        dbHandle = DbHandleImpl.getInstance();
        gamesList = new ArrayList<>();
        game = new Game("Warcraft", 2131165334, "strategy");
        game2 = new Game("Gta v", 2131165286, "action");
        game3 = new Game("fifa22", 2131165285, "sport");
        game4 = new Game("nba 2k", 2131165317, "sport");
        game5 = new Game("heroes", 2131165287, "strategy");
        
    }

    @Test
    public void test() {
        dbHandle.addGame(game);
        dbHandle.addGame(game2);
        dbHandle.addGame(game3);
        dbHandle.addGame(game4);
        dbHandle.addGame(game5);
    }

    @After
    public void afterTest() {
        gamesList = dbHandle.getAllGames();
        for(Game g : gamesList)
            System.out.println(g);
    }

}
