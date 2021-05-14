package com.uninorte.base.game.entities.creatures;

import com.uninorte.base.game.Handler;
import com.uninorte.base.game.gfx.Assets;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Creature {

    private ProjectilesManager projectilesManager;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, new Dimension(60, 60));

        creatureAssetsOptions = Assets.getPlayerAssets();
        creatureAsset = creatureAssetsOptions.get(0);

        projectilesManager = new ProjectilesManager(800);
    }

    @Override
    public void update() {
        getInput();
        move();
        shoot();

        if (checkEntityCollisions(0, 0)) {
            System.out.println("lose");
        }

        projectilesManager.update();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(creatureAsset, (int) x, (int) y, entityDimensions.width, entityDimensions.height, null);
        g.setColor(Color.white);
        g.drawString(Integer.toString(handler.getHighScoreManager().getPlayerPoints(this)), 30, 30);

        projectilesManager.render(g);
    }

    @Override
    public void die() {
        System.out.println("die");
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().getStatusKey(KeyEvent.VK_A))
            xMove = -speed;
        if (handler.getKeyManager().getStatusKey(KeyEvent.VK_D))
            xMove = speed;

    }

    @Override
    public void move() {
        moveX();
    }

    @Override
    public void moveX() {
        if (x + xMove + entityDimensions.width >= handler.boardDimensions().width) {
            x = handler.boardDimensions().width - entityDimensions.width;
        } else if (x + xMove <= 0) {
            x = 0;
        } else {
            x += xMove;
        }
    }

    @Override
    public void hurt(int amt) {
        super.hurt(amt);

        System.out.println("Ey loco me lastimaste");
    }

    private void shoot() {
        projectilesManager.addProjectile(() -> handler.getKeyManager().getStatusKey(KeyEvent.VK_SPACE) || true,
                new Projectile(handler, x, y, Projectile.Direction.UP, this, Color.red));
    }
}
