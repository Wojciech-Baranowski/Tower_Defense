package engine;

public interface Clickable
{
    default boolean isOnButton(ProgramContainer pc, double posX, double posY, int width, int height) {
        if ((pc.getInput().getMouseX() >= posX) && (pc.getInput().getMouseX() <= posX + width) && (pc.getInput().getMouseY() >= posY) && (pc.getInput().getMouseY() <= posY + height))
            return true;
        return false;
    }
}
