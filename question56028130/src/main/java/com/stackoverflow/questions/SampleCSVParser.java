package com.stackoverflow.questions;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

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
                .withDelimiter('|')
                .withTrim()
                .withQuote(null)
                .parse(in);


        return StreamSupport
                        .stream(records.spliterator(), false)
                        .map(csvRecord -> csvRecord.toMap().entrySet().stream()
                                .collect(Collectors.toMap(
                                        e -> e.getKey(),
                                        e -> StringUtils.unwrap(e.getValue(), "\"")
                                )))
                        .collect(Collectors.toList());
    }
}
