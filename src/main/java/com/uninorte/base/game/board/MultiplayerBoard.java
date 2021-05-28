package com.uninorte.base.game.board;

import com.uninorte.base.api.GameClient;
import com.uninorte.base.game.Handler;

import java.awt.*;

public class MultiplayerBoard {

    private Handler handler;
    private GameClient gameClient;

    public MultiplayerBoard(Handler handler) {
        this.handler = handler;

        gameClient = handler.getGameClient();
    }

    public void update() {

    }

    public void render(Graphics g) {

    }

}
