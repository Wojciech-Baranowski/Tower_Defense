package engine;

public class UpgradeMenu implements State
{
    int points;
    Boolean[] unlocked;
    Button[] buttons;
    public UpgradeMenu(ProgramContainer pc)
    {
        points = 3;
        //TODO: do something with point saving
        //unlocked = JSONReader.parseJSONBooleanArray(FReader.read("data/upgrades.txt"));
    }

    public void update(ProgramContainer pc, double currentTime) {

    }

    public void render(ProgramContainer pc, Renderer r) {

    }
    private void unlock(ProgramContainer pc)
    {

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Boolean[] getUnlocked() {
        return unlocked;
    }

    public void setUnlocked(Boolean[] unlocked) {
        this.unlocked = unlocked;
    }

    public Button[] getButtons() {
        return buttons;
    }

    public void setButtons(Button[] buttons) {
        this.buttons = buttons;
    }
}
