void main() {
    boolean[] platser = new boolean[20];
    Meny(platser);
}

static void Meny(boolean[] platser) {
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

static void Boka(boolean[] platser) {
    String platsString = IO.readln("Vilken plats ska bokas? (1-20): ");
    int platsInt = Integer.parseInt(platsString) - 1; // Fixar så det inte är sämst senare

    if (!platser[platsInt]) {
        platser[platsInt] = true;
        IO.println("Nu är plats " + (platsInt + 1) + " bokad");
    } else {
        IO.println("Den platsen är upptagen");
    }
}

static void Inehåll(boolean[] platser) {
    for (boolean plats : platser) {
        IO.print(plats + " ");
    }
}

static void Omsättning(boolean[] platser) {
    int omsättning = 0;
    for (boolean plats : platser) {
        if (plats) {
            omsättning += 300;
        }
    }

    IO.println(omsättning);
}