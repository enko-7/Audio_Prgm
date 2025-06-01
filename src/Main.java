import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Guten Tag, heute helfen wir Ihnen die Ausrichtung des Lautsprechers im freien zu optimieren. ");

        boolean gefunden = false;

        while (!gefunden) {

            System.out.println("Geben Sie bitte den Schalldruckpegel in \"dB\" an, wenn man einen Meter entfernt steht:");
            double spl = sc.nextDouble();

            System.out.println("Wie viele Distanzen wollen Sie testen? ");

            int eingabe = sc.nextInt();

            double[] polarPlotWert = new double[eingabe];

            double[] ergebnis = new double[eingabe];

            double[] werteArr = new double[eingabe];
            int y = 0;

            for (int i = 1; i <= eingabe; i++) {

                System.out.print(i + ". Eingabe in Meter: ");
                werteArr[y] = sc.nextDouble();
                System.out.print("Bitte den Polarplotwert eingeben: -");
                polarPlotWert[y] = sc.nextDouble();

                ergebnis[y] = Math.round((spl + (20 * Math.log10(1.0 / werteArr[y])) - polarPlotWert[y]) * 1000.0) / 1000.0;

                System.out.println(ergebnis[y]);
                ++y;
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
        System.out.println("hallo mein 2. Branch");
    }
}