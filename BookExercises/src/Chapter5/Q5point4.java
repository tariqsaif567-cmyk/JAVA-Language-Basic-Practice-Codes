package Chapter5;

public class Q5point4 {

    public static void main(String[] args) {
        // a)
        int i = 1;
        while (i <= 10) {
            ++i;
        }

//b)
        for (double k = 0.1; k <= 1.0; k += 0.1) {
            System.out.printf("%.1f%n", k);

        }
//c)
        int n = (int) (Math.random() * 10);
        switch (n) {
            case 1:
                System.out.println("The number is 1");
                break;
            case 2:
                System.out.println("The number is 2");
                break;
            default:
                System.out.println("The number is not 1 or 2");
                break;
        }
// d)The following code should print the values 1 to 10:
        int N = 0;

        while (N < 10) {
            System.out.println(++N);
        }
        //or
        int m = 1;

        while (m <= 10) {
            System.out.println(m++);

        }

    }

}
