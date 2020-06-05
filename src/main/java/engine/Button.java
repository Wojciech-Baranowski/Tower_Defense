package engine;

import java.awt.event.MouseEvent;

public class Button extends Field implements Clickable
{
    protected Image img2;
    public Button(String path, double posX, double posY, int width, int height, int frame)
    {
        super(path, posX, posY, width, height, frame);
        img2 = new Image("/res/blank.png", width, height, frame);
    }
    public Button(String path, String path2, double posX, double posY, int width, int height, int frame) {

        super(path, posX, posY, width, height, frame);
        if(path == "")
            img = new Image("/res/blank.png", width, height, frame);
        else
        img2 = new Image(path2, width, height, frame);

    }

    @Override
    public void onClick(ProgramContainer pc, double posX, double posY, int width, int height)
    {

    }

    public Image getImg2() {
        return img2;
    }

}
/*if((this.getClass() == FireTower.class) || (this.getClass() == WaterTower.class) || (this.getClass() == EarthTower.class))
                    Gui.towerInfo((Tower)(this));
                if(this.getClass() == AirTower.class)
                    */