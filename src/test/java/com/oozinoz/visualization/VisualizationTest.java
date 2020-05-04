package com.oozinoz.visualization;

import org.junit.Ignore;
import org.junit.Test;

import com.oozinoz.ui.SwingFacade;

import javax.swing.JFrame;

/**
 * @author glick
 */
@Ignore
public class VisualizationTest {

    @Test
    public void testMain() {
        Visualization v = new Visualization();
        JFrame f = SwingFacade.launch(v.vizPanel(), " Mini Sim");
    }
}
