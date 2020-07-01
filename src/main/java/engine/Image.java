package engine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;

public class Image
{
    private int w, h;
    private int[] p;
    private int[] r;
    private int frame;
    public Image(String path, int width, int height, int frame)
    {
        BufferedImage image = null;
        this.frame = frame;
        try
        {
            image = ImageIO.read(Image.class.getResourceAsStream((path)));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        w = image.getWidth();
        h = image.getHeight();
        p = image.getRGB(0, 0, w, h, null, 0, w);
        rescale(width, height);
        image.flush();
    }
    public Image(int width, int height, int frame)
    {
        this.frame = frame;
        w = width;
        h = height;
        p = new int[width * height];
    }

    public void rescale(int nWidth, int nHeight)
    {
        int[] r = new int[p.length];
        for(int i = 0; i < p.length; i++)
        {
            r[i] = p[i];
        }
        p = new int[nWidth * nHeight];
        double sw = ((double)(nWidth) / (double)(w));
        double sh = ((double)(nHeight) / (double)(h));
        for(int j = 0; j < nHeight; j++)
        {
            for(int i = 0; i < nWidth; i++)
            {
                p[i + j * nWidth] = r[(int)((double)(i) / (double)(sw)) + (int)((double)(j) / (double)(sh)) * w];
            }
        }
        w = nWidth;
        h = nHeight;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public int[] getP() {
        return p;
    }

    public int getFrame() {
        return frame;
    }
}
