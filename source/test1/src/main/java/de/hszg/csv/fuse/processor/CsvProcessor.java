package de.hszg.csv.fuse.processor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import au.com.bytecode.opencsv.CSVReader;

public class CsvProcessor implements Processor {
	@Override
	public void process(Exchange exchange) throws Exception {
		try (InputStream input = getClass().getResourceAsStream(
				"testData/handler2/searchRespone1.csv");
				BufferedReader bReader = new BufferedReader(
						new InputStreamReader(input));
				CSVReader reader = new CSVReader(bReader)) {
			
		}

	}
}
