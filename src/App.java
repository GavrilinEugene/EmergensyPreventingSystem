import com.epam.javauniversity.eps.input.InputData;
import com.epam.javauniversity.eps.locator.EmergencyLocator;
import com.epam.javauniversity.eps.parser.*;
import com.epam.javauniversity.eps.range.Range;
import com.epam.javauniversity.eps.reporter.EmergencyReporter;
import com.epam.javauniversity.eps.riskgroup.RiskGroup;
import com.epam.javauniversity.eps.sector.Sector;
import com.epam.javauniversity.eps.sector.source.SectorSource;
import com.epam.javauniversity.eps.sector.source.RandomSectorFiller;
import org.apache.commons.cli.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
/**
 * Main task
 */
public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        InputParametersParser parser = new InputParametersParser();
        try {
            CommandLine commandLine = parser.parse(args);
            InputData input = CommandLineToFieldConverter.convert(commandLine);
            SectorSource areaSource = new RandomSectorFiller(input.getWidth(), input.getHeight(), input.getFieldFactor());
            Sector sector = areaSource.getSector();
            List<RiskGroup> possibleRiskGroup = getPossibleRiskGroup();
            EmergencyLocator locator = new EmergencyLocator(possibleRiskGroup);
            Map<RiskGroup, Integer> emergencies = locator.search(sector);
            EmergencyReporter reporter = new EmergencyReporter();
            System.out.println(reporter.createReporter(sector, emergencies, input.getFieldFactor(), possibleRiskGroup));
        } catch (ParseException e) {

        }

    }

    // mooove
    private static List<RiskGroup> getPossibleRiskGroup() {
        return Arrays.asList(new RiskGroup("NONE", new Range(1, 2)), new RiskGroup("MINOR", new Range(3, 4)),
                new RiskGroup("NORMAL", new Range(5, 7)), new RiskGroup("MAJOR", new Range(8, 13)),
                new RiskGroup("CRITICAL", new Range(14)));
    }
}
