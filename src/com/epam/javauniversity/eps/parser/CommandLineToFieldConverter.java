package com.epam.javauniversity.eps.parser;

import org.apache.commons.cli.CommandLine;

import com.epam.javauniversity.eps.input.InputData;
/**
 * Simple converter that get arguments from command line
 * and create operation
 */
public class CommandLineToFieldConverter {
    public static InputData convert(CommandLine line) {
        int width = Integer.parseInt(line.getOptionValue("width"));
        int height = Integer.parseInt(line.getOptionValue("height"));
        double probability = Double.parseDouble(line.getOptionValue("probability"));

        return new InputData(width, height, probability);
    }
}
