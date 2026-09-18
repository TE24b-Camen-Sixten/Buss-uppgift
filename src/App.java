void main() {
    long[] platser = new long[20];
    while (true){
        Meny(platser);
    }
}

static void Meny(long[] platser) {
    IO.println("1. Lägg till en bokning\n2. Visa platser\n3. Visa omsättning\n4. Avsluta");
    String val = IO.readln("Vad vill du göra? (1-4): ");
    IO.println();

    int tras;
    switch (val) {
        case "1" -> Boka(platser);
        case "2" -> Inehåll(platser);
        case "3" -> Omsättning(platser);
        case "4" -> tras = 1 / 0;
        default -> IO.println("du är korkad");
    }
}

static void Boka(long[] platser) {
    String platsString = IO.readln("Vilken plats ska bokas? (1-20): ");
    int platsInt = Integer.parseInt(platsString) - 1; // Fixar så det inte är sämst senare

    if (platser[platsInt] == 0) {
        platser[platsInt] = 1;
        long personNr = Perosnummer();
        IO.println("Nu är plats " + (platsInt + 1) + " bokad");
    } else {
        IO.println("Den platsen är upptagen");
    }
}

static void Inehåll(long[] platser) {
    for (long plats : platser) {
        IO.print(plats + " ");
    }
    IO.println();
}

static void Omsättning(long[] platser) {
    int omsättning = 0;
    for (long plats : platser) {
        if (plats != 0) {
            omsättning += 300;
        }
    }
    IO.println(omsättning);
}

static long Perosnummer(){
    boolean fel = true;
    long pNum = 0;
    while (fel){
        pNum = StringToLong("Skriv in ditt perosnummer (ÅÅÅÅMMDDXXXX): ");
        float pNumCheck = (pNum / 1000000000000L);
        if (pNum > 100000000000L && pNum < 999999999999L){
            fel = false;
        }
        else{
            IO.println("Det där är inte ett gilltigt format");
        }
    }
    return pNum;
}

static long StringToLong(String prompt){
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