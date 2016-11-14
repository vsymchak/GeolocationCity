import org.apache.commons.lang3.StringUtils;

/**
 * Created by Admin on 13.11.2016.
 */
public class Translit{

    private String town;

    public Translit(String town) {
        town = UkrToEngTranlit(town);
        this.town = NoSpaces(town);
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }


    //перетворимо в латиницю міста
    private String UkrToEngTranlit (String text) {

        String[] abcCyr = {"a", "б", "в", "г", "д", "е", "є", "ж", "з",  "и", "і", "ї", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц",  "ч", "ш", "щ",    "ь",  "ю", "я"};
        String[] abcLat = {"a", "b", "v", "g", "d", "e", "e", "zh", "z", "i", "i", "i", "i", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "h", "ts", "ch", "sh", "sch", "", "ju", "ja"};

        return StringUtils.replaceEach(text, abcCyr, abcLat);
    }


    //замінимо в назвах міст пропуски
    private String NoSpaces(String text) {

        return text.replace(' ', '_');
    }

}
