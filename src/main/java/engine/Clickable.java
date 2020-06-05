package engine;

import java.awt.event.MouseEvent;

public interface Clickable
{
    default boolean inBorder(ProgramContainer pc, double posX, double posY, int width, int height)
    {
        if((pc.getInput().getMouseX() >= posX) && (pc.getInput().getMouseX() <= posX + width) && (pc.getInput().getMouseY() >= posY) && (pc.getInput().getMouseY() <= posY + height))
            return true;
        return false;
    }
    default boolean isClick(ProgramContainer pc, double posX, double posY, int width, int height)
    {
        if((pc.getInput().isButton(MouseEvent.BUTTON1)) && inBorder(pc, posX, posY, width, height))
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
