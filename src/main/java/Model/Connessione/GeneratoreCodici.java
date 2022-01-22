package Model.Connessione;
import java.util.Random;

public class GeneratoreCodici {
        // array delle lettere
        private String[] Caratteri = { "a", "b", "c", "d", "e", "f", "g", "h", "i",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "z", "y",
                "j", "k", "x", "w", "A", "B", "C", "D", "E", "F", "G", "H", "I",
                "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "Z", "Y",
                "J", "K", "X", "W", "à", "è", "é", "ì", "ò", "ù" };

        // array dei numeri
        private String[] Numeri = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };

        // array dei caratteri speciali
        private String[] Speciali = { "!", "£", "$", "%", "&", "@", "*", ",", "_",
                "-", "#", ";", "^", "\\" , "/", ":", ".", "+", "§", "?", "ç" };

        // creo l'oggetto random
        private Random rand = new Random();

        public String GeneraCodice(int numeroCaratteriRandom, boolean conSpeciali,
                                   boolean conTimestamp, String separatore) {

            // ottengo la lunghezza di ogni array
            int lunghezzaCaratteri = Caratteri.length;
            int lunghezzaNumeri = Numeri.length;
            int lunghezzaSpeciali = Speciali.length;

            // istanzio la variabile che conterrà il prodotto finale
            String stringaRandom = "";

            while (stringaRandom.length() < numeroCaratteriRandom) {

                // ottengo un elemento casuale per ogni array
                int c = rand.nextInt(lunghezzaCaratteri);
                int n = rand.nextInt(lunghezzaNumeri);
                int s = rand.nextInt(lunghezzaSpeciali);

                // aggiungo una lettera casuale
                stringaRandom += Caratteri[c];
                // aggiungo un numero random
                stringaRandom += Numeri[n];
                // se l'opzione conSpeciali è true aggiungo un carattere speciale
                if (conSpeciali) {
                    stringaRandom += Speciali[s];
                }
            }

            // se la stringa generata dovesse superare il numero di caratteri
            // richiesto, la taglio.
            if (stringaRandom.length() > numeroCaratteriRandom) {
                stringaRandom = stringaRandom.substring(0, numeroCaratteriRandom);
            }

            // se abbiamo deciso di mettere il timestamp
            if (conTimestamp) {
                // recupero il timestamp
                long timestamp = System.currentTimeMillis();
                stringaRandom += separatore + timestamp;
            }

            // restituisco la stringa generata
            return stringaRandom;
        }

        // metodo main come esempio
        public static void main(String[] args) {

            // creo un oggetto GeneraCodiceRandom e lo chiamo codice
            GeneratoreCodici codice = new GeneratoreCodici();

            // creo 10 stringhe random come esempio
            for (int i = 1; i <= 10; i++) {
                /*
                 * parametri: numeroCaratteriRandom = il numero di caratteri random
                 * da generare; conSpeciali = true/flase per specificare se vogliamo
                 * includere dei caratteri speciali; conTimestamp = true/false per
                 * specificare se vogliamo includere un timestamp; separatore = un
                 * carattere da utilizzare per dividere la stringa random dal
                 * timestamp. Se non si vuole utilizzare nessun separatore basta
                 * impostarlo uguale ad una stringa vuota = ""
                 */

                /*
                 * Ad ogni ciclo del "for", richiamo il metodo GeneraCodice
                 * dell'oggetto "codice", e gli passo il numerico progressivo di
                 * caratteri random da generare.
                 */
                String generato = codice.GeneraCodice(i, true, true, "||");
                // output della stringa appena creata.
                System.out.println("[" + i + "]\t" + generato);
            }
        }
    }

