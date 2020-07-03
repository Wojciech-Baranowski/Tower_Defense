package Game.gui;
import Game.Level;
import engine.Button;
import engine.Image;
import engine.Input;
import engine.ProgramContainer;

public class NextWaveButton extends Button
{

    public NextWaveButton(Image image1, Image image2, double posX, double posY) {
        super(image1, image2, posX, posY);
    }
    public void onClick(ProgramContainer pc, double posX, double posY, int width, int height, Level level, double passedTime)
    {
        if((inBorder(pc, posX, posY, width, height)) && (isSecondImage == false) && (level.getWavesAmount() != level.getCurrentWave() + 1))
        {
            imageSwap();
            isSecondImage = true;
        }
        else if((inBorder(pc, posX, posY, width, height) == false) && (isSecondImage == true))
        {
            imageSwap();
            isSecondImage = false;
        }
        if(isClick(pc, posX, posY, width, height))
        {
            if(level.getWaves()[0].isRunning() == false)
            {
                level.getWaves()[0].setRunning(true);
                level.getWaves()[0].setTimeStamp(passedTime);
                level.setCurrentWave(0);
            }
            else if(level.getCurrentWave() + 1 < level.getWavesAmount())
            {
                level.getWaveDelay()[level.getCurrentWave()] = 0;
            }
        }
    }
}
