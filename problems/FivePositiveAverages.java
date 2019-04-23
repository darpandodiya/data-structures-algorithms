package problems;

import java.util.*;

public class FivePositiveAverages {

    public static List<List<Double>> fiveAverages(List<List<Double>> data) {
        HashMap<Integer, PriorityQueue<Double>> productHeapMap = new HashMap<>();

        for(List<Double> element : data) {
            Integer productId = element.get(0).intValue();

            if(!productHeapMap.containsKey(productId)) {
                PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
                pq.add(element.get(1));
                productHeapMap.put(productId, pq);
            }
            else {
                productHeapMap.get(productId).add(element.get(1));
            }
        }

        List<List<Double>> result = new ArrayList<>();

        for(Integer product : productHeapMap.keySet()) {

            List<Double> productResult = new ArrayList<>();
            Double sum = 0.0;
            PriorityQueue<Double> pq = productHeapMap.get(product);
            for(int i = 0; i < 2; i++) {
                sum = sum + pq.poll();
            }

            productResult.add(new Double(product));
            productResult.add(sum/2);
            result.add(productResult);
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Double>> data = new ArrayList<>();
        List<Double> idata = new ArrayList<>();
        idata.add(1.0);
        idata.add(10.0);
        data.add(idata);

        idata = new ArrayList<>();
        idata.add(1.0);
        idata.add(4.0);
        data.add(idata);

        idata = new ArrayList<>();
        idata.add(2.0);
        idata.add(10.0);
        data.add(idata);

        idata = new ArrayList<>();
        idata.add(2.0);
        idata.add(9.0);
        data.add(idata);

        System.out.println(fiveAverages(data));
    }
}
