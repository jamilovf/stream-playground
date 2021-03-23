package countries;

import java.io.IOException;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Homework1 {

    private List<Country> countries;

    public Homework1() {
        countries = new CountryRepository().getAll();
    }

    /**
     * Returns whether there is at least one country with the word "island" in its name ignoring case.
     */
    public boolean streamPipeline1() {

        return countries.stream().
                anyMatch(c->c.getName().toLowerCase().contains("island"));

    }

    /**
     *  Returns the first country name that contains the word "island" ignoring case.
     */
    public Optional<String> streamPipeline2() {

        return countries.stream().
                map(c->c.getName()).
                filter(n->n.toLowerCase().contains("island")).
                findFirst();
    }

    /**
     * Prints each country name in which the first and the last letters are the same ignoring case.
     */
    public void streamPipeline3() {
        countries.stream()
                .filter(c->c.getName().toLowerCase().charAt(0) == c.getName().toLowerCase().charAt(c.getName().length() - 1))
                .map(c->c.getName())
                .forEach(System.out::println);
    }

    /**
     * Prints the populations of the first ten least populous countries.
     */
    public void streamPipeline4() {
        countries.stream()
                .mapToLong(c->c.getPopulation())
                .sorted()
                .limit(10)
                .forEach(System.out::println);
    }

    /**
     * Prints the names of the first ten least populous countries.
     */
    public void streamPipeline5() {
        countries.stream()
                .sorted(Comparator.comparingLong(c -> c.getPopulation()))
                .limit(10)
                .map(c -> c.getName())
                .forEach(System.out::println);
    }

    /**
     * Returns summary statistics about the number of country name translations associated with each country.
     */
    public IntSummaryStatistics streamPipeline6() {

        return countries.stream()
                .mapToInt(c -> c.getTranslations().keySet().size())
                .summaryStatistics();
    }

    /**
     * Prints the names of countries in the ascending order of the number of timezones.
     */
    public void streamPipeline7() {
        countries.stream()
                .sorted(Comparator.comparingLong(c -> c.getTimezones().size()))
                .map(c -> c.getName())
                .forEach(System.out::println);
    }

    /**
     * Prints the number of timezones for each country in the form {@code name:timezones}, in the ascending order of the number of timezones.
     */
    public void streamPipeline8() {
        countries.stream()
                .sorted(Comparator.comparingLong(c -> c.getTimezones().size()))
                .map(c -> c.getName() + " : " + c.getTimezones().size())
                .forEach(System.out::println);
    }

    /**
     * Returns the number of countries with no Spanish country name translation (the Spanish language is identifi
ed by the language code "es").
     */
    public long streamPipeline9() {
        return countries.stream()
                .filter(c -> c.getTranslations().containsKey("es"))
                .count();
    }

    /**
     * Prints the names of countries with null area.
     */
    public void streamPipeline10() {
        countries.stream()
                .filter(c->c.getArea() == null)
                .forEach(c -> System.out.println(c.getName()));
    }

    /**
     * Prints all distinct language tags of country name translations sorted in alphabetical order.
     */
    public void streamPipeline11() {
        // TODO
    }

    /**
     * Returns the average length of country names.
     */
    public double streamPipeline12() {

        return countries.stream()
                .mapToInt(c -> c.getName().length())
                .average()
                .getAsDouble();
    }

    /**
     * Prints all distinct regions of the countries with null area.
     */
    public void streamPipeline13() {
        countries.stream().
                map(c -> c.getRegion())
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * Returns the largest country with non-null area.
     */
    public Optional<Country> streamPipeline14() {
        // TODO
        return null;
    }

    /**
     * Prints the names of countries with a non-null area below 1.
     */
    public void streamPipeline15() {
        // TODO
    }

    /**
     * Prints all distinct timezones of European and Asian countries.
     */
    public void streamPipeline16() {
        // TODO
    }

}
