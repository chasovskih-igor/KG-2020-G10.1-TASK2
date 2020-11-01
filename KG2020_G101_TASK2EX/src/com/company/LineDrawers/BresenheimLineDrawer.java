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
        int k = 1;
        if (x1 > x2) {
            int temp = x1;
            x1 = x2;
            x2 = temp;
            temp = y1;
            y1 = y2;
            y2 = temp;
        }
        if (y1 > y2) k *= -1;
        int x = x1;
        int y = y1;
        int dx = x2 - x1;
        int dy = y2 - y1;
        int error = 2 * dy * k - dx;
        if (Math.abs(dx) >= Math.abs(dy)) {
            for (int i = 0; i <= Math.abs(dx); i++) {
                pd.drawPixel(x, y, Color.black);
                if (error >= 0) {
                    y += k;
                    error += 2 * (dy * k - dx);
                } else
                    error += 2 * dy * k;
                x++;
            }
        } else {
            for (int i = 0; i <= Math.abs(dy); i++) {
                pd.drawPixel(x, y, Color.blue);
                if (error >= 0) {
                    x++;
                    error += 2 * (dx - dy * k);
                } else
                    error += 2 * dx;
                y += k;
            }
        }
    }
}
