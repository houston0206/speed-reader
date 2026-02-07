package edu.grinnell.csc207.speedreader;

import java.util.Scanner;
import java.io.File;
import java.awt.*;
import java.io.IOException;

/** 
 * SpeedReader class: uses the wordGenerator class to run a text file with the 
 * drawing panel
 */
public class SpeedReader {

    public static void drawPanel(int width, int height, int fontSize, String word) {
        DrawingPanel frame = new DrawingPanel(width, height);
        Graphics g = frame.getGraphics();
        g.setFont(new Font("Courier", Font.BOLD, fontSize));
        g.drawString(word, 100, 100);
    }



    /** 
     * Runs the speed reader and returns the number of sentences and words rendered 
     * once the file has been completely read through.
     * @param args an array of strings consisting of the filename, width, height, font size,
     * and words per minute to be read at
     */
    public static void main(String[] args) throws IOException{
        if (args.length != 5){
            System.out.println("Usage: SpeedReader <filename> <width> <height> <font size> <wpm>");
            System.exit(1);
        }
        String fileName = args[0];
        int width = Integer.parseInt(args[1]);
        int height = Integer.parseInt(args[2]);
        int fontSize = Integer.parseInt(args[3]);
        double timePerWord = 60000.0 / Integer.parseInt(args[4]);
        WordGenerator speedReader = new WordGenerator(fileName);
        while (speedReader.hasNext()){
            drawPanel(width, height, fontSize, speedReader.next());
            try {
                Thread.sleep((long) (timePerWord));  
            } catch (Exception InterruptedException) {
                System.out.println("Interrupted.");
            }
        }
        System.out.println("Number of words rendered: " + speedReader.getWordCount());
        System.out.println("Number of sentences rendered: " + speedReader.getSentenceCount());
        System.exit(1);
    }  
}
