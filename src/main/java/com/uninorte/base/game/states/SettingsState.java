package com.uninorte.base.game.states;

import com.uninorte.base.game.Handler;
import com.uninorte.base.game.ui.StaticElements;
import com.uninorte.base.game.ui.UIButton;
import com.uninorte.base.game.ui.UISlider;

import java.awt.*;

public class SettingsState extends State {

    public SettingsState(Handler handler) {
        super(handler);
    }

    protected void initComponents() {
        int x = (int) (handler.boardDimensions().width * 0.5f - 128 / 2);
        int y = (int) (handler.boardDimensions().height / 2 + 101);

        UISlider uiSliderbg = new UISlider(this,  x - 150, y / 2 + 10, 30, 40, (value) -> handler.getGame().setVolume(0,value));
        try {
            uiSliderbg.setValue(handler.getGame().sound.getVolume("background"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        UISlider uiSlideref = new UISlider(this, x - 150, y / 2 + 150, 30, 40,(System.out::println));
        uiSlideref.setValue(50);

        UIButton uimenu = StaticElements.menuBtn(this,handler,x + 30,y + 170);

        UIButton uiMuteBtnSound = new UIButton(this,x + 300, y / 2 , UIButton.btnUnMuteImage,  () -> isMuted() );
        UIButton uiMuteBtnEff =  new UIButton(this, x + 300, y / 2 + 140 , UIButton.btnUnMuteImage,  () -> handler.getGame().setMuted(1) );
        UIButton btnBg = new UIButton(this,x+300,y / 2 + 200, UIButton.btnUnMuteImage, () -> {handler.getGame().setBackground();
            System.out.println("clicked");});

        uiManager.addObjects(uiSliderbg,uiSlideref,uimenu,uiMuteBtnSound, uiMuteBtnEff, btnBg);

    }

    public void isMuted(){
        System.out.println("clicked");
        handler.getGame().setMuted(0);
    }

    @Override
    public void update() {
        handler.getGame().changeTitle("Settings");
        uiManager.update();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }

}
