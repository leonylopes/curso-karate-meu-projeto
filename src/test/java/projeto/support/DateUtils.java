package projeto.support;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class DateUtils {

    /**
     * Gera um ID aleatório (UUID).
     */
    public static String randomId() {
        return UUID.randomUUID().toString();
    }

    /**
     * Retorna a data atual formatada conforme o padrão informado.
     * Exemplo de padrão: "yyyy-MM-dd HH:mm:ss"
     */
    public static String formattedDate(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date());
    }

    /**
     * Retorna o timestamp atual em milissegundos.
     */
    public static long currentTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * Retorna o timestamp atual em segundos.
     */
    public static long currentTimestampSeconds() {
        return System.currentTimeMillis() / 1000;
    }
}
