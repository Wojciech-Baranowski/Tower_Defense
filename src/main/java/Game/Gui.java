package Game;

import engine.ProgramContainer;
import engine.Renderer;

public class Gui
{

    public Gui()
    {

    }
    public void render(ProgramContainer pc, Renderer r)
    {
        r.drawStaticText(pc, "HP:", 16, 16, 0xFFFF01FF, 1);
    }
}

