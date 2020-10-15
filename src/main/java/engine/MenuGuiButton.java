package engine;

public class MenuGuiButton extends Button
{
    private int id;
    public MenuGuiButton(Image image1, Image image2, double posX, double posY, int id) {
        super(image1, image2, posX, posY);
        this.id = id;
    }
    @Override
    public void onClick(ProgramContainer pc, double posX, double posY, int width, int height)
    {
        if(isClick(pc, posX, posY, width, height))
        {
            imageSwap();
            isSecondImage = true;
            if(id == 0)
                ProgramManager.setStatePointer(ProgramManager.StatePointer.WORLD);
            else if(id == 1)
                ProgramManager.setStatePointer(ProgramManager.StatePointer.OPTIONS);
            else if(id == 2)
                ProgramManager.setStatePointer(ProgramManager.StatePointer.UPGRADEMENU);
            else if(id == 3)
                pc.stop();
        }
        else if((Input.isHold == false) && (isSecondImage == true))
        {
            imageSwap();
            isSecondImage = false;
        }
    }
}
