package Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Implementazione Design Pattern Singleton
 *
 * Questo design pattern viene utilizzato per poter inserire le immagini dei videogiochi e delle recensioni
 *
 * Questo è un metodo chiamato una tantum
 *
 * Questo tipo di design pattern rientra nei pattern creazionali in quanto fornisce
 * uno dei modi migliori per creare un oggetto.
 * Questo pattern coinvolge una singola classe che è responsabile della creazione dell’ oggetto, assicurandosi
 * che venga creata una ed una sola istanza. Questa classe fornisce un modo per accedere al suo unico oggetto
 * a cui è possibile accedere direttamente senza che sia necessario creare un’istanza dell’oggetto della classe.
 */

public class Singleton {

    private static String SAVE_DIR = "img";

    private static Singleton instance = new Singleton();

    /** Rendiamo il costruttore privato, in questo modo la classe non può essere instanziata*/
    private Singleton() {
    }

    /** Ritorna l'unico oggetto creato*/
    public static Singleton getInstance(String operazione ,String path, String titolo, HttpServletRequest request) throws IOException, ServletException {
        inserisciImmagine(operazione, path, titolo, request);
        return instance;
    }

    private static void inserisciImmagine(String operazione, String path, String titolo, HttpServletRequest request) throws IOException, ServletException {

        if(operazione.equals("Videogioco")){
            String appPath = path;
            Path pathX = FileSystems.getDefault().getPath("/");
            String savePath = appPath + SAVE_DIR + pathX;
            File fileSaveDir = new File(savePath + titolo);
            if (!fileSaveDir.exists()) {/**Se la cartella non esiste la si crea*/
                fileSaveDir.mkdir();
            }
            for (Part part : request.getParts()) {/**Si prende l'immagine dalla richiesta*/
                String fileName = titolo + "-1.jpg";/**Si prende il path dell'immagine*/
                String car = titolo;
                if (fileName != null && !fileName.equals("")) {
                    part.write(savePath + car + File.separator + fileName);/**si inserisce la foto nella cartella temporanea*/
                }
            }
        }else{
            String appPath = path;
            Path pathX= FileSystems.getDefault().getPath("/");
            String savePath = appPath + SAVE_DIR + pathX;
            File fileSaveDir = new File(savePath + titolo);
            if (!fileSaveDir.exists()) {/**Se la cartella non esiste la si crea*/
                fileSaveDir.mkdir();
            }
            int i=2;
            for (Part part : request.getParts()) {/**Si prende l'immagine dalla richiesta*/
                String fileName = titolo + "-"+i+".jpg";/**Si prende il path dell'immagine*/
                String car=titolo;
                if (fileName != null && !fileName.equals("")) {
                    part.write(savePath + car + File.separator + fileName);/**si inserisce la foto nella cartella temporanea*/
                }
                i++;
            }
        }
    }
}