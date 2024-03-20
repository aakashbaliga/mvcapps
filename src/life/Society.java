package life;
import CALab.*;

import java.util.HashSet;
import java.util.Set;

public class Society extends Grid {
    public static Set<Integer> rebirth = new HashSet<Integer>();
    public static Set<Integer> death = new HashSet<Integer>();
    public static int percentAlive = 50;

    @Override
    public Agent makeCell(boolean uniform) {
        if (uniform) {
            Agent agent = new Agent();
            return agent;
        }
        return null;
    }
}
