package engine;

public class ProgramManager extends AbstractProgram
{

    private Image testImage;

    public ProgramManager()
    {
        testImage = new Image("/res/dobe.png", 600, 600, 0);
    }

    public void update(ProgramContainer pc, double dt)
    {
        pc.getCamera().cameraControl(pc);
        pc.getWorld().update(pc, dt);
    }

    @Override
    public void render(ProgramContainer pc, Renderer r)
    {
       //r.drawImage(pc, testImage, 0, 0);
        pc.getWorld().render(pc, r);
        //r.drawStaticText(pc, Integer.toString(pc.getFps()), 4, 0, 0XFF00FF00);
    }


    public static void main(String args[])
    {
        ProgramContainer pc = new ProgramContainer(new ProgramManager());
        pc.start();
    }
}
