package com.github.chandrn.streams;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PersonLoader {

    public static List<Person> load() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        List<Person> people = objectMapper.readValue(new File("people.json"), new TypeReference<List<Person>>(){});
        return people;
    }

    public static void main(String[] args) throws IOException {
        load();
    }
}
