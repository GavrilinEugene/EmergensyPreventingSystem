package com.epam.javauniversity.eps.parser;

import org.apache.commons.cli.*;

/**
 * cmd format options parser
 */
public class InputParametersParser  {

    Options options;

    public CommandLine parse(String args[]) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        CommandLine line = parser.parse(options, args);
        return line;
    }

    public InputParametersParser() {
        options = new Options();

        Option leftOperand = Option.builder("w")
                .required(true)
                .longOpt("width")
                .hasArg()
                .desc("field width")
                .build();

        Option rightOperand = Option.builder("h")
                .required(true)
                .longOpt("height")
                .hasArg()
                .desc("field height")
                .build();

        Option operation = Option.builder("p")
                .required(true)
                .longOpt("probability")
                .hasArg()
                .desc("element probability:\n" +
                        "floating value in range[0,1]\n")
                .build();

        options.addOption(leftOperand);
        options.addOption(rightOperand);
        options.addOption(operation);
    }
}
