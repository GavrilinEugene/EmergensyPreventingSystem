import org.apache.commons.cli.*;

import com.epam.javauniversity.eps.field.Field;
import com.epam.javauniversity.eps.parser.*;
/**
 * Main task
 */
public class App {
    public static void main(String args[]) {
        FieldParametersParser parser = new FieldParametersParser();
        try {
            CommandLine commandLine = parser.parse(args);
            Field field = CommandLineToFieldConverter.convert(commandLine);
        } catch (ParseException e) {

        }
    }
}
