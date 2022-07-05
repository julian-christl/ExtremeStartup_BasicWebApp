package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsName() {
        assertThat(queryProcessor.process("what is my name"), is("Julian"));
    }

    @Test
    public void supportsSum(){
        assertThat(queryProcessor.process("what is 1 plus 1"), is("2"));
        assertThat(queryProcessor.process("what is 25 plus 14"), is("39"));
        assertThat(queryProcessor.process("68cc9aa0: what is 1 plus 1"), is("2"));
    }

    @Test
    public void supportsLargestNumber(){
        assertThat(queryProcessor.process("which of the following numbers is the largest: 1, 2, 3, 4"), is("4"));
        assertThat(queryProcessor.process("66614f80: which of the following numbers is the largest: 11, 353"), is("353"));
    }
    @Test
    public void supportsMul(){
        assertThat(queryProcessor.process("what is 1 multiplied by 1"), is("1"));
        assertThat(queryProcessor.process("what is 3 multiplied by 4"), is("12"));
        assertThat(queryProcessor.process("68cc9aa0: what is 1 multiplied by 1"), is("1"));
    }

}
