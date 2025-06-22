import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Scanner Objekt für User input
        Scanner sc = new Scanner(System.in);

        System.out.println("Guten Tag, heute helfen wir Ihnen die Ausrichtung des Lautsprechers im freien zu optimieren. ");


        //deklarieren der Variablen
        double spl = 0;
        int eingabe = 0;
        boolean gefunden = false;
        boolean check = false;

        // solange die Ausrichtung nicht stimmt wird es wiederholt
        while (!gefunden) {

            //check für User input ob eingabe Valide ist, angabe des Lautsprechers in dB
            while (!check) {
                try {
                    System.out.println("Geben Sie bitte den Schalldruckpegel in \"dB\" an, wenn man einen Meter entfernt steht:");
                    spl = sc.nextDouble();
                    check = true;
                } catch (InputMismatchException e) {
                    System.out.println("Keine Zahl");
                    sc.nextLine();
                }
            }
            //check für User input ob eingabe valide ist, anzahl der Werte die angegeben werden
            while (check) {
                try {
                    System.out.println("Wie viele Distanzen wollen Sie testen? ");
                    eingabe = sc.nextInt();
                    check = false;
                } catch (InputMismatchException e) {
                    System.out.println("Keine Zahl");
                    sc.nextLine();
                }
            }

            double[] polarPlotWert = new double[eingabe];

            double[] ergebnis = new double[eingabe];

            double[] werteArr = new double[eingabe];

            //check für User input ob eingabe valide ist, hier werden die werte eingelsen
            for (int i = 0; i < eingabe; i++) {
                boolean checkWerte = false;
                while (!checkWerte) {
                    try {
                        System.out.print(i+1 + ". Eingabe in Meter: ");
                        werteArr[i] = sc.nextDouble();
                        System.out.print("Bitte den Polarplotwert eingeben: -");
                        polarPlotWert[i] = sc.nextDouble();

                        ergebnis[i] = Math.round((spl + (20 * Math.log10(1.0 / werteArr[i])) - polarPlotWert[i]) * 1000.0) / 1000.0;

                        System.out.println(ergebnis[i]);
                        checkWerte =true;
                    } catch (InputMismatchException e) {
                        System.out.println("Keine Zahl");
                        sc.nextLine();
                    }
                }
            }

            // sortieren des Arrays damit berechnung durchgeführt werden kann
        for (int y = 0; y <eingabe-1; y++) {
            for (int i = 0; i < eingabe - 1; i++) {
                if (ergebnis[i] < ergebnis[i + 1]) {
                    double tmp = ergebnis[i];
                    ergebnis[i] = ergebnis[i + 1];
                    ergebnis[i + 1] = tmp;
                }
            }
        }


            System.out.println("Ihre errechneten Werte sortiert, beginnend mit dem größten");

            for (double j : ergebnis) {
                System.out.print("[" + j + "]" + " ");
            }
            // hier wird die äußerste while schleife beendet
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

