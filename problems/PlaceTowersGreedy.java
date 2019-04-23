package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaceTowersGreedy {

    private static List<Integer> placeTowers(int[] houses, int range) {
        if(houses.length == 0) {
            return null;
        }

        Arrays.sort(houses);
        ArrayList<Integer> towers = new ArrayList<>();

        int tower = houses[0] + range;
        towers.add(tower);

        for(int index = 1; index < houses.length; index++) {
            if(Math.abs(tower - houses[index]) > range) {
                tower = houses[index] + range;
                towers.add(tower);
            }
        }

        return towers;
    }

    public static void main(String[] args) {
        System.out.println(placeTowers(new int[]{1, 6, 7, 10}, 4));
    }
}
