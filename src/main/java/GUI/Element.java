package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The type Element.
 */
public class Element {
    /**
     * The Colours.
     */
    public ArrayList<Color> colours = new ArrayList<>();
    /**
     * The Fonts.
     */
    public ArrayList<Font> fonts = new ArrayList<>();

    /**
     * Instantiates a new Element.
     */
    public Element(){
        colours.add(Color.decode("#8B5D33"));   // coyote brown
        colours.add(Color.decode("#91785D"));   // pale chestnut
        colours.add(Color.decode("#869D7A"));   // artichoke
        colours.add(Color.decode("#A7CDBD"));   // cambridge blue
        colours.add(Color.decode("#BBE1C3"));   // turquoise green

        fonts.add(new Font("Courier new", Font.BOLD, 20));      // button_main
        fonts.add(new Font("Courier new", Font.PLAIN, 16));     // labels/texts
        fonts.add(new Font("Courier new", Font.BOLD, 16));      // subtitles(?)
        fonts.add(new Font("Courier new", Font.BOLD, 40));      // title
        fonts.add(new Font("Courier new", Font.PLAIN, 12));
    }
}
