package engine;

import Game.Assets;

public class Menu implements State
{
    private Field gui;
    private Button[] guiButton;
    public Menu(ProgramContainer pc)
    {
        gui = new Field(Assets.MENUGUI, 336, 144);
        guiButton = new Button[4];
        for(int i = 0 ; i < 4; i++)
        {
            guiButton[i] = new Button(Assets.MENUGUIBUTTON, Assets.MENUGUIBUTTONCKICKED, 368, 174 + i * 58);
        }
    }

    public void update(ProgramContainer pc, double currentTime)
    {
        for(int i = 0; i < 4; i++)
        {
            guiButton[i].onClick(pc, guiButton[i].getPosX(), guiButton[i].getPosY(), 288, 48);
        }
    }

    public void render(ProgramContainer pc, Renderer r) {
        r.drawStaticImage(pc, gui.getImg(), (int)gui.getPosX(), (int)gui.getPosY());
        for(int i = 0; i < 4; i++)
        {
            r.drawStaticImage(pc, guiButton[i].getImg(), (int)guiButton[i].getPosX(), (int)guiButton[i].getPosY());
        }
        r.drawStaticText(pc, "RETURN", 425, 176, 0xFF2f2f2f, 48);
        r.drawStaticText(pc, "OPTIONS", 410, 234, 0xFF2f2f2f, 48);
        r.drawStaticText(pc, "UPGRADES", 400, 292, 0xFF2f2f2f, 48);
        r.drawStaticText(pc, "SAVE & EXIT", 366, 352, 0xFF2f2f2f, 48);
    }
}
