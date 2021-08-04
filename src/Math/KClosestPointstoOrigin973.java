package Math;

public class KClosestPointstoOrigin973 {
    class Node{
        int[]arr;
        double val;

        public Node(int[] arr, double val) {
            this.arr = arr;
            this.val = val;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][];
        Node[]nodes=new Node[points.length];
        for(int i=0;i<nodes.length;i++){
            nodes[i]=new Node(points[i], Math.pow(points[i][0],2)+Math.pow(points[i][1],2));
        }

        return res;
    }
}
