package com.epam.javauniversity.eps.reporter;

import com.epam.javauniversity.eps.riskgroup.RiskGroup;
import com.epam.javauniversity.eps.sector.Sector;
import com.epam.javauniversity.eps.sector.cell.CellState;

import java.util.List;
import java.util.Map;

public class EmergencyReporter {
    public String createReporter(Sector sector, Map<RiskGroup, Integer> emergencies, Double fieldFactor, List<RiskGroup> possibleRiskGroup) {
        StringBuilder reporter = new StringBuilder();
        reporter.append(createTitle());
        reporter.append(fillSplitter());
        reporter.append(fillInputParam(sector.getWidth(), sector.getHeight(), fieldFactor, possibleRiskGroup));
        reporter.append(fillSplitter());
        reporter.append(createSector(sector));
        reporter.append(fillSplitter());
        reporter.append(createEmergencies(emergencies, possibleRiskGroup));
        return reporter.toString();
    }

    private String createEmergencies(Map<RiskGroup, Integer> emergencies, List<RiskGroup> possibleRiskGroup) {
        StringBuilder emergenciesReporter = new StringBuilder();
        emergenciesReporter.append("Risk groups report: \n");
        for (RiskGroup group: possibleRiskGroup) {
            if (emergencies.containsKey(group)) {
                emergenciesReporter.append(group.getName() + ": " + emergencies.get(group) + " groups;\n");
            } else {
                emergenciesReporter.append(group.getName() + ": 0 groups;\n");
            }
        }
        return  emergenciesReporter.toString();
    }

    private String createSector(Sector sector) {
        StringBuilder sectorReporter = new StringBuilder();
        sectorReporter.append(createSectorColumnName(sector.getHeight()));
        StringBuilder rowName = new StringBuilder();
        for (int row = 0; row < sector.getWidth(); row++) {
            rowName.append(" " + row + " ");
            for (int column = 0; column < sector.getHeight(); column++) {
                 rowName.append(sector.getCellState(row, column).toString());
            }
            rowName.append("\n");
        }
        sectorReporter.append(rowName.toString());
        return sectorReporter.toString();
    }

    private String createSectorColumnName(int height) {
        StringBuilder columnName = new StringBuilder();
        columnName.append("   ");
        for (int column = 0; column < height; column++) {
            columnName.append(" " + column + " ");
        }
        columnName.append("\n");
        return columnName.toString();
    }

    private String fillInputParam(int width, int height, Double fieldFactor, List<RiskGroup> possibleRiskGroup) {
        return "Width: " + width + "\n" +
               "Height: " + height + "\n" +
               "Field factor: " + fieldFactor + "\n" +
               "Possible risk groups: " + "\n" + createPossibleRiskGroup(possibleRiskGroup);
    }

    private String createPossibleRiskGroup(List<RiskGroup> possibleRiskGroup) {
        StringBuilder possibleGroups = new StringBuilder();
        for (RiskGroup group: possibleRiskGroup) {
            possibleGroups.append(group.getName() + " :[" + group.getRange().getFrom() + ", " + group.getRange().getTo() + "]\n");
        }
        return possibleGroups.toString();
    }

    private String fillSplitter() {
        return "--------------------------------------------------------------\n";
    }

    private String createTitle() {
        return "EMERGENCY PREVENTION SYSTEM\n" +
                "--------------------------------------------------------------\n";
    }
}
