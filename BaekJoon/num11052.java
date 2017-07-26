import java.util.*;

public class num11052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,j,n = sc.nextInt();
        // n개를 팔았을때의 이운 저장배열 d[]
        int d[] = new int[n+1], p[] = new int[n+1];
        for(i=1; i<=n; i++) p[i] = sc.nextInt();
        d[0] = 0;
        for(i=1; i<=n; i++) {
            d[i] = 0;
            for(j=1; j<=i; j++) 
                d[i] = Max(d[i],d[i-j]+p[j]);
        }
        System.out.println(d[n]);
        sc.close();
        }
    public static int Max(int a, int b) { return a >b? a:b;}
    
}