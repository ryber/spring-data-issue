package com.acme;


import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Properties;

import static org.junit.Assert.assertFalse;

public class MappingIssueTest {

    private MongoTemplate mongoTemplate;

    @Test
    public void exposeIssue() throws Exception {
        Properties props = getProps();
        mongoTemplate = new MongoTemplate(new MyMongoFactory(props.getProperty("url"), props.getProperty("username"), props.getProperty("password")));
        mongoTemplate.dropCollection(Foo.class);

        String jsonData = toStringFromClasspath("source-data.json");
        mongoTemplate.insert(jsonData, "foo");
        assertFalse("We found no foos were inserted in the database.", mongoTemplate.findAll(Foo.class).isEmpty());

    }

    public static String toStringFromClasspath(String path) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(path);
        try {
            return IOUtils.toString(input);
        } catch (IOException e) {
            throw new RuntimeException("A problem occurred while reading file expected at path: " + path, e);
        } finally {
            IOUtils.closeQuietly(input);
        }
    }

    public Properties getProps() throws IOException {
        Properties props = new Properties();
        props.load(new StringReader(toStringFromClasspath("settings.properties")));
        return props;
    }
}
