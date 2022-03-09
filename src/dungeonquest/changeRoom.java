package dungeonquest;

public class changeRoom {
    
    DungeonQuest game;
    
    public changeRoom(DungeonQuest game) {
        this.game = game;
    }
    
    public void startScreen() {
        game.ui.bgPanel[0].setVisible(true);
        game.ui.bgPanel[1].setVisible(false);
    }
    
    public void showEntrance() {
        game.ui.bgPanel[0].setVisible(false);
        game.ui.bgPanel[1].setVisible(true);
    }
}
