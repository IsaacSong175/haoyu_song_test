
public class isOverlap {
    public static boolean isOverlapUtil(double x1,double x2,double x3,double x4){
        if((x2<x1)||(x4<x3)){
            throw new IllegalArgumentException("End point should be larger than start point!");
        }
        return Math.max(x1,x3)<=Math.min(x2,x4);
    }

    public static void main(String[] args) {
        try {
            System.out.println(isOverlapUtil(1,2,3,4));
            System.out.println(isOverlapUtil(1,5,2,6));
            System.out.println(isOverlapUtil(1,5,6,8));
            System.out.println(isOverlapUtil(1,2,4,4));
            System.out.println(isOverlapUtil(2,2,1,4));
            System.out.println(isOverlapUtil(2,2.2,1,4.9));
            System.out.println(isOverlapUtil(5,2,3,4));
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }
}

