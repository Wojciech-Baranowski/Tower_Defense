package engine;

public class ProgramManager
{

    public ProgramManager()
    {

    }

    public void update(ProgramContainer pc, double dt)
    {
        pc.getCamera().cameraControl(pc);
        pc.getWorld().update(pc, dt);
    }

    public void render(ProgramContainer pc, Renderer r)
    {
        pc.getWorld().render(pc, r);
        //r.drawStaticText(pc, Integer.toString(pc.getFps()), 4, 0, 0XFF00FF00);
    }


    public static void main(String args[]) {
        ProgramContainer pc = new ProgramContainer(new ProgramManager());
        pc.start();
    }
}
