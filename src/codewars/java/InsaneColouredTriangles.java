package codewars.java;

public class InsaneColouredTriangles {
    public static char triangle(final String row) {
        // Return the answer
        char[] temp = row.toCharArray();
        for(int t = 1; t < temp.length; t++) {
            for(int i = 0; i < temp.length - t; i++)
                temp[i] = temp[i] == 'B' && temp[i + 1] == 'G' || temp[i] == 'G' && temp[i + 1] == 'B'
                                ? 'R'
                        : temp[i] == 'R' && temp[i + 1] == 'G' || temp[i] == 'G' && temp[i + 1] == 'R'
                                ? 'B'
                        : temp[i] == 'B' && temp[i + 1] == 'R' || temp[i] == 'R' && temp[i + 1] == 'B'
                                ? 'G'
                                : temp[i];
        }
        return temp[0];
    }
}
