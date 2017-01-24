package com.epam.javauniversity.eps.parser;

import org.apache.commons.cli.CommandLine;

import com.epam.javauniversity.eps.field.Field;
/**
 * Simple converter that get arguments from command line
 * and create operation
 */
public class CommandLineToFieldConverter {
    public static Field convert(CommandLine line) {
        int width = Integer.parseInt(line.getOptionValue("width"));
        int height = Integer.parseInt(line.getOptionValue("height"));
        double probability = Double.parseDouble(line.getOptionValue("probability"));

        return new Field(width, height, probability);
    }
}
