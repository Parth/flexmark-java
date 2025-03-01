package com.vladsch.flexmark.util.format;

import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarkdownParagraphTest {

    @Test
    public void test_wrapIndentedLines() {
        BasedSequence input = BasedSequence.of("Add: configuration for repeated prefixes in items, which would `be #2` copied when adding/splitting an item. In other words they\n" +
                "    would be treated equivalent to task item marker prefix. That way\n" +
                "    standard: `Add: `, `Fix: `, `Break: ` and `Deprecate: ` prefixes would be automatically copied.");

        String expected = "Add: configuration for repeated prefixes in items, which would `be\n" +
                "#2` copied when adding/splitting an item. In other words they\n" +
                "would be treated equivalent to task item marker prefix. That way\n" +
                "standard: `Add: `, `Fix: `, `Break: ` and `Deprecate: ` prefixes\n" +
                "would be automatically copied.";

        MarkdownParagraph formatter = new MarkdownParagraph(input, CharWidthProvider.NULL);
        formatter.setFirstIndent(0);
        formatter.setWidth(66);
        formatter.setFirstWidthOffset(0);
        formatter.setKeepLineBreaks(false); // cannot keep line breaks when formatting as you type
        formatter.setKeepHardBreaks(true);

        BasedSequence actual = formatter.computeLeftAlignedSequence();
        assertEquals(expected, actual.toString());
    }

    @Test
    public void test_wrapIndentedLines2() {
        BasedSequence input = BasedSequence.of("Fix: mixed task and non-task items, toggle prefix adds it to all instead of removing only task\n" +
                "    item prefix or adding to only list items. Test is done.");

        String expected = "" +
                "Fix: mixed task and non-task items, toggle prefix adds it to all instead of removing only\n" +
                "task item prefix or adding to only list items. Test is done." +
                "";

        MarkdownParagraph formatter = new MarkdownParagraph(input, CharWidthProvider.NULL);
        formatter.setFirstIndent(0);
        formatter.setWidth(90);
        formatter.setFirstWidthOffset(0);
        formatter.setKeepLineBreaks(false); // cannot keep line breaks when formatting as you type
        formatter.setKeepHardBreaks(true);

        BasedSequence actual = formatter.computeLeftAlignedSequence();
        assertEquals(expected, actual.toString());
    }

    @Test
    public void test_wrapIndentedLines3() {
        BasedSequence input = BasedSequence.of("Fix: mixed task and non-task items, toggle prefix adds it to all instead of removing only task\n" +
                "    item prefix or adding to only list items. Test is done.");

        String expected = "" +
                "Fix: mixed task and non-task items, toggle prefix adds it to all instead of removing only\n" +
                "task item prefix or adding to only list items. Test is done." +
                "";

        BasedSequence basedInput = BasedSequence.of(input);
        MarkdownParagraph formatter = new MarkdownParagraph(basedInput, CharWidthProvider.NULL);
        formatter.setFirstIndent(0);
        formatter.setWidth(90);
        formatter.setFirstWidthOffset(0);
        formatter.setKeepLineBreaks(false); // cannot keep line breaks when formatting as you type
        formatter.setKeepHardBreaks(true);

        BasedSequence actual = formatter.computeLeftAlignedSequence();
        assertEquals(expected, actual.toString());

        SequenceBuilder builder = SequenceBuilder.emptyBuilder(basedInput);
        actual.addSegments(builder.getSegmentBuilder());
        assertEquals("" +
                "⟦Fix: mixed task and non-task items, toggle prefix adds it to all instead of removing only⟧\n" +
                "⟦task⟧⟦ ⟧⟦item prefix or adding to only list items. Test is done.⟧" +
                "", builder.getSegmentBuilder().toStringWithRanges());

        BasedSequence sequence = actual.toSpc().trimEnd(BasedSequence.WHITESPACE_SET).appendEOL();

        SequenceBuilder builder2 = SequenceBuilder.emptyBuilder(basedInput);
        sequence.addSegments(builder2.getSegmentBuilder());
        assertEquals("" +
                "⟦Fix: mixed task and non-task items, toggle prefix adds it to all instead of removing only⟧\n" +
                "⟦task⟧⟦ ⟧⟦item prefix or adding to only list items. Test is done.⟧\n" +
                "⟦⟧" +
                "", builder2.getSegmentBuilder().toStringWithRanges());
    }
}
