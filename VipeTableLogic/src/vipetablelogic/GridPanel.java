/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vipetablelogic;
import java.awt.*;
import javax.swing.JPanel;
/**
 *
 * @author Steven
 */
public class GridPanel extends JPanel {
    
    private int[] sectors = new int[600];
    
    private void initializeSectors() {
    //add values to the sectors array
        for (int i = 0; i < 150; i++) {
            sectors[i] = 1;
        }
        for (int i = 150; i < 300; i++) {
            sectors[i] = 2;
        }
        for (int i = 300; i < 450; i++) {
            sectors[i] = 3;
        }
        for (int i = 450; i < 600; i++) {
            sectors[i] = 4;
        }
    }
    
    private Color getColor(int id) {
        Color color = null;
        switch(id) {
            case 1 : color = color.red; break;
            case 2 : color = color.green; break;
            case 3 : color = color.blue; break;
            case 4 : color = color.yellow; break;
            case 5 : color = color.magenta; break;
            case 6 : color = color.orange; break;
            default: color = color.white; break;
        }
        return color;
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        initializeSectors();
        int spot = 0;
        for (int c = 0; c < 30; c++) {
            for (int r = 0; r < 20; r++) {
                    graphics.setColor(getColor(sectors[(r * 20) + c]));
                    graphics.fillRect(c * 20, r * 20, 20, 20);
            }
        }
        
        graphics.setColor(Color.black);
        for (int i = 0; i < 30; i++) {
            graphics.drawLine(i * 20, 0, i * 20, 400);
        }
        
        
//        graphics.setColor(Color.red);
//        graphics.fillRect(50, 50, 100, 100);
    }
}
