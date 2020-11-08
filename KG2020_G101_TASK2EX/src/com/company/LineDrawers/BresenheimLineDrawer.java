package com.company.LineDrawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class BresenheimLineDrawer implements LineDrawer {
    private final PixelDrawer pd;

    public BresenheimLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }


    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {

        int x, y, err;
        int dx = (x2 - x1 >= 0 ? 1 : -1);
        int dy = (y2 - y1 >= 0 ? 1 : -1);
        int lenX = Math.abs(x2 - x1);
        int lenY = Math.abs(y2 - y1);
        int length = Math.max(lenX, lenY);
        x = x1;
        y = y1;
        if (lenY > lenX) {
            err = -lenY;
            length++;
            while (length != 0) {
                length--;
                pd.drawPixel(x, y, Color.black);
                y += dy;
                err += 2 * lenX;
                if (err > 0) {
                    err -= 2 * lenY;
                    x += dx;
                }
            }
        } else {
            err = -lenX;
            length++;
            while (length != 0) {
                length--;
                pd.drawPixel(x, y, Color.blue);
                x += dx;
                err += 2 * lenY;
                if (err > 0) {
                    err -= 2 * lenX;
                    y += dy;
                }
            }
        }
    }
}
