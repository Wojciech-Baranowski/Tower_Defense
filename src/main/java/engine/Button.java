package engine;

import java.awt.event.MouseEvent;

public class Button extends Field
{
    protected Image img2;
    protected boolean isClicked;
    protected  boolean justClicked;

    public Button(String path, int posX, int posY, int width, int height, int frame) {
        super(path, posX, posY, width, height, frame);
        img2 = new Image("/res/blank.png", width, height, frame);
        isClicked = false;
        justClicked = false;
    }

    public Button(String path, String path2, int posX, int posY, int width, int height, int frame) {

        super(path, posX, posY, width, height, frame);
        img2 = new Image(path2, width, height, frame);
        isClicked = false;
    }

    protected boolean isOnButton(ProgramContainer pc) {
        if ((pc.getInput().getMouseX() >= posX) && (pc.getInput().getMouseX() <= posX + width) && (pc.getInput().getMouseY() >= posY) && (pc.getInput().getMouseY() <= posY + height))
            return true;
        return false;
    }


    public void imageSwap() {
        Image i;
        i = img;
        img = img2;
        img2 = i;
    }

    public void click(ProgramContainer pc) {
        if ((isClicked == false) && (pc.getInput().isButtonDown(MouseEvent.BUTTON1)) && (isOnButton(pc) == true)) {
            isClicked = true;
            imageSwap();
        } else if ((isClicked == true) && (pc.getInput().isButtonDown(MouseEvent.BUTTON1)) && (isOnButton(pc)) == true) {
            isClicked = false;
            imageSwap();
        }
    }

    public void holdClick(ProgramContainer pc) {
        if ((pc.getInput().isButton(MouseEvent.BUTTON1)) && (isOnButton(pc) == true)) {
            if(isClicked == false)
            {
                imageSwap();
                isClicked = true;
                justClicked = true;
            }
            else
            {
                justClicked = false;
            }
        } else if (isClicked == true) {
            isClicked = false;
            imageSwap();
        }
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public boolean isJustClicked() {
        return justClicked;
    }
}
