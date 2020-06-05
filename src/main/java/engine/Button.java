package engine;

import java.awt.event.MouseEvent;

public class Button extends Field implements Clickable
{
    protected Image img2;
    protected boolean isClicked;
    protected boolean justClicked;
    public Button(String path, double posX, double posY, int width, int height, int frame)
    {
        super(path, posX, posY, width, height, frame);
        img2 = new Image("/res/blank.png", width, height, frame);
        justClicked = false;
        isClicked = false;
    }
    public Button(String path, String path2, double posX, double posY, int width, int height, int frame) {

        super(path, posX, posY, width, height, frame);
        if(path == "")
            img = new Image("/res/blank.png", width, height, frame);
        else
        img2 = new Image(path2, width, height, frame);

    }

    /*public void click(ProgramContainer pc) {
        if ((isClicked == false) && (pc.getInput().isButtonDown(MouseEvent.BUTTON1)) && (isOnButton(pc) == true)) {
            justClicked = true;
            isClicked = true;
            imageSwap();
        } else if ((isClicked == true) && (pc.getInput().isButtonDown(MouseEvent.BUTTON1)) && (isOnButton(pc)) == true) {
            isClicked = false;
            imageSwap();
        }
        else {
            justClicked = false;
        }
    }*/

    public void click(ProgramContainer pc) {
        if ((pc.getInput().isButton(MouseEvent.BUTTON1)) && (isOnButton(pc, posX, posY, width, height) == true)) {
            if(isClicked == false)
            {
                /*if((this.getClass() == FireTower.class) || (this.getClass() == WaterTower.class) || (this.getClass() == EarthTower.class))
                    Gui.towerInfo((Tower)(this));
                if(this.getClass() == AirTower.class)
                    Gui.airTowerInfo((AirTower)(this));*/
                isClicked = true;
                justClicked = true;
            }
            else
            {
                justClicked = false;
            }
        } else if (isClicked == true) {
            isClicked = false;
        }
    }

    public Image getImg2() {
        return img2;
    }


    public boolean isJustClicked() {
        return justClicked;
    }


    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public void setJustClicked(boolean justClicked) {
        this.justClicked = justClicked;
    }
}
