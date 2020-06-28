package engine;

public class Geometry
{
    public static double vectorField(double pX1, double pY1, double pX2, double pY2, double pX3, double pY3)
    {
        return((((pX2 - pX3) * (pY1 - pY3)) - ((pX1 - pX3) * (pY2 - pY3))) / 2);
    }
    public static double distance(double pX1, double pY1, double pX2, double pY2)
    {
        return (Math.sqrt(Math.pow(pX1 - pX2, 2) + Math.pow(pY1 - pY2, 2)));
    }
    public static void paint(int x, int y, int c)
    {
        World.canvas.getImg().getP()[y * World.canvas.getImg().getW() + x] = c;
    }
    public static void brush(int p, int s, int c)
    {
        int x = p % World.canvas.getImg().getW();
        int y = p / World.canvas.getImg().getW();
        br(x, y, x, y, s, c);
    }
    public static void brush(int x, int y, int s, int c)
    {
        br(x, y, x, y, s, c);
    }
    private static void br(int x, int y, int u, int v, int s, int c)
    {
        paint(x, y, c);
        if((x < World.canvas.getImg().getW() - 1) && (distance(x + 1, y, u, v) <= s) && (distance(x + 1, y, u, v) >= distance(x, y, u, v)) && (vectorField(x + 1, y, x, y, u, v) >= 0))
            br(x + 1, y, u, v, s, c);
        if((x > 0) && (distance(x - 1, y, u, v) <= s) && (distance(x - 1, y, u, v) >= distance(x, y, u, v)) && (vectorField(x - 1, y, x, y, u, v) >= 0))
            br(x - 1, y, u, v, s, c);
        if((y < World.canvas.getImg().getH() - 1) && (distance(x, y + 1, u, v) <= s) && (distance(x, y + 1, u, v) >= distance(x, y, u, v)) && (vectorField(x, y + 1, x, y, u, v) >= 0))
            br(x, y + 1, u, v, s, c);
        if((y > 0) && (distance(x, y - 1, u, v) <= s) && (distance(x, y - 1, u, v) >= distance(x, y, u, v)) && (vectorField(x, y - 1, x, y, u, v) >= 0))
            br(x, y - 1, u, v, s, c);
    }
    public static void line(int p1, int p2, int s, int c)
    {
        int x1 = p1 % World.canvas.getImg().getW();
        int y1 = p1 / World.canvas.getImg().getW();
        int x2 = p2 % World.canvas.getImg().getW();
        int y2 = p2 / World.canvas.getImg().getW();
        ln(x1, y1, x2, y2, x1, y1, s, c);
    }
    public static void line(int x1, int y1, int x2, int y2, int s, int c)
    {
        ln(x1, y1, x2, y2, x1, y1, s, c);
    }
    private static void ln(int x1, int y1, int x2, int y2, int u, int v, int s, int c)
    {
        int x = Math.abs(x1 - x2);
        int y = Math.abs(y1 - y2);
        if(x != 0)
        {
            double r = (double)y / (double)x;
            if(r >= 1)
            {
                if((x2 - x1 > 0) && (y2 - y1 >= 0))
                {
                    for(int i = 0; i <= y; i++)
                    {
                        World.canvas.getImg().getP()[(int)((int)(y1 + (double)i) * World.canvas.getImg().getW() + x1 + ((double)i / r))] = c;
                    }
                }
                else if((x2 - x1 < 0) && (y2 - y1 >= 0))
                {
                    for(int i = 0; i <= y; i++)
                    {
                        World.canvas.getImg().getP()[(int)((int)(y1 + (double)i) * World.canvas.getImg().getW() + x1 - ((double)i / r))] = c;
                    }
                }
                else if((x2 - x1 < 0) && (y2 - y1 < 0))
                {
                    for(int i = 0; i <= y; i++)
                    {
                        World.canvas.getImg().getP()[(int)((int)(y2 + (double)i) * World.canvas.getImg().getW() + x2 + ((double)i / r))] = c;
                    }
                }
                if((x2 - x1 > 0) && (y2 - y1 < 0))
                {
                    for(int i = 0; i <= y; i++)
                    {
                        World.canvas.getImg().getP()[(int)((int)(y2 + (double)i) * World.canvas.getImg().getW() + x2 - ((double)i / r))] = c;
                    }
                }
            }
            else
            {
                if((x2 - x1 > 0) && (y2 - y1 >= 0))
                {
                    for(int i = 0; i <= x; i++)
                    {
                        World.canvas.getImg().getP()[(int)((int)(y1 + (double)i * r) * World.canvas.getImg().getW() + x1 + (double)i)] = c;
                    }
                }
                else if((x2 - x1 < 0) && (y2 - y1 >= 0))
                {
                    for(int i = 0; i <= x; i++)
                    {
                        World.canvas.getImg().getP()[(int)((int)(y1 + (double)i * r) * World.canvas.getImg().getW() + x1 - (double)i)] = c;
                    }
                }
                else if((x2 - x1 < 0) && (y2 - y1 < 0))
                {
                    for(int i = 0; i <= x; i++)
                    {
                        World.canvas.getImg().getP()[(int)((int)(y2 + (double)i * r) * World.canvas.getImg().getW() + x2 + (double)i)] = c;
                    }
                }
                if((x2 - x1 > 0) && (y2 - y1 < 0))
                {
                    for(int i = 0; i <= x; i++)
                    {
                        World.canvas.getImg().getP()[(int)((int)(y2 + (double)i * r) * World.canvas.getImg().getW() + x2 - (double)i)] = c;
                    }
                }
            }
        }
        else
        {
            for(int i = Math.min(y1, y2); i <=Math.min(y1, y2); i++)
            {
                World.canvas.getImg().getP()[(y2 + i * World.canvas.getImg().getW())] = c;
            }
        }
        if((x1 < World.canvas.getImg().getW() - 1) && (x2 < World.canvas.getImg().getW() - 1) && (distance(x1 + 1, y1, u, v) <= s) && (distance(x1 + 1, y1, u, v) >= distance(x1, y1, u, v)) && (vectorField(x1 + 1, y1, x1, y1, u, v) >= 0))
            ln(x1 + 1, y1, x2 + 1, y2, u, v, s, c);
        if((x1 > 0) && (x2 > 0) && (distance(x1 - 1, y1, u, v) <= s) && (distance(x1 - 1, y1, u, v) >= distance(x1, y1, u, v)) && (vectorField(x1 - 1, y1, x1, y1, u, v) >= 0))
            ln(x1 - 1, y1, x2 - 1, y2, u, v, s, c);
        if((y1 < World.canvas.getImg().getH() - 1) && (y2 < World.canvas.getImg().getH() - 1) && (distance(x1, y1 + 1, u, v) <= s) && (distance(x1, y1 + 1, u, v) >= distance(x1, y1, u, v)) && (vectorField(x1, y1 + 1, x1, y1, u, v) >= 0))
            ln(x1, y1 + 1, x2,y2 + 1, u, v, s, c);
        if((y1 > 0) && (y2 > 0) && (distance(x1, y1 - 1, u, v) <= s) && (distance(x1, y1 - 1, u, v) >= distance(x1, y1, u, v)) && (vectorField(x1, 1 - 1, x1, y1, u, v) >= 0))
            ln(x1, y1 - 1, x2, y2 - 1, u, v, s, c);
    }
}
