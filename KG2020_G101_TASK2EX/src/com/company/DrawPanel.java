package com.company;

import com.company.LineDrawers.BresenheimLineDrawer;
import com.company.LineDrawers.DDALineDrawer;
import com.company.LineDrawers.GraphicsLineDrawer;
import com.company.LineDrawers.WuLineDrawer;
import com.company.utils.drawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener {
    private Point position = new Point(0, 0);

    DrawPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        PixelDrawer pd = new GraphicsPixelDrawer(bi_g);
        LineDrawer ld = new WuLineDrawer(pd);
        bi_g.setColor(Color.WHITE);
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        bi_g.setColor(Color.BLACK);

        drawAll(ld);

        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();

    }

    private void drawAll(LineDrawer ld) {
        drawUtils.drawSnowflake(ld, getWidth() / 2, getHeight() / 2, 120, 50);
        ld.drawLine(getWidth() / 2, getHeight() / 2, position.x, position.y);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        position = new Point(e.getX(), e.getY());
        repaint();
    }
}
