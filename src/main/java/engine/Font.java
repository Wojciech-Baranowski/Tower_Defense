package engine;

public class Font
{
    public static final Font F25 = new Font("/res/font.png", 1184, 23);
    public static final Font F20 = new Font("/res/font2.png", 954, 18);
    public static final Font F15 = new Font("/res/font3.png", 688, 13);
    public static final Font FB25 = new Font("/res/fontB.png", 1500, 25);
    public static final Font FB20 = new Font("/res/font2B.png", 1000, 17);
    public static final Font FB15 = new Font("/res/font3B.png", 1000, 15);

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
