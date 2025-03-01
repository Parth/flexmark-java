package com.vladsch.flexmark.core.test.util.parser;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.test.specs.TestSpecLocator;
import com.vladsch.flexmark.test.util.spec.ResourceLocation;
import com.vladsch.flexmark.test.util.spec.SpecReader;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.CommandLineOptions;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collections;
import java.util.List;

@State(Scope.Benchmark)
public class SpecBenchmark {
    private static final String SPEC = TestSpecLocator.DEFAULT_RESOURCE_LOCATION.getResourceText();
    private static final List<String> SPEC_EXAMPLES =
            SpecReader.createAndReadExamples(TestSpecLocator.DEFAULT_RESOURCE_LOCATION, false)
                    .getExamplesSourceAsString();
    private static final Parser PARSER = Parser.builder().build();
    private static final HtmlRenderer RENDERER = HtmlRenderer.builder().build();

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .parent(new CommandLineOptions(args))
                .include(SpecBenchmark.class.getName() + ".*")
                .build();
        new Runner(options).run();
    }

    @Benchmark
    public long wholeSpec() {
        return parseAndRender(Collections.singletonList(SPEC));
    }

    @Benchmark
    public long examples() {
        return parseAndRender(SPEC_EXAMPLES);
    }

    private static long parseAndRender(List<String> examples) {
        long length = 0;
        for (String example : examples) {
            String result = RENDERER.render(PARSER.parse(example));
            length += result.length();
        }
        return length;
    }
}
