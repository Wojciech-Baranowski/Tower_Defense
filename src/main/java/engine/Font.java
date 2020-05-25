package engine;

public class Font
{
    public static final Font F23 = new Font("/res/font.png", 1184, 23);
    public static final Font F18 = new Font("/res/font3.png", 954, 18);
    public static final Font F13 = new Font("/res/font2.png", 688, 13);


    private Image fontImage;
    private int[] offsets;
    private int[] widths;

    public Font(String path, int width, int height)
    {
        fontImage = new Image(path, width, height, 0);
        offsets = new int[96];
        widths = new int[96];

        int unicode = 0;

        for(int i = 0; i < fontImage.getW(); i++)
        {
            if(fontImage.getP()[i] == 0xFF0000FF)
            {
                offsets[unicode] = i;
            }
            if(fontImage.getP()[i] == 0xFFFFFF00)
            {
                widths[unicode] = i - offsets[unicode] + 1;
                unicode++;
            }
        }
    }

    public Image getFontImage() {
        return fontImage;
    }

    public int[] getOffsets() {
        return offsets;
    }

    public int[] getWidths() {
        return widths;
    }
}
