void main() {
    long[] platser = new long[20];
    boolean running = true;
    while (running) {
        Meny(platser, running);
    }
}

static void Meny(long[] platser, boolean running) {
    IO.println("\n1. Lägg till en bokning\n2. Visa platser\n3. Visa omsättning\n4. Avboka en plats\n5. Söka efter en plat\n6. Avluta");
    String val = IO.readln("Vad vill du göra? (1-4): ");
    IO.println();

    switch (val) {
        case "1" -> Boka(platser);
        case "2" -> Inehåll(platser);
        case "3" -> Omsättning(platser);
        case "4" -> Avboka(platser);
        case "5" -> Sök(platser);
        case "6" -> running = false;
        default -> IO.println("du är korkad");
    }
}

static void Boka(long[] platser) {
    boolean fel = true;
    while(fel){
        int platsInt = (int)StringTillLong("Vilken plats ska bokas? (1-20): ") - 1;
        if (platsInt > 0 && platsInt < 21){ 
            fel = false;
        }
    }

    if (platser[platsInt] == 0) {
        long personNr = Perosnummer("Skriv in ditt personnummer");
        platser[platsInt] = personNr;
        IO.println("Nu är plats " + (platsInt + 1) + " bokad");
    } else {
        IO.println("Den platsen är upptagen");
    }
}

static void Inehåll(long[] platser) {
    for (int i = 0; i < platser.length; i++) {
        if (platser[i] == 0) {
            IO.print("Ledig" + Fönster(i + 1));
        } else {
            IO.print("Bokad" + Fönster(i + 1));
        }
    }
    IO.println();
}

static String Fönster(int index){
    if (index % 4 == 0 || index % 4 == 1){
        return "(fönsterplats), ";
    }
    return ", ";
}

static void Omsättning(long[] platser) {
    int omsättning = 0;
    for (long plats : platser) {
        if (plats != 0) {
            omsättning += 300;
        }
    }
    IO.println("Du har omsatt: " + omsättning + "kr");
}

static long Perosnummer(String prompt) {
    boolean fel = true;
    long pNum = 0;
    while (fel) {
        pNum = StringTillLong(prompt + " (ÅÅÅÅMMDDXXXX): ");
        if (pNum > 100000000000L && pNum < 999999999999L) {
            fel = false;
        } else {
            IO.println("Det där är inte ett gilltigt format");
        }
    }
    return pNum;
}

static long StringTillLong(String prompt) {
    boolean fel = true;
    long ut = 0L;

    while (fel) {
        String in = IO.readln(prompt);
        try {
            ut = Long.parseLong(in);
            fel = false;
        } catch (Exception e) {
            IO.println("Ogiltigt tal");
        }
    }

    return ut;
}

static void Avboka(long[] platser) {
    boolean fel = true;
    while (fel) {
        int plats = (int)StringTillLong("Vilken plats vill du avboka? (1-20): ");
        if (plats >= 1 && plats <= 20) {
            platser[plats - 1] = 0L;
            fel = false;
        }
    }
}

static void Sök(long[] platser) {
    long personNr = Perosnummer("Sök efter perosnnummer");

    for (int i = 0; i < platser.length; i++) {
        if (platser[i] == personNr) {
            IO.println("Den personen har bokat plats nr: " + (i + 1));
            break;
        }
        else if (i == 19){
            IO.println("Den personen har ingen bokad plats.");
        }
    }

}