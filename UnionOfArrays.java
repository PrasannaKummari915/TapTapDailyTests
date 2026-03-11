package TapTapDailyCallenge;

import java.util.*;

public class UnionOfArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        int n = sc.nextInt();
        int m = sc.nextInt();

        
        Set<Integer> unionSet = new HashSet<>();

      
        for (int i = 0; i < n; i++) {
            unionSet.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            unionSet.add(sc.nextInt());
        }

    
        System.out.println(unionSet.size());

        sc.close();
    }
}