package com.oozinoz.visualization;

import com.oozinoz.ui.SwingFacade;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * Copyright (c) 2001 Steven J. Metsker.
 *
 * Steve Metsker makes no representations or warranties about
 * the fitness of this software for any particular purpose,
 * including the implied warranty of merchantability.
 *
 * Please use this software as you wish with the sole
 * restriction that you may not claim that you wrote it.
 */

/**
 * This extension adds a menu bar with Save and Load
 * items.
 * <p>
 * Like its superclass, this class expects a "machine.gif"
 * file to lie in its classpath.
 *
 * @author Steven J. Metsker
 */
public class Visualization2 extends Visualization {
    protected JFileChooser fc;
    protected JMenuBar menuBar;
    protected JMenu fileMenu;

    protected JFileChooser fc() {
        if (fc == null) {
            fc = new JFileChooser();
        }
        return fc;
    }

    protected JMenu fileMenu() {
        if (fileMenu == null) {
            fileMenu = new JMenu("File");
            Font f = SwingFacade.getStandardFont();
            fileMenu.setFont(f);

            JMenuItem save = new JMenuItem("Save");
            save.setFont(f);
            fileMenu.add(save);
            save.addActionListener(
                e -> save()
            );

            JMenuItem load = new JMenuItem("Load");
            load.setFont(f);
            fileMenu.add(load);
            load.addActionListener(e -> load());
        }
        return fileMenu;
    }

    protected void load() {
        int dialogStatus = fc().showOpenDialog(null);
        if (dialogStatus == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {

                List m = (List) in.readObject();
                mementos.removeAllElements();
                // ToDo: there are Lists of ma chineImages mixed nup with a Stack of same
                // ToDo: something(s) seem off -- look more closely
                mementos.addAll(m);
                factory().restore(m);
                undoButton().setEnabled(false);
                vizPanel().repaint();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Show the addition of persistent storage to the
     * visualization.
     */
    public static void main(String[] args) {
        Visualization2 v = new Visualization2();

        JFrame f = SwingFacade.launch(v.vizPanel(), " Mini Sim 2");

        f.setJMenuBar(v.menuBar());
        f.pack();
    }

    protected JMenuBar menuBar() {
        if (menuBar == null) {
            menuBar = new JMenuBar();
            // ToDo: sonarlint says that the next line is a no-op
            // ToDo: commenting it out to see what if anything changes
            // ToDo: the fileMenu that is constructed doesn't get used
            // ToDo: the fileMenu() call is what is actually active here
            // Menu fileMenu = new Menu("File");
            menuBar.add(fileMenu());
        }
        return menuBar;
    }

    protected void save() {
        int status = fc().showSaveDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {

                out.writeObject(mementos.peek());
                out.flush();
            }
            catch (IOException e) {
                // explain the problem and offer to try again
            }
        }
    }
}
