package projeto.support;

import java.util.Random;

public class UserUtils {

    private static final String[] FIRST_NAMES = {
            "Leandro", "Marcos", "Ana", "Carla", "João", "Maria", "Lucas", "Fernanda"
    };

    private static final String[] LAST_NAMES = {
            "Silva", "Souza", "Oliveira", "Pereira", "Costa", "Santos", "Rodrigues", "Almeida"
    };

    private static final String[] EMAIL_DOMAINS = {
            "example.com", "test.com", "mail.com", "empresa.com"
    };

    private static final Random RANDOM = new Random();

    /**
     * Gera um ID aleatório apenas com números.
     * @param length quantidade de dígitos desejada
     * @return string numérica aleatória
     */
    public static String randomNumericId(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(RANDOM.nextInt(10)); // dígito de 0 a 9
        }
        return sb.toString();
    }

    /**
     * Gera um primeiro nome aleatório.
     */
    public static String firstName() {
        return FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
    }

    /**
     * Gera um sobrenome aleatório.
     */
    public static String lastName() {
        return LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
    }

    /**
     * Gera um username aleatório.
     */
    public static String username() {
        return "user" + RANDOM.nextInt(10000);
    }

    /**
     * Gera um email aleatório.
     */
    public static String email() {
        String fn = firstName().toLowerCase();
        String ln = lastName().toLowerCase();
        String domain = EMAIL_DOMAINS[RANDOM.nextInt(EMAIL_DOMAINS.length)];
        return fn + "." + ln + RANDOM.nextInt(1000) + "@" + domain;
    }

    /**
     * Gera uma senha aleatória simples.
     */
    public static String password() {
        return "Pass@" + RANDOM.nextInt(100000);
    }

    /**
     * Gera um telefone aleatório no formato brasileiro.
     */
    public static String phone() {
        int ddd = 11 + RANDOM.nextInt(89); // gera DDD entre 11 e 99
        int prefix = 90000 + RANDOM.nextInt(9999);
        int suffix = 1000 + RANDOM.nextInt(8999);
        return "(" + ddd + ") " + prefix + "-" + suffix;
    }
}