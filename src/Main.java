import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Guten Tag, heute helfen wir Ihnen die Ausrichtung des Lautsprechers im freien zu optimieren. ");

        double spl = 0;
        int eingabe = 0;
        boolean gefunden = false;
        boolean check = false;

        while (!gefunden) {
            while (!check) {
                try {
                    System.out.println("Geben Sie bitte den Schalldruckpegel in \"dB\" an, wenn man einen Meter entfernt steht:");
                    spl = sc.nextDouble();
                    check = true;
                } catch (InputMismatchException e) {
                    System.out.println("Keine Zahl");
                    sc.next();
                }
            }

            while (check) {
                try {
                    System.out.println("Wie viele Distanzen wollen Sie testen? ");
                    eingabe = sc.nextInt();
                    check = false;
                } catch (InputMismatchException e) {
                    System.out.println("Keine Zahl");
                    sc.next();
                }
            }

            double[] polarPlotWert = new double[eingabe];

            double[] ergebnis = new double[eingabe];

            double[] werteArr = new double[eingabe];
            //int y = 0;

            for (int i = 0; i < eingabe; i++) {
                while (polarPlotWert[polarPlotWert.length-1] == 0) {
                    try {
                        System.out.print(i+1 + ". Eingabe in Meter: ");
                        werteArr[i] = sc.nextDouble();
                        System.out.print("Bitte den Polarplotwert eingeben: -");
                        polarPlotWert[i] = sc.nextDouble();

                        ergebnis[i] = Math.round((spl + (20 * Math.log10(1.0 / werteArr[i])) - polarPlotWert[i]) * 1000.0) / 1000.0;

                        System.out.println(ergebnis[i]);
                        ++i;
                    } catch (InputMismatchException e) {
                        System.out.println("Keine Zahl");
                        sc.next();
                    }
                }
            }

            for (int i = 0; i < eingabe - 1; i++) {
                if (ergebnis[i] < ergebnis[i + 1]) {
                    double tmp = ergebnis[i];
                    ergebnis[i] = ergebnis[i + 1];
                    ergebnis[i + 1] = tmp;
                }
            }


            System.out.println("Ihre errechneten Werte sortiert, beginnend mit dem größten");

            for (double j : ergebnis) {
                System.out.print("[" + j + "]" + " ");
            }

            if ((ergebnis[0] - ergebnis[ergebnis.length - 1]) <= 6) {
                gefunden = true;
                System.out.println("\nIhre Werte liegen im vorgeschlagen Bereich von 6 dB! \n" +
                        "Viel Spaß mit Ihrem Soundsystem.");
            } else {
                System.out.println("Ihre Werte liegen nicht im vorgeschlagen Bereich von 6 dB! \n" +
                        "Bitte probieren Sie neue Messwerte aus.");
            }
        }
    }
}

