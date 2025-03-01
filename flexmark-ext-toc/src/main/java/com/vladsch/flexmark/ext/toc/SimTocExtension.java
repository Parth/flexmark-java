package com.vladsch.flexmark.ext.toc;

import com.vladsch.flexmark.ext.toc.internal.*;
import com.vladsch.flexmark.formatter.Formatter;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.html.renderer.AttributablePart;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.NullableDataKey;
import org.jetbrains.annotations.NotNull;

/**
 * Extension for tocs
 * <p>
 * Create it with {@link #create()} and then configure it on the builders
 * <p>
 * The parsed [TOC] text is turned into {@link SimTocBlock} nodes.
 * Rendered into table of contents based on the headings in the document
 */
public class SimTocExtension implements Parser.ParserExtension, HtmlRenderer.HtmlRendererExtension, Formatter.FormatterExtension {
    // duplicated here for convenience
    public static final AttributablePart TOC_CONTENT = TocUtils.TOC_CONTENT;        // div element wrapping TOC list
    public static final AttributablePart TOC_LIST = TocUtils.TOC_LIST;              // ul/ol element of TOC list

    public static final DataKey<Integer> LEVELS = TocExtension.LEVELS;
    public static final DataKey<Boolean> IS_TEXT_ONLY = TocExtension.IS_TEXT_ONLY;
    public static final DataKey<Boolean> IS_NUMBERED = TocExtension.IS_NUMBERED;
    public static final DataKey<TocOptions.ListType> LIST_TYPE = TocExtension.LIST_TYPE;
    public static final DataKey<Boolean> IS_HTML = TocExtension.IS_HTML;
    public static final DataKey<Integer> TITLE_LEVEL = TocExtension.TITLE_LEVEL;
    public static final NullableDataKey<String> TITLE = TocExtension.TITLE;
    public static final DataKey<Boolean> AST_INCLUDE_OPTIONS = TocExtension.AST_INCLUDE_OPTIONS;
    public static final DataKey<Boolean> BLANK_LINE_SPACER = TocExtension.BLANK_LINE_SPACER;
    public static final DataKey<String> DIV_CLASS = TocExtension.DIV_CLASS;
    public static final DataKey<String> LIST_CLASS = TocExtension.LIST_CLASS;
    public static final DataKey<Boolean> CASE_SENSITIVE_TOC_TAG = TocExtension.CASE_SENSITIVE_TOC_TAG;

    // format options
    public static final DataKey<SimTocGenerateOnFormat> FORMAT_UPDATE_ON_FORMAT = TocExtension.FORMAT_UPDATE_ON_FORMAT;
    public static final DataKey<TocOptions> FORMAT_OPTIONS = TocExtension.FORMAT_OPTIONS;

    private SimTocExtension() {
    }

    public static SimTocExtension create() {
        return new SimTocExtension();
    }

    @Override
    public void rendererOptions(@NotNull MutableDataHolder options) {
        // set header id options if not already set
        if (!options.contains(HtmlRenderer.GENERATE_HEADER_ID)) {
            options.set(HtmlRenderer.GENERATE_HEADER_ID, true);
        }
        if (!options.contains(HtmlRenderer.RENDER_HEADER_ID)) {
            options.set(HtmlRenderer.RENDER_HEADER_ID, true);
        }
    }

    @Override
    public void parserOptions(MutableDataHolder options) {

    }

    @Override
    public void extend(Formatter.Builder builder) {
        builder.nodeFormatterFactory(new SimTocNodeFormatter.Factory());
    }

    @Override
    public void extend(Parser.Builder parserBuilder) {
        parserBuilder.customBlockParserFactory(new SimTocBlockParser.Factory());
    }

    @Override
    public void extend(@NotNull HtmlRenderer.Builder rendererBuilder, @NotNull String rendererType) {
        if (rendererBuilder.isRendererType("HTML")) {
            rendererBuilder.nodeRendererFactory(new SimTocNodeRenderer.Factory());
        } else if (rendererBuilder.isRendererType("JIRA")) {
        }
    }
}
