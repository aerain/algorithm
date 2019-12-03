package codewars.java;

public class RectangleRotation {
    public static int rectangleRotation(final int a, final int b) {
        double sqrt = Math.sqrt(2);
        int maxWidthPoint = (int) (a / sqrt) + 1;
        int maxHeightPoint = (int) (b / sqrt) + 1;
        return ((int) (a / sqrt) % 2) == 0 && ((int) (b / sqrt) % 2) == 0 || ((int) (a / sqrt) % 2) == 0 && ((int) (b / sqrt) % 2) == 1
                ? maxWidthPoint * maxHeightPoint + (maxWidthPoint - 1) * (maxHeightPoint - 1)
                : maxWidthPoint * (maxHeightPoint - 1) + (maxWidthPoint - 1) * maxHeightPoint;
//        if(((int) (a / sqrt) % 2) == 0 && ((int) (b / sqrt) % 2) == 0 || ((int) (a / sqrt) % 2) == 0 && ((int) (b / sqrt) % 2) == 1) {
//            return maxWidthPoint * maxHeightPoint + (maxWidthPoint - 1) * (maxHeightPoint - 1);
//        } else {
//            return maxWidthPoint * (maxHeightPoint - 1) + (maxWidthPoint - 1) * maxHeightPoint;
//        }
//        } else {
//            if(((int) (b / sqrt) % 2) == 0) {
//                return maxWidthPoint * (maxHeightPoint - 1) + (maxWidthPoint - 1) * maxHeightPoint;
//            } else {
//                return maxWidthPoint * maxHeightPoint + (maxWidthPoint - 1) * (maxHeightPoint - 1);
//            }
//        }
    }
}
