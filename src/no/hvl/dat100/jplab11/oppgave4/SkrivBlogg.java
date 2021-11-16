package no.hvl.dat100.jplab11.oppgave4;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

    public static boolean skriv(Blogg samling, String mappe, String filnavn) {

        String melding = "";
        boolean skriv = false;
        PrintWriter skriver = null;

        try {

            File fil = new File(mappe + filnavn);
            skriver = new PrintWriter(fil);
             Scanner reader = new Scanner(fil);
             skriver.println(samling.getAntall());

            for (int i = 0; i < samling.getAntall(); i++) {
                skriver.print(samling.getSamling()[i].toString());
            }

            skriv = true;

        } catch (FileNotFoundException e) {
            melding = "Filen finnes ikke";

        } finally {
            if (skriver != null)
                skriver.close();
            System.out.println(melding);
        }
        return skriv;
        // throw new UnsupportedOperationException(TODO.method());
    }
}