package problems;

import java.util.ArrayList;

public class HighestAverageNode {

    class ComponentNode {
        public int value;
        public ArrayList<ComponentNode> components;

        public ComponentNode() {
            components = new ArrayList<>();
        }

        public ComponentNode(int tenure) {
            this.value = tenure;
            this.components = new ArrayList<>();
        }
    }


    class ReturnResult {
        int childNodeCount;
        int sumOfChildVals;

        public ReturnResult() {
        }

        public ReturnResult(int childNodeCount, int sumOfChildVals) {
            this.childNodeCount = childNodeCount;
            this.sumOfChildVals = sumOfChildVals;
        }
    }


    double maxAverage = 0;

    ReturnResult traverse(ComponentNode node) {

        if(node.components == null || node.components.size() == 0) {
            return new ReturnResult(1, node.value);
        }

        ReturnResult combinedResult = new ReturnResult();

        for(ComponentNode childNode : node.components) {
            ReturnResult childResult = traverse(childNode);
            combinedResult.sumOfChildVals += childResult.sumOfChildVals;
            combinedResult.childNodeCount += childResult.childNodeCount;
        }

        combinedResult.childNodeCount++;
        combinedResult.sumOfChildVals += node.value;

        if((combinedResult.sumOfChildVals / combinedResult.childNodeCount) > maxAverage) {
            maxAverage = combinedResult.sumOfChildVals / combinedResult.childNodeCount;
        }

        return combinedResult;
    }

    public static void main(String[] args) {
//        ComponentNode rootNode = new ComponentNode(1);
//        rootNode.components.add(new ComponentNode(2));
//        rootNode.components.add(new ComponentNode(3));
//
//        rootNode.components.get(0).components.add(new ComponentNode(4));
//        rootNode.components.get(0).components.add(new ComponentNode(5));
//        rootNode.components.get(0).components.add(new ComponentNode(6));
//
//        ReturnResult result = traverse(rootNode);
        //System.out.println(result.sumOfChildVals + "/" + result.childNodeCount);
    }

}
