package com.epam.javauniversity.eps.parser;
import org.apache.commons.cli.*;

import org.junit.Test;


public class InputParametersParserTest {
    @Test(expected = MissingArgumentException.class)
    public void parseMissingArgument() throws ParseException {
        String args[] = {"-l", "-w", "7", "-p", "0.8"};
        InputParametersParser parser = new InputParametersParser();
        parser.parse(args);
    }

    @Test(expected = MissingOptionException.class)
    public void parseMissingOption() throws ParseException {
        String args[] = {"3", "-w", "1", "-op", "0.8"};
        InputParametersParser parser = new InputParametersParser();
        parser.parse(args);
    }

}