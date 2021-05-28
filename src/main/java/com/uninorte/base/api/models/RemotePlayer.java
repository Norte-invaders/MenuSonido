package com.uninorte.base.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.uninorte.base.game.entities.creatures.Player;

import java.awt.*;

public class RemotePlayer extends Base {

    @JsonProperty("user") protected User user;
    @JsonProperty("player") protected Player player;

    public RemotePlayer(User user, Player player) {
        this.user = user;
        this.player = player;
    }

    public RemotePlayer() {
    }

    public static RemotePlayer createFromJson(String json) {
        return (RemotePlayer) new RemotePlayer().fromJson(json);
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void render(Graphics g, float x, float y, boolean center) {
    }
}
