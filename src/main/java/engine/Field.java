package engine;

import engine.Image;

public class Field
{
    protected int posX;
    protected int posY;
    protected int width;
    protected int height;
    protected Image img;
    public Field(int posX, int posY, int width, int height, int frame)
    {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        img = new Image("/res/defaultField.png", width, height, frame);
    }
    public Field(Image image, int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;
        img = image;
    }
    public Field(String path, int posX, int posY, int width, int height, int frame)
    {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        if(path == "")
            img = new Image("/res/blank.png", width, height, frame);
        else
        img = new Image(path, width, height, frame);
    }
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Image getImg() {
        return img;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
