import static java.lang.Math.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Oppgave 1
        int lonn = 670000;
        double trinn = O1.calculateTrinnSkatt(lonn);
        System.out.println(String.format("Du må betale %.0f skatt", trinn));
        //////////////////////


        //Oppgave 2
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        System.out.println("Trykk q for å avslutte løkken. ");
        while (i < 10) {
            System.out.print("Poeng input: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            int poeng;
            try {
                poeng = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ugyldig input.");
                continue;
            }
            char karakter;
            try {
                karakter = O2.getGrade(poeng);
                System.out.println("Karakter: " + karakter);
            } catch (IllegalArgumentException e) {
                System.out.println("Feil: " + e.getMessage());
                i--;
            }

            i++;
        }


        //Oppgave 3
        System.out.println("q to exit.");
        while (true) {
            System.out.println("Fakultet input: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            int fakultetTall;
            try {
                fakultetTall = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ugyldig input.");
                continue;
            }
            try {
                int fakultet = O3.factorial(fakultetTall);
                System.out.println(fakultet);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }

    }
}

class O1 {

    static double calculateTrinnSkatt(int lonn) {
        if (lonn <= 292850 && lonn >= 208051) {
            return 0.017 * lonn;
        } else if (lonn <= 670000 && lonn >= 292851) {
            return 0.04 * lonn;
        } else if (lonn <= 937900 && lonn >= 670001) {
            return 0.136 * lonn;
        } else if (lonn <= 1350000 && lonn >= 937901) {
            return 0.166 * lonn;
        } else if (lonn >= 1350001) {
            return 0.176 * lonn;
        }
        return 0;
    }
}


class O2 {
    private static boolean between(int upperBound, int lowerBound, int number) {
        return number <= upperBound && number >= lowerBound;
    }

    static char getGrade(int points) {
        if (between(100, 90, points)) return 'A';
        else if (between(89, 80, points)) return 'B';
        else if (between(79, 60, points)) return 'C';
        else if (between(59, 50, points)) return 'D';
        else if (between(49, 40, points)) return 'E';
        else if (between(39, 0, points)) return 'F';
        else throw new IllegalArgumentException("Ugyldig poengsum.");
    }

}

class O3 {
    static int factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Kun positive heltall for fakultet.");
        }

        int product = 1;
        while (n > 0) {
            product *= n;
            n--;
        }
        return product;


    }
}
