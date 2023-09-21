import java.util.Scanner;

public class lr2{
    public static void main(String[] args){
        System.out.println("\nTask #1");
        spruce();        
        System.out.println("\nTask #2");
        array();
    }

    public static void spruce(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the heigh: ");
        int height = in.nextInt();
        int j,z,i;
        for (i = 1; i <= height; i++)
        {
            for (j = 0; j < height-i; j++)
                System.out.print(" ");
            for (z = 0; z < i*2-1; z++)
                System.out.print("*");
            System.out.println("");
        }
    }

    public static void array(){
        Scanner in = new Scanner(System.in);
        System.out.print("Array[][]\na=");
        int a = in.nextInt();
        System.out.print("\nArray["+a+"][]\nb=");
        int b = in.nextInt();
        System.out.print("\nArray["+a+"]["+b+"]\n\n");
        int[][] arr = new int[a][b];

        System.out.println("Enter start number: ");
        int start = in.nextInt();
        arr[0][0]=start;
        System.out.println();

        int i,j, tmp=start-3;
        for(i=0; i<a; i++){
            for(j=0; j<b; j++){
                tmp +=3;
                arr[i][j]=tmp;
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }

    
}