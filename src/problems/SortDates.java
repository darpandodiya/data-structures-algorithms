package problems;

import java.util.*;

/**
 * Given list of dates, sort them in ascending order.
 *
 * Input: 04 Nov 2030
 *        26 Dec 2061
 *        28 Jul 1963
 *
 * Output: 28 Jul 1963
 *         04 Nov 2030
 *         26 Dec 2061
 */
public class SortDates {
    public static void main(String[] args) {
        ArrayList<String> dates = new ArrayList<>();
        dates.add("04 Nov 2030");
        dates.add("26 Dec 2061");
        dates.add("28 Jul 1963");

        System.out.println(sortDates(dates));
    }

    static class Date {
        String day;
        String month;
        int year;
    }

    static final Map<String, Integer> monthMap;
    static
    {
        monthMap = new HashMap<String, Integer>();
        monthMap.put("Jan", 1);
        monthMap.put("Feb", 2);
        monthMap.put("Mar", 3);
        monthMap.put("Apr", 4);
        monthMap.put("May", 5);
        monthMap.put("Jun", 6);
        monthMap.put("Jul", 7);
        monthMap.put("Aug", 8);
        monthMap.put("Sep", 9);
        monthMap.put("Oct", 10);
        monthMap.put("Nov", 11);
        monthMap.put("Dec", 12);

    }

    private static List<String> sortDates(List<String> dates) {
        List<Date> dateList = new ArrayList<>();

        for(String date : dates) {
            String[] splitDate = date.split(" ");
            Date currentDate = new Date();
            currentDate.day = splitDate[0];
            currentDate.month = splitDate[1];
            currentDate.year = Integer.parseInt(splitDate[2]);

            dateList.add(currentDate);
        }



        Collections.sort(dateList, new Comparator() {

            public int compare(Object o1, Object o2) {

                Integer x1 = ((Date) o1).year;
                Integer x2 = ((Date) o2).year;
                int sComp = x1.compareTo(x2);

                if (sComp != 0) {
                    return sComp;
                }

                x1 = monthMap.get(((Date) o1).month);
                x2 = monthMap.get(((Date) o2).month);

                sComp = x1.compareTo(x2);

                if (sComp != 0) {
                    return sComp;
                }

                String xs1 = ((Date) o1).day;
                String xs2 = ((Date) o2).day;

                return xs1.compareTo(xs2);
            }});

        List<String> sortedDates = new ArrayList<>();

        for(Date date : dateList) {
            sortedDates.add(date.day + " " + date.month + " " + date.year);
        }

        return sortedDates;
    }

}

