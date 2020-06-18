package engine;

import Game.Assets;

public class Button extends Field implements Clickable
{
    protected Image img2;
    protected boolean isSecondImage;
    public Button(String path, double posX, double posY, int width, int height, int frame)
    {
        super(path, posX, posY, width, height, frame);
        this.isSecondImage = false;
        img2 = Assets.BLANK;
    }
    public Button(Image image, double posX, double posY)
    {
        super(image, posX, posY);
        this.isSecondImage = false;
        img2 = Assets.BLANK;
    }
    public Button(String path, String path2, double posX, double posY, int width, int height, int frame) {

        super(path, posX, posY, width, height, frame);
        this.isSecondImage = false;
        if(path2 == "")
            img2 = Assets.BLANK;
        else
        img2 = new Image(path2, width, height, frame);
    }
    public Button(Image image1, Image image2, double posX, double posY)
    {

        super(image1, posX, posY);
        this.isSecondImage = false;
        img2 = image2;
    }
    protected void imageSwap()
    {
        Image i;
        i = img;
        img = img2;
        img2 = i;
    }

    @Override
    public void onClick(ProgramContainer pc, double posX, double posY, int width, int height)
    {
        if(isClick(pc, posX, posY, width, height))
        {
            imageSwap();
            isSecondImage = true;
        }
        else if((Input.isHold == false) && (isSecondImage == true))
        {
            imageSwap();
            isSecondImage = false;
        }
    }
}