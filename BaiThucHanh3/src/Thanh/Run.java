/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thanh;

import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Windows 10
 */
public class Run {
    public static void main(String[] args) throws IOException {
        Frame f = new Frame();
        f.setSize(500, 500);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
}
