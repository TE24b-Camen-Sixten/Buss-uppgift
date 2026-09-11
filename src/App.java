void main(){
    Boolean[] platser = new Boolean[20];
    Meny(platser);
}

static void Meny(Boolean[] platser){
    IO.println("1. Lägg till en bokning\n2. Visa platser\n3. Visa omsättning\n4. Avsluta");
    String val = IO.readln("Vad vill du göra (1-4): ");
    
    int tras;
    switch (val) {
        case "1" -> Boka(platser);
        case "2" -> Inehåll(platser);
        case "3" -> Omsättning();
        case "4" -> tras = 1 / 0;
        default -> IO.println("du är korkad");
    }
}

static void Boka(Boolean[] platser){
    String platsString = IO.readln("Vilken plats ska bokas? ");
}
static void Inehåll(Boolean[] platser){
    for (Boolean plats : platser) {
        IO.print(plats + " ");
    }
}
static void Omsättning(){}