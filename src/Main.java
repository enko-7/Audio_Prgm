import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Guten Tag, heute helfen wir ihnen die Ausrichtung des Lautsprechers im freien zu optimieren\n " +
                "Geben Sie bitte den Schalldruckpegel in \"db\" an");

        int spl = sc.nextInt();

        System.out.println("Wie viele Distanzen wollen sie testen? ");

        int eingabe = sc.nextInt();

        int werte = 0;

        for (int i = 1; i <= eingabe; i++) {
            System.out.print(i + ". Eingabe: ");
            werte = sc.nextInt();
        }

        double ergebnis = spl + (20 * Math.log10(1.0 / 10)) - 3;

        System.out.println(ergebnis);
    }


}