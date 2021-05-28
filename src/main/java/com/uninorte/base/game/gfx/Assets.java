package com.uninorte.base.game.gfx;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class Assets {

    public enum BackGrounds {
        bg0,
        bg1,
        bg2,
        bg3,
        bg4,
        bg5,
        bg6,
        bg7,
        bg8,
        bg9,
        bg10,
        bg11
    }

    public enum AlienColor {
        RED,
        YELLOW,
        BLUE,
        WHITE
    }

    public enum AlienName {
        A,
        B,
        C
    }

    public enum ExplosionColor {
        GREEN,
        BLUE,
        CYAN,
        ORANGE,
        PINK,
        PURPLE,
        RED,
        YELLOW
    }

    public enum Fonts {
        SLKSCR_100,
        SLKSCR_10,
    }

    public enum FontsName {
        SLKSCR,
        SPACE_MISSION,
        SPORT_TYPO,
        DEBUG,
    }

    public enum UI_ELEMENTS {
        BUTTONS,
        SLIDER,
        BUTTONS_NON_SQUARE,
        BUTTONSMUTE,
        ARROW_BUTTON_L,
        ARROW_BUTTON_R,
    }

    private static ArrayList<BufferedImage> playerAssets;
    private static ArrayList<BufferedImage> aliensAssets;
    private static ArrayList<BufferedImage> bulletAssets;

    private static HashMap<String, ArrayList<BufferedImage>> explosions;
    private static HashMap<String, ArrayList<BufferedImage>> uiComponents;
    private static HashMap<String, Font> fonts;
    private static HashMap<String, ArrayList<BufferedImage>> background;
    private static HashMap<String, BufferedImage> arrow;

    public static void init() {
        playerAssets = loadSprites(60, 59, 5, "/textures/ships.png");
        aliensAssets = loadSprites(40, 40, 24, "/textures/aliens.png");
        bulletAssets = loadSprites(120, 120, 2, "/textures/bullets.png");

        arrow = new HashMap<>();
        arrow.put(getUiString(UI_ELEMENTS.ARROW_BUTTON_L),ContentLoader.loadImage("/ui/arrow_1.png"));
        arrow.put(getUiString(UI_ELEMENTS.ARROW_BUTTON_R), ContentLoader.loadImage("/ui/arrow.png"));

        explosions = new HashMap<>();
        explosions.put(getColorString(ExplosionColor.GREEN), loadSprites(100, 100, 56, "/textures/explosions/green.png"));
        explosions.put(getColorString(ExplosionColor.BLUE), loadSprites(100, 100, 56, "/textures/explosions/blue.png"));
        explosions.put(getColorString(ExplosionColor.CYAN), loadSprites(100, 100, 56, "/textures/explosions/cyan.png"));
        explosions.put(getColorString(ExplosionColor.ORANGE), loadSprites(100, 100, 56, "/textures/explosions/orange.png"));
        explosions.put(getColorString(ExplosionColor.PINK), loadSprites(100, 100, 56, "/textures/explosions/pink.png"));
        explosions.put(getColorString(ExplosionColor.PURPLE), loadSprites(100, 100, 56, "/textures/explosions/purple.png"));
        explosions.put(getColorString(ExplosionColor.RED), loadSprites(100, 100, 56, "/textures/explosions/red.png"));
        explosions.put(getColorString(ExplosionColor.YELLOW), loadSprites(100, 100, 56, "/textures/explosions/yellow.png"));

        uiComponents = new HashMap<>();
        uiComponents.put(getUiString(UI_ELEMENTS.BUTTONS), loadSprites(105, 21, 4, "/ui/labels.png"));
        uiComponents.put(getUiString(UI_ELEMENTS.BUTTONS_NON_SQUARE), loadSprites(134, 119, 2, "/ui/buttons-hexagons.png"));
        uiComponents.put(getUiString(UI_ELEMENTS.BUTTONSMUTE), loadSprites(50,50,2,"/ui/mutebtns.png"));

        SpriteSheet slidersSheet = new SpriteSheet(ContentLoader.loadImage("/ui/sheet-slider.png"));
        ArrayList<BufferedImage> sliders = new ArrayList<>();
        sliders.add(slidersSheet.crop(0, 0, 440, 33));
        sliders.add(slidersSheet.crop(440, 0, 39, 32));
        uiComponents.put(getUiString(UI_ELEMENTS.SLIDER), sliders);

        fonts = new HashMap<>();
        fonts.put(getFontString(Fonts.SLKSCR_100), ContentLoader.loadFont("/fonts/slkscr.ttf", 100));
        fonts.put(getFontString(Fonts.SLKSCR_10), ContentLoader.loadFont("/fonts/slkscr.ttf", 10));

       /* background = new HashMap<>();
        background.put(getBgsString(BackGrounds.bg1),loadSprites(60, 60, 1, "/backgrounds/background_1.gif"));
        background.put(getBgsString(BackGrounds.bg2),loadSprites(60, 60, 1, "/backgrounds/background_2.png"));
        background.put(getBgsString(BackGrounds.bg3),loadSprites(60, 60, 1, Filenames.BACKGROUND_IMAGES[3]));
        background.put(getBgsString(BackGrounds.bg4),loadSprites(60, 60, 1, Filenames.BACKGROUND_IMAGES[4]));
        background.put(getBgsString(BackGrounds.bg5),loadSprites(60, 60, 1, Filenames.BACKGROUND_IMAGES[5]));
        background.put(getBgsString(BackGrounds.bg6),loadSprites(60, 60, 1, Filenames.BACKGROUND_IMAGES[6]));
        background.put(getBgsString(BackGrounds.bg7),loadSprites(60, 60, 1, Filenames.BACKGROUND_IMAGES[7]));
        background.put(getBgsString(BackGrounds.bg8),loadSprites(60, 60, 1, Filenames.BACKGROUND_IMAGES[8]));
        background.put(getBgsString(BackGrounds.bg9),loadSprites(60, 60, 1, Filenames.BACKGROUND_IMAGES[9]));
        background.put(getBgsString(BackGrounds.bg10),loadSprites(60, 60, 1, "/backgrounds/background_11.jpg"));
        background.put(getBgsString(BackGrounds.bg11),loadSprites(60, 60, 1, "/backgrounds/background_12.jpg"));*/

    }

    public static ArrayList<BufferedImage> getPlayerAssets() {
        return playerAssets;
    }

    public static BufferedImage getArrow(UI_ELEMENTS uiElement){
        return arrow.get(getUiString(uiElement));
    }

    public static ArrayList<BufferedImage> getAliensAssets(AlienName name, AlienColor color) {
        ArrayList<BufferedImage> assets = new ArrayList<>(2);

        int pos = name.ordinal() * 8 + color.ordinal() * 2;

        assets.add(aliensAssets.get(pos));
        assets.add(aliensAssets.get(pos + 1));

        return assets;
    }

    public static ArrayList<BufferedImage> getAliensExplosionsAssets(ExplosionColor color) {
        return explosions.get(getColorString(color));
    }

    public static BufferedImage getBulletAssets(int i) {
        return bulletAssets.get(i);
    }

    public static Font getFont(Fonts font) {
        return fonts.get(getFontString(font));
    }

    public static Font getFont(FontsName fontName, int size) {
        return ContentLoader.loadFont(getFontName(fontName), size);
    }

    public static ArrayList<BufferedImage> getUiComponents(UI_ELEMENTS uiElement) {
        return uiComponents.get(getUiString(uiElement));
    }

    public static BufferedImage rotate(BufferedImage image, double angle) {
        int w = image.getWidth();
        int h = image.getHeight();

        BufferedImage rotated = new BufferedImage(w, h, image.getType());
        Graphics2D graphic = rotated.createGraphics();
        graphic.rotate(Math.toRadians(angle), w >> 1, h >> 1);
        graphic.drawImage(image, null, 0, 0);
        graphic.dispose();
        return rotated;
    }

    private static ArrayList<BufferedImage> loadSprites(int width, int height, int total, String filename) {
        SpriteSheet sheet = new SpriteSheet(ContentLoader.loadImage(filename));
        int count = 0;

        ArrayList<BufferedImage> assets = new ArrayList<>();

        for (int j = 0; j < sheet.getHeight() && count < total; j += height) {
            for (int i = 0; i < sheet.getWidth() && count < total; i += width) {
                assets.add(sheet.crop(i, j, width, height));
                count++;
            }
        }

        return assets;
    }
    private static String getBgsString(BackGrounds background) {
        String bgstring = "";

        switch (background) {
            case bg0 -> bgstring =  "gif";
            case bg1 -> bgstring = "dark";
            case bg2 -> bgstring = "yellow";
            case bg3 -> bgstring = "something";
            case bg4 -> bgstring = "orange";
            case bg5 -> bgstring = "marine";
            case bg6 -> bgstring = "green";
            case bg7 -> bgstring = "purple";
            case bg8 -> bgstring = "pink";
            case bg9 -> bgstring = "blue";
            case bg10 -> bgstring = "bluishpurple";
            case bg11 -> bgstring = "skyblue";

        }

        return bgstring;
    }

    private static String getColorString(ExplosionColor color) {
        String colorStr = "";
        
        switch (color) {
            case GREEN -> colorStr =  "green";
            case RED -> colorStr = "red";
            case YELLOW -> colorStr = "yellow";
            case PINK -> colorStr = "pink";
            case PURPLE -> colorStr = "purple";
            case ORANGE -> colorStr = "orange";
            case BLUE -> colorStr = "blue";
            case CYAN -> colorStr = "cyan";
        }

        return colorStr;
    }

    private static String getFontString(Fonts font) {
        String fontStr = "";

        switch (font) {
            case SLKSCR_100 -> fontStr =  "slkscr100";
        }

        return fontStr;
    }

    private static String getFontName(FontsName name) {
        String fontStr = "";

        switch (name) {
            case SLKSCR -> fontStr =  "/fonts/slkscr.ttf";
            case SPACE_MISSION -> fontStr = "/fonts/space-mission.otf";
            case SPORT_TYPO -> fontStr = "/fonts/sport-typo.ttf";
            case DEBUG -> fontStr = "/fonts/debug.otf";
        }

        return fontStr;
    }

    private static String getUiString(UI_ELEMENTS uiElement) {
        String uiElementStr = "";

        switch (uiElement) {
            case BUTTONS -> uiElementStr =  "buttons";
            case SLIDER -> uiElementStr = "slider";
            case BUTTONS_NON_SQUARE -> uiElementStr = "buttonsNonSquare";
            case ARROW_BUTTON_L -> uiElementStr = "arrow_l";
            case ARROW_BUTTON_R -> uiElementStr = "arrow_r";
        }

        return uiElementStr;
    }

}
