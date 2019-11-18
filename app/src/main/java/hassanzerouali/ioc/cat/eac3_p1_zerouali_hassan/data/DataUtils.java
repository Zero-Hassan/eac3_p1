package hassanzerouali.ioc.cat.eac3_p1_zerouali_hassan.data;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {

    // An ArrayList of Songs
    public static final List<Recept> RECEPT_ITEMS = new ArrayList<>();
    // The ID for the index into song titles.
    public static final String RECEPT_ID_KEY = "item_id";

    // The number of songs.
    private static final int COUNT = 3;

    /**
     * A Song item represents a song title, and song details.
     */
    public static class Recept {
        public final String recept_title;
        public final String details;

        private Recept(String content, String details) {
            this.recept_title= content;
            this.details = details;
        }
    }

    /**
     * Add an item to the array.
     *
     * @param item Each song
     */
    private static void addItem(Recept item) {
        RECEPT_ITEMS.add(item);
    }

    static {
        // Fill the array with songs.
        for (int i = 0; i < COUNT; i++) {
            addItem(createReceptAtPosition(i));
        }
    }

    /**
     * Manually creates each song title and song detail.
     *
     * @param position Position of the song in the list.
     * @return
     */
    private static Recept createReceptAtPosition(int position) {
        String newTitle;
        String newDetail;
        switch (position) {
            case 0:
                newTitle = "Pastel de atún con pan de molde";
                newDetail = "1 tomate grande\n" +
                        "250 gramos de atún en conserva\n" +
                        "100 gramos de aceitunas negras sin hueso\n" +
                        "50 gramos de maíz dulce\n" +
                        "300 gramos de mahonesa\n" +
                        "9 rodajas de pan de molde\n" +
                        "sal\n" +
                        "pimienta negra molida\n" +
                        "aceite de oliva\n" +
                        "mahonesa (para decorar)";
                break;
            case 1:
                newTitle = "Caracoles en salsa vizcaína";
                newDetail = "" +
                        "Ingredientes\n" +
                        "320 gramos de caracoles cocidos (peso escurrido)\n" +
                        "200 gramos de jamón serrano\n" +
                        "50 gramos de chorizo\n" +
                        "cebollino para decorar\n" +
                        "aceite de oliva\n" +
                        "sal\n" +
                        "Para la salsa vizcaína:\n" +
                        "2 cebollas blancas\n" +
                        "40 gramos de pulpa de pimiento choricero\n" +
                        "1 tomate\n" +
                        "1 pimiento verde\n" +
                        "aceite de oliva\n" +
                        "sal\n" +
                        "300 mililitros de agua" +
                        "" +
                        "";
                break;
            case 2:
                newTitle = "Almendras garrapiñadas";
                newDetail = "Pon una sartén la fuego y añade el agua y el azúcar. Cocina a fuego suve y cuando empiece a espesarse, añade las almendras. Sin dejar de remover, cocina hasta que se evapore el agua y el azúcar obtenga una textura arenosa. Sube el fuego y sigue cocinando sin dejar de remover hasta que el azúcar se caramelice.\n" +
                        "\n" +
                        "Retira del fuego y esparce las almendras garrafiñadas sobre papel de horno. Sepáralas para que no se peguen entre sí y deja templar a temperatura ambiente. Antes de que se enfríen por completo, vuelve a separarlas con las manos, ya que una vez se endurece el caramelo es más dificil despegarlas.\n" +
                        "\n" +
                        "Sirve las almendras garrapiñadas.";
                break;
            default:
                newTitle = "";
                newDetail = ".";
                break;
        }
        return new Recept(newTitle, newDetail);
    }
}
