package lifeLab;

import CALab.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Society extends Grid {
    public static int percentAlive = 50;
    public static Set<Integer> rebirth = new HashSet<Integer>(Arrays.asList(3));
    public static Set<Integer> death = new HashSet<Integer>(Arrays.asList(0, 1, 4, 5, 6, 7, 8));
    @Override
    public Cell makeCell(boolean uniform) {
        return new Agent(this, uniform);
    }

}
