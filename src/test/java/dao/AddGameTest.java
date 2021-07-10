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
    private ArrayList<Game> gamesList;
    private DbHandle dbHandle;

    @Before
    public void beforeTest() {
        dbHandle = DbHandleImpl.getInstance();
        gamesList = new ArrayList<>();
        game = new Game(0, "Warcraft", "/Users/orissacci/Downloads/warcraft.png", "strategy");
        
    }

    @Test
    public void test() {
        dbHandle.addGame(game);
    }

    @After
    public void afterTest() {
        gamesList = dbHandle.getAllGames();
        for(Game g : gamesList)
            System.out.println(g);
    }

}
