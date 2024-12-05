package utilities;

import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class RegexPattern {

    //Déclaration de la regex pour le format du code postal
    public static final Pattern PATTERN_CODE_POSTAL = Pattern.compile("\\d{5}$");

    //Déclaration de la regex pour le format du tétéphone
    public static final Pattern PATTERN_TELEPHONE = Pattern.compile("(^\\+33|0)[1-9]\\d{8}$");

    // Déclaration de la regex pour le format de l'email
    public static final Pattern PATTERN_EMAIL = Pattern.compile("(^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    // Déclarartion de la regex pour le format date jj/mm/aaaa
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
}
