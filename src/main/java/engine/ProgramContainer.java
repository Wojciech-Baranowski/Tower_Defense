package engine;

public class ProgramContainer implements Runnable
{
    private Thread thread;
    private Window window;
    private Renderer renderer;
    private Input input;
    private Camera camera;
    private ProgramManager program;
    private World world;
    private Menu menu;
    private UpgradeMenu upgradeMenu;
    private Options options;

    private int fps;

    private boolean running = false;
    private final  double UPDATE_CAP = 1.0 / 60.0;
    private int width = 1024, height = 576;
    private double time = 0;
    private double passedTime = 0;
    private float scale = 1.2f;
    private  String title = "title";

    public ProgramContainer(ProgramManager program)
    {
        this.program = program;
    }
    public void start(){
        window = new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);
        camera = new Camera();
        thread = new Thread(this);
        world = new World(this);
        menu = new Menu(this);
        upgradeMenu = new UpgradeMenu(this);
        options = new Options(this);
        thread.run();
    }
    public void stop()
    {
        running = false;
    }
    public void run()
    {
        running = true;
        boolean render;
        double firstTime;
        time = System.nanoTime() / 1000000000.0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double unprocessedTime = 0;
        double frameTime = 0;
        int frames = 0;
        double absoluteTime = System.nanoTime() / 1000000000.0;
        fps = 0;
        while(running)
        {
            render = false;
            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;
            unprocessedTime += passedTime;
            frameTime += passedTime;

            while(unprocessedTime >= UPDATE_CAP)
            {
                unprocessedTime -= UPDATE_CAP;
                render = true;
                time = System.nanoTime() / 1000000000.0 - absoluteTime;
                program.update(this, time);
                input.update();
                if(frameTime >= 1.0)
                {
                    time++;
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                }
            }
            if(render)
            {
                renderer.clear();
                program.render(this, renderer);
                window.update();
                frames++;
            }
            else
            {
                try
                {
                    Thread.sleep(1);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
        dispose();
    }

    private void dispose()
    {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getScale() {
        return scale;
    }

    public String getTitle() {
        return title;
    }

    public Window getWindow() {
        return window;
    }

    public Input getInput() {
        return input;
    }

    public Camera getCamera() {
        return camera;
    }

    public World getWorld() {
        return world;
    }

    public Menu getMenu() {
        return menu;
    }

    public UpgradeMenu getUpgradeMenu() {
        return upgradeMenu;
    }

    public Options getOptions() {
        return options;
    }
}
