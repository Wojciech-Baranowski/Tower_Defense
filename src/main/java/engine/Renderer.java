package engine;

import Game.Assets;

import java.awt.image.DataBufferInt;

public class Renderer
{
    private int pW, pH;
    private int[] p;
    private Font font;
    Renderer(ProgramContainer pc)
    {
        font = Assets.FONT;
        pW = pc.getWidth();
        pH = pc.getHeight();
        p = ((DataBufferInt)pc.getWindow().getImage().getRaster().getDataBuffer()).getData();
    }
    public void clear()
    {
        for(int i = 0; i < p.length; i++)
        {
            p[i] = 0xFF000000;
        }
    }

    public void setPixel(int x,int y, int value)
    {
        if((x < 0 || x >= pW || y < 0 || y>= pH) || value == 0xFFFF00FF)
        return;
        p[x + y * pW] = value;
    }
    public void drawText(ProgramContainer pc, String text, int offX, int offY, int color, int size)
    {
        int offset = 0;
        for(int i = 0; i < text.length(); i++)
        {
            int unicode = text.codePointAt(i) - 32;

            for(int y = 0; y < font.getLetters()[size / 2][unicode].getH(); y++)
            {
                for(int x = 0; x < font.getLetters()[size / 2][unicode].getW(); x++)
                {
                    if(font.getLetters()[size / 2][unicode].getP()[x + y * font.getLetters()[size / 2][unicode].getW()] == 0xFF000000)
                    {
                        setPixel(x + offX + offset + pc.getCamera().offX, y + offY, color + pc.getCamera().offY);
                    }
                }
            }
            offset += font.getLetters()[size / 2][unicode].getW();
        }
    }
    public void drawStaticText(ProgramContainer pc, String text, int offX, int offY, int color, int size)
    {
        int offset = 0;
        for(int i = 0; i < text.length(); i++)
        {
            int unicode = text.codePointAt(i) - 32;

            for(int y = 0; y < font.getLetters()[size / 2][unicode].getH(); y++)
            {
                for(int x = 0; x < font.getLetters()[size / 2][unicode].getW(); x++)
                {
                    if(font.getLetters()[size / 2][unicode].getP()[x + y * font.getLetters()[size / 2][unicode].getW()] == 0xFF000000)
                    {
                        setPixel(x + offX + offset, y + offY, color);
                    }
                }
            }
            offset += font.getLetters()[size / 2][unicode].getW();
        }
    }
    public void drawImage(ProgramContainer pc, Image image, int offX, int offY)
    {
        int newX = 0;
        int newY = 0;
        int newWidth = image.getW();
        int newHeight = image.getH();

        if(offX < -newWidth)
            return;
        if(offY < -newHeight)
            return;
        if(offX >= pW)
            return;
        if(offY >= pH)
            return;
        if(offX < 0)
            newX -= offX;
        if(offY < 0)
            newY -= offY;
        if(newWidth + offX >= pW)
            newWidth = pW - offX;
        if(newHeight + offY >= pH)
            newHeight = pH - offY;

        for(int y = newY; y < newHeight; y++)
        {
            for(int x = newX; x < newWidth; x++)
            {
                setPixel(x + offX + pc.getCamera().offX, y + offY + pc.getCamera().offY, image.getP()[x + y * image.getW()]);
            }
        }
        if(image.getFrame() != 0)
        {
            for(int y = newY; y < newHeight; y++)
            {
                setPixel(newX + offX + pc.getCamera().offX, y + offY + pc.getCamera().offY, image.getFrame());
                setPixel(newWidth - 1 + offX + pc.getCamera().offX, y + offY + pc.getCamera().offY, image.getFrame());
            }
            for(int x = newX; x < newWidth; x++)
            {
                setPixel(x + offX + pc.getCamera().offX, newY + offY + pc.getCamera().offY, image.getFrame());
                setPixel(x + offX + pc.getCamera().offX, newHeight - 1 + offY + pc.getCamera().offY, image.getFrame());
            }
            for(int y = newY + 1; y < newHeight - 1; y++)
            {
                setPixel(newX + 1 + offX + pc.getCamera().offX, y + offY + pc.getCamera().offY, image.getFrame());
                setPixel(newWidth - 2 + offX + pc.getCamera().offX, y + offY + pc.getCamera().offY, image.getFrame());
            }
            for(int x = newX + 1; x < newWidth - 1; x++)
            {
                setPixel(x + offX + pc.getCamera().offX, newY + 1 + offY + pc.getCamera().offY, image.getFrame());
                setPixel(x + offX + pc.getCamera().offX, newHeight - 2 + offY + pc.getCamera().offY, image.getFrame());
            }
        }
    }
    public void drawStaticImage(ProgramContainer pc, Image image, int offX, int offY)
    {
        int newX = 0;
        int newY = 0;
        int newWidth = image.getW();
        int newHeight = image.getH();

        if(offX < -newWidth)
            return;
        if(offY < -newHeight)
            return;
        if(offX >= pW)
            return;
        if(offY >= pH)
            return;
        if(offX < 0)
            newX -= offX;
        if(offY < 0)
            newY -= offY;
        if(newWidth + offX >= pW)
            newWidth = pW - offX;
        if(newHeight + offY >= pH)
            newHeight = pH - offY;

        for(int y = newY; y < newHeight; y++)
        {
            for(int x = newX; x < newWidth; x++)
            {
                setPixel(x + offX, y + offY, image.getP()[x + y * image.getW()]);
            }
        }
        if(image.getFrame() != 0)
        {
            for(int y = newY; y < newHeight; y++)
            {
                setPixel(newX + offX + pc.getCamera().offX, y + offY + pc.getCamera().offY, image.getFrame());
                setPixel(newWidth - 1 + offX + pc.getCamera().offX, y + offY + pc.getCamera().offY, image.getFrame());
            }
            for(int x = newX; x < newWidth; x++)
            {
                setPixel(x + offX + pc.getCamera().offX, newY + offY + pc.getCamera().offY, image.getFrame());
                setPixel(x + offX + pc.getCamera().offX, newHeight - 1 + offY + pc.getCamera().offY, image.getFrame());
            }
            for(int y = newY + 1; y < newHeight - 1; y++)
            {
                setPixel(newX + 1 + offX + pc.getCamera().offX, y + offY + pc.getCamera().offY, image.getFrame());
                setPixel(newWidth - 2 + offX + pc.getCamera().offX, y + offY + pc.getCamera().offY, image.getFrame());
            }
            for(int x = newX + 1; x < newWidth - 1; x++)
            {
                setPixel(x + offX + pc.getCamera().offX, newY + 1 + offY + pc.getCamera().offY, image.getFrame());
                setPixel(x + offX + pc.getCamera().offX, newHeight - 2 + offY + pc.getCamera().offY, image.getFrame());
            }
        }
    }
}
