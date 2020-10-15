package engine;

import Game.Assets;

import java.awt.event.KeyEvent;

public class ProgramManager
{
    public enum StatePointer {WORLD, MENU, UPGRADEMENU, OPTIONS}
    private static StatePointer statePointer;
    private static Image background;
    public ProgramManager()
    {

    }

    public void update(ProgramContainer pc, double dt)
    {
        if((pc.getInput().isKeyDown(KeyEvent.VK_ESCAPE)) && (statePointer == StatePointer.MENU))
            statePointer = StatePointer.WORLD;
        else if((pc.getInput().isKeyDown(KeyEvent.VK_ESCAPE)) && (statePointer != StatePointer.MENU))
            statePointer = StatePointer.MENU;
        if(statePointer == StatePointer.WORLD)
        {
            pc.getWorld().update(pc, dt);
        }
        else if(statePointer == StatePointer.MENU)
        {
            pc.getMenu().update(pc, dt);
        }
        else if(statePointer == StatePointer.UPGRADEMENU)
        {
            pc.getUpgradeMenu().update(pc, dt);
        }
        else if(statePointer == StatePointer.OPTIONS)
        {
            pc.getOptions().update(pc, dt);
        }
        //pc.getCamera().cameraControl(pc);
    }

    public void render(ProgramContainer pc, Renderer r)
    {
        r.drawStaticImage(pc, background, 0, 0);
        if(statePointer == StatePointer.WORLD)
        {
            pc.getWorld().render(pc, r);
        }
        else if(statePointer == StatePointer.UPGRADEMENU)
        {
            pc.getUpgradeMenu().render(pc, r);
        }
        else if(statePointer == StatePointer.OPTIONS)
        {
            pc.getOptions().render(pc, r);
        }
        else if(statePointer == StatePointer.MENU)
        {
            pc.getMenu().render(pc, r);
        }
        Input.isHolding(pc);
        //r.drawStaticText(pc, Integer.toString(pc.getFps()), 4, 0, 0XFF00FF00);
    }


    public static void main(String args[]) {
        ProgramContainer pc = new ProgramContainer(new ProgramManager());
        ProgramManager.statePointer = StatePointer.MENU;
        background = Assets.BACKGROUND;
        pc.start();
    }

    public static StatePointer getStatePointer() {
        return statePointer;
    }

    public static void setStatePointer(StatePointer statePointer) {
        ProgramManager.statePointer = statePointer;
    }
}
