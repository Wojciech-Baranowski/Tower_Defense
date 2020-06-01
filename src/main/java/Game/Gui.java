package Game;

import engine.*;

public class Gui
{
    Field background;
    Button nextWave;
    public Gui()
    {
        background = new Field("/res/gui.png", 0, 0, 1024, 576, 1);
        nextWave = new Button("/res/guiButton.png", "/res/guiButtonClicked.png", 912, 200, 96, 48, 1);
    }
    public void update(ProgramContainer pc, Level level, double passedTime)
    {
        nextWave.holdClick(pc);
        if(nextWave.isJustClicked() == true)
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
    public void render(ProgramContainer pc, Renderer r, Stats stats, Level level, double passedTime)
    {
        r.drawStaticImage(pc, background.getImg(), background.getPosX(), background.getPosY());
        r.drawStaticText(pc, "HP: " + stats.getHp(), 912, 16, 0xFF000000, 3);
        r.drawStaticText(pc, "F: " + stats.getFire(), 912, 48, 0xFF000000, 3);
        r.drawStaticText(pc, "A: " + stats.getAir(), 912, 80, 0xFF000000, 3);
        r.drawStaticText(pc, "W: " + stats.getWater(), 912, 112, 0xFF000000, 3);
        r.drawStaticText(pc, "E: " + stats.getEarth(), 912, 144, 0xFF000000, 3);
        r.drawStaticText(pc, "Wave: " + (level.getCurrentWave() + 1) + "/" + level.getWavesAmount(), 912, 176, 0xFF000000, 4);
        r.drawStaticImage(pc, nextWave.getImg(), nextWave.getPosX(), nextWave.getPosY());
        r.drawStaticText(pc, "Next wave in:", 914, 204, 0xFF000000, 5);
        if(level.getCurrentWave() >= 0)
        {
            if((level.getCurrentWave() + 1 < level.getWavesAmount()) && (level.getWaveDelay()[level.getCurrentWave()] - passedTime + level.getWaves()[level.getCurrentWave()].getTimeStamp() >= 0))
            {
                r.drawStaticText(pc, "" + (double)((int)((level.getWaveDelay()[level.getCurrentWave()] - passedTime + level.getWaves()[level.getCurrentWave()].getTimeStamp()) * 10)) / (double)(10), 940, 224, 0xFF000000, 4);
            }
            else
            {
                r.drawStaticText(pc, "OO", 940, 224, 0xFF000000, 4);

            }
        }
    }
}

