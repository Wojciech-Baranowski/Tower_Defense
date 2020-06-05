package engine;

import java.awt.event.MouseEvent;

public class Button extends Field implements Clickable
{
    private Image img2;
    private boolean isSecondImage;
    public Button(String path, double posX, double posY, int width, int height, int frame)
    {
        super(path, posX, posY, width, height, frame);
        this.isSecondImage = false;
        img2 = new Image("/res/blank.png", width, height, frame);
    }
    public Button(String path, String path2, double posX, double posY, int width, int height, int frame) {

        super(path, posX, posY, width, height, frame);
        this.isSecondImage = false;
        if(path2 == "")
            img2 = new Image("/res/blank.png", width, height, frame);
        else
        img2 = new Image(path2, width, height, frame);
    }
    private void imageSwap()
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

    public Image getImg2() {
        return img2;
    }

}