package lifeLab;

import CALab.Cell;
import CALab.Grid;

import java.util.HashSet;
import java.util.Set;

public class Society extends Grid {
    public static int percentAlive = 50;
    public static Set<Integer> rebirth = new HashSet<Integer>();
    public static Set<Integer> death = new HashSet<Integer>();
    @Override
    public Cell makeCell(boolean uniform) {
        return new Agent(this, uniform);
    }

}
