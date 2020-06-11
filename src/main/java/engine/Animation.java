package engine;

public class Animation
{
    private Image[] images;
    private Image original;
    private double cycleTime;
    private double timeStamp;
    private int count;
    private boolean going = true;
    public Animation(Image[] images, Image original, double cycleTime)
    {
        this.images = images;
        this.original = original;
        this.cycleTime = cycleTime / images.length;
        this.count = 0;
        this.timeStamp = 0;
    }
    public Image animate(double passedTime)
    {

    }
}
