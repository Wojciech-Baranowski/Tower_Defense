package engine;

public interface State
{
    void update(ProgramContainer pc, double currentTime);
    void render(ProgramContainer pc, Renderer r);
}
