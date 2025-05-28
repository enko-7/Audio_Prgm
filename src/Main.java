import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Guten Tag, heute helfen wir ihnen die Ausrichtung des Lautsprechers im freien zu optimieren\n " +
                "Geben Sie bitte den Schalldruckpegel in \"db\" an wenn man einen Meter entfernt steht");

        int spl = sc.nextInt();

        System.out.println("Wie viele Distanzen wollen sie testen? ");

        int eingabe = sc.nextInt();

        int polarPlotWert = 0;

        double ergebnis = 0;

        int[] werteArr = new int[eingabe];

        for (int i = 1; i <= eingabe; i++) {
            int y = 0;

            System.out.print(i + ". Eingabe: ");
            werteArr[y] = sc.nextInt();

            ergebnis = Math.round(((spl + (20 * Math.log10(1.0 / werteArr[y])) - 3) / 100.0) * 100);
            ++y;
            System.out.println(ergebnis);
        }


    }


}