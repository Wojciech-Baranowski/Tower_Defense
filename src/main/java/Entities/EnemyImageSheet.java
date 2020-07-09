package Entities;

import engine.Animation;
import engine.Image;

public class EnemyImageSheet
{
    private Image[][] img;
    private Animation[] anima;
    public EnemyImageSheet(String path, int size)
    {
        Image image = new Image(path, 4 * size, 4 * size, 0);
        img = new Image[4][4];
        anima = new Animation[4];
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                img[j][i] = new Image(size, size, 0);
                for(int k = 0; k < size; k++)
                {
                    for(int l = 0; l < size; l++)
                    {
                        img[j][i].getP()[k + l * size] = image.getP()[k + i * size + l * size * 4 + j * size * size * 4];
                    }
                }
            }
        }
        for(int i = 0; i < 4; i++)
        {
            anima[i] = new Animation(img[i], 6, 32, 4);
        }
    }

    public Image[][] getImg() {
        return img;
    }

    public Animation[] getAnima() {
        return anima;
    }
}
