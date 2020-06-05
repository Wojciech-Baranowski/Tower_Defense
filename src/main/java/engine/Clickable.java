package engine;

import java.awt.event.MouseEvent;

public interface Clickable
{
    default boolean isClick(ProgramContainer pc, double posX, double posY, int width, int height)
    {
        if((pc.getInput().isButton(MouseEvent.BUTTON1)) && (pc.getInput().getMouseX() >= posX) && (pc.getInput().getMouseX() <= posX + width) && (pc.getInput().getMouseY() >= posY) && (pc.getInput().getMouseY() <= posY + height))
        {
            if(Input.isHold == false)
            {
                Input.justClicked = true;
                return true;
            }
            else
                {
                    Input.justClicked = false;
                    return false;
                }
        }
        return false;
    }
    void onClick(ProgramContainer pc, double posX, double posY, int width, int height);
}
