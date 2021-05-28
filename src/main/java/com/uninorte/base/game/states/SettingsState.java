package com.uninorte.base.game.states;

import com.uninorte.base.Filenames;
import com.uninorte.base.game.Handler;
import com.uninorte.base.game.gfx.ContentLoader;
import com.uninorte.base.game.ui.StaticElements;
import com.uninorte.base.game.ui.UIButton;
import com.uninorte.base.game.gfx.Assets;
import com.uninorte.base.game.gfx.Text;
import com.uninorte.base.game.ui.UISlider;
import com.uninorte.base.sound.Sound;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static com.uninorte.base.game.gfx.Assets.UI_ELEMENTS.ARROW_BUTTON_L;
import static com.uninorte.base.game.gfx.Assets.UI_ELEMENTS.ARROW_BUTTON_R;

public class SettingsState extends State {

    private int index;
    protected ArrayList<BufferedImage> playerAssetsOptions;
    protected BufferedImage playerAssets;
    protected int x,y;
    int a =1;

    public SettingsState(Handler handler) {
        super(handler);
    }

    protected void initComponents() {
        x = (int) (handler.boardDimensions().width * 0.5f - 128 / 2);
        y = (int) (handler.boardDimensions().height / 2 + 101);

        UISlider uiSliderbg = new UISlider(this,  x - 160, y / 2 + 10, 30, 40, (value) -> handler.getGame().setVolume(0, value));
        try{
            uiSliderbg.setValue(handler.getGame().sound.getVolume(Sound.BACKGROUND));
        }catch (Exception e) {
            e.printStackTrace();
        }

        UISlider uiSlideref = new UISlider(this, x - 160, y / 2 + 150, 30, 40, (value) -> handler.getGame().setVolume(1, value));
        UISlider uiSlidereff = new UISlider(this, x - 160, y / 2 + 150, 30, 40, (value) -> handler.getGame().setVolume(2, value));
        UISlider uiSliderefff = new UISlider(this, x - 160, y / 2 + 150, 30, 40, (value) -> handler.getGame().setVolume(3, value));
        try {
            uiSlideref.setValue(handler.getGame().sound.getVolume(Sound.GAMEOVER));
        } catch (Exception e) {
            e.printStackTrace();
        }

        UIButton uimenu = StaticElements.menuBtn(this,handler,x + 30,y + 170);

        UIButton uiMuteBtnSound = new UIButton(this,x + 300, y / 2 , UIButton.btnUnMuteImage,  () -> handler.getGame().setMuted(0) );
        UIButton uiMuteBtnEff =  new UIButton(this, x + 300, y / 2 + 140 , UIButton.btnUnMuteImage,  () -> handler.getGame().setMuted(1) );
        UIButton btnBg = new UIButton(this,x+300,y / 2 + 200, (ContentLoader.loadImage(Filenames.BACKGROUND_IMAGES[a])).getSubimage(0,0,40,40), () -> {handler.getGame().setBackground();
        a += 1;
        uiManager.getFocusedElement().update();
        });
        index = 0;

        UIButton uiShipSelectionBtn = new UIButton(this, x + 125, y + 70, Assets.getArrow(ARROW_BUTTON_R), () -> index++);
        UIButton uiShipSelectionIzqBtn = new UIButton(this, x + 5 , y + 70, Assets.getArrow(ARROW_BUTTON_L) , ()-> index--);

        uiManager.addObjects(uiSliderbg,uiSlideref,uimenu,uiMuteBtnSound, uiMuteBtnEff, btnBg, uiShipSelectionBtn,uiShipSelectionIzqBtn);
    }

    @Override
    public void update() {
        handler.getGame().changeTitle("Settings");
        uiManager.update();
    }

    @Override
    public void render(Graphics g) {
        Text.drawString(g, "SETTINGS",
                handler.boardDimensions().width / 2 + 15,
                handler.boardDimensions().height / 9,
                true,
                Color.WHITE,
                Assets.getFont(Assets.FontsName.DEBUG, 100));
        Text.drawString(g, "Background",
                handler.boardDimensions().width / 2 + 15,
                handler.boardDimensions().height / 4 + 35,
                true,
                Color.WHITE,
                Assets.getFont(Assets.FontsName.DEBUG, 35));
        Text.drawString(g, "Effects",
                handler.boardDimensions().width / 2 + 15 ,
                handler.boardDimensions().width / 4 + 90,
                true,
                Color.WHITE,
                Assets.getFont(Assets.FontsName.DEBUG, 35));
        uiManager.render(g);

        playerAssetsOptions = Assets.getPlayerAssets();

        if( index < 0 )
            index = 2;

        if( index > 2 )
            index = 0;

        playerAssets = playerAssetsOptions.get(index);
        g.drawImage(playerAssets,x + 50, y + 50, null);

    }

}
