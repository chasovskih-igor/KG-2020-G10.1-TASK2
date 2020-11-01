package com.company.LineDrawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.Color;

public class WuLineDrawer implements LineDrawer {
    private final PixelDrawer pd;

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double gradientX= dx / dy;
        double gradientY= dy / dx;
        if (Math.abs(dx) >= Math.abs(dy)) {
            if (x1 > x2) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
                y1 = y2;
            }
            double y = y1;
            for (int x = x1; x <= x2; x++) {
                pd.drawPixel(x, (int) y, new Color(0,0,0, (float) (1 - (y - (int) y))));
                pd.drawPixel(x, (int) y + 1, new Color(0,0,0, (float) (y - (int) y)));
                y += gradientY;
            }
        } else {
            if (y1 > y2) {
                int tmp = y1;
                y1 = y2;
                y2 = tmp;
                x1 = x2;
            }
            double x = x1;
            for (int y = y1; y <= y2; y++) {
                pd.drawPixel((int) x, y, new Color(0,0,0, (float) (1 - (x - (int) x))));
                pd.drawPixel((int) x + 1, y, new Color(0,0,0, (float) (x - (int) x)));
                x += gradientX;
            }
        }
    }
}