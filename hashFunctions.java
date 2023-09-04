// Samuel Subra

import java.util.Scanner;

public class hashFunctions
{
    public static void main(String[] args)
    {
        // SET UP
        int option = 0;
        int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299, 5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412, 5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589, 5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871, 5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};
        int[][] Table = new int[2][50];
        Scanner s1 = new Scanner(System.in);

        // MAIN MENU LOOP
        do
        {
            // Reset Hash Table
            for (int i = 0; i < keys.length; i++)
            {
                Table[0][i] = 0;
                Table[1][i] = 0;
            }

            // Main Menu
            System.out.println();
            System.out.println("-----MAIN MENU--------------------------------------");
            System.out.println("1. Run HF1 (Division method with Linear Probing)");
            System.out.println("2. Run HF2 (Division method with Quadratic Probing)");
            System.out.println("3. Run HF3 (Division method with Double Hashing)");
            System.out.println("4. Run HF4 (Student Designed HF)");
            System.out.println("5. Exit program");
            System.out.println();
            System.out.print("Enter option number: ");
            option = s1.nextInt();
            s1.nextLine();
            System.out.println();

            switch (option)
            {
                // 1 LINEAR PROBING
                case 1:
                    HF1(Table, keys);
                    sumProbes(Table, keys);
                    break;

                // 2 QUADRATIC PROBING
                case 2:
                    HF2(Table, keys);
                    sumProbes(Table, keys);
                    break;

                // 3 DOUBLE HASHING
                case 3:
                    HF3();
                    break;

                // 4 STUDENT DESIGNED
                case 4:
                    HF4();
                    break;

                // 5 EXIT
                case 5:
                    break;

                // EXCEPTIONS
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } while (option != 5);
    }

    // METHODS

    // HF1 LINEAR PROBING
    public static void HF1(int[][] t, int[] k)
    {
        int m = k.length;
        for (int x : k)
        {
            if (t[0][x % m] == 0)
            {
                t[0][x % m] = x;
            }
            else
            {
                int current = x % m;
                do
                {
                    t[1][x % m] = t[1][x % m] + 1; // increment probes
                    current++; // Linear Probing
                    current = current % m;
                } while (t[0][current] != 0);
                t[0][current] = x;
            }
        }
    }

    // HF2 QUADRATIC PROBING
    public static void HF2(int[][] t, int[] k)
    {
        int m = k.length;
        for (int x : k)
        {
            if (t[0][x % m] == 0)
            {
                t[0][x % m] = x;
            }
            else
            {
                int current = x % m;
                int i = 1;
                do
                {
                    t[1][x % m] = t[1][x % m] + 1; // increment probes
                    current = current + i*i; // Quadratic Probing
                    current = current % m;
                    i++;
                } while (t[0][current] != 0);
                t[0][current] = x;
            }
        }
    }

    // HF3 DOUBLE HASHING
    public static void HF3()
    {

    }

    // HF4 STUDENT DESIGNED
    public static void HF4()
    {

    }

    public static void sumProbes(int[][] t, int[] k)
    {
        int probes = 0;
        int m = k.length;
        for (int i = 0; i < m; i++)
        {
            probes = probes + t[1][i];
        }
        System.out.println("Index   Key    Probes");
        System.out.println("------------------------");
        int j = 0;
        for (int x : k)
        {
            System.out.println("  " + j + "     " + k[j] + "     " + t[1][j]);
            j++;
        }
        System.out.println("------------------------");
        System.out.println();
        System.out.println("Sum of probe values = " + probes + " probes.");
    }
}