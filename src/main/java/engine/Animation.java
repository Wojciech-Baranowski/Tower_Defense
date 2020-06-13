package engine;

public class Animation
{
    public static final Animation ANIMA1 = new Animation("/res/anima1.png",6, 64, 64, 3);
    private Image[] images;
    private double frameGap;
    public Animation(String path, double frameGap, int width, int height, int count)
    {
        Image temp = new Image(path, width * count, height, 0);
        images = new Image[count];
        for(int i = 0; i < count; i++)
        {
            images[i] = new Image("/res/blank.png", width, height, 0);
            for(int j = 0; j < height; j++)
            {
                for(int k = 0; k < width; k++)
                {
                    images[i].getP()[width * j + k] = temp.getP()[width * count * j + k + width * i];
                }
            }
        }
        this.frameGap = frameGap;
    }
    public Image animate()
    {
        return images[1];
    }
    public Image update(Image image, long tickCount)
    {
        if((tickCount % frameGap == 0) && (tickCount > 0))
        {
            for(int i = 1; i < images.length - 1; i++)
            {
                if(image == images[i])
                {
                    return images[i + 1];
                }
            }
            return images[0];
        }
        return image;
    }
}
