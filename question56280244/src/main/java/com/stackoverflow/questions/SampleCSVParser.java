package com.stackoverflow.questions;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SampleCSVParser {
    public List<Map<String, String>> parse(Path csvPath) throws IOException {
        Reader in = new FileReader(csvPath.toFile());

        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreEmptyLines(true)
                .withDelimiter(',')
                .withTrim()
                .parse(in);


        return StreamSupport
                        .stream(records.spliterator(), false)
                        .filter(csvRecord -> Integer.parseInt(csvRecord.get("Col 6"))>0)
                        .map(csvRecord -> csvRecord.toMap().entrySet().stream()
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue
                                )))
                        .collect(Collectors.toList());
    }
}
