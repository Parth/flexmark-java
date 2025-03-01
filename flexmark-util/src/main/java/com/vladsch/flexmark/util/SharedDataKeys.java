package com.vladsch.flexmark.util;

import com.vladsch.flexmark.util.builder.Extension;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.html.LineAppendable;

import java.util.Collection;

public class SharedDataKeys {

    // BuilderBase
    public static final DataKey<Collection<Extension>> EXTENSIONS = new DataKey<>("EXTENSIONS", Extension.EMPTY_LIST);

    // Parser
    public static final DataKey<Boolean> HEADING_NO_ATX_SPACE = new DataKey<>("HEADING_NO_ATX_SPACE", false);
    public static final DataKey<Boolean> HTML_FOR_TRANSLATOR = new DataKey<>("HTML_FOR_TRANSLATOR", false);
    public static final DataKey<Boolean> INTELLIJ_DUMMY_IDENTIFIER = new DataKey<>("INTELLIJ_DUMMY_IDENTIFIER", false);
    public static final DataKey<Boolean> PARSE_INNER_HTML_COMMENTS = new DataKey<>("PARSE_INNER_HTML_COMMENTS", false);
    public static final DataKey<Boolean> BLANK_LINES_IN_AST = new DataKey<>("BLANK_LINES_IN_AST", false);
    public static final DataKey<String> TRANSLATION_HTML_BLOCK_TAG_PATTERN = new DataKey<>("TRANSLATION_HTML_BLOCK_TAG_PATTERN", "___(?:\\d+)_");
    public static final DataKey<String> TRANSLATION_HTML_INLINE_TAG_PATTERN = new DataKey<>("TRANSLATION_HTML_INLINE_TAG_PATTERN", "__(?:\\d+)_");
    public static final DataKey<String> TRANSLATION_AUTOLINK_TAG_PATTERN = new DataKey<>("TRANSLATION_AUTOLINK_TAG_PATTERN", "____(?:\\d+)_");

    // HtmlRenderer
    public static final DataKey<Integer> RENDERER_FORMAT_FLAGS = new DataKey<>("RENDERER_FORMAT_FLAGS", LineAppendable.F_TRIM_LEADING_WHITESPACE);
    public static final DataKey<Integer> RENDERER_MAX_TRAILING_BLANK_LINES = new DataKey<>("RENDERER_MAX_TRAILING_BLANK_LINES", 1);
    public static final DataKey<Integer> INDENT_SIZE = new DataKey<>("INDENT_SIZE", 0);
    public static final DataKey<Boolean> PERCENT_ENCODE_URLS = new DataKey<>("PERCENT_ENCODE_URLS", false);
    public static final DataKey<Boolean> HEADER_ID_GENERATOR_RESOLVE_DUPES = new DataKey<>("HEADER_ID_GENERATOR_RESOLVE_DUPES", true);
    public static final DataKey<String> HEADER_ID_GENERATOR_TO_DASH_CHARS = new DataKey<>("HEADER_ID_GENERATOR_TO_DASH_CHARS", " -_");
    public static final DataKey<String> HEADER_ID_GENERATOR_NON_DASH_CHARS = new DataKey<>("HEADER_ID_GENERATOR_NON_DASH_CHARS", "");
    public static final DataKey<Boolean> HEADER_ID_GENERATOR_NO_DUPED_DASHES = new DataKey<>("HEADER_ID_GENERATOR_NO_DUPED_DASHES", false);
    public static final DataKey<Boolean> HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE = new DataKey<>("HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE", true);
    public static final DataKey<Boolean> RENDER_HEADER_ID = new DataKey<>("RENDER_HEADER_ID", false);
    public static final DataKey<Boolean> GENERATE_HEADER_ID = new DataKey<>("GENERATE_HEADER_ID", true);
    public static final DataKey<Boolean> DO_NOT_RENDER_LINKS = new DataKey<>("DO_NOT_RENDER_LINKS", false);

    // Formatter
    public static final DataKey<Integer> FORMATTER_MAX_BLANK_LINES = new DataKey<>("FORMATTER_MAX_BLANK_LINES", 2);
    public static final DataKey<Integer> FORMATTER_MAX_TRAILING_BLANK_LINES = new DataKey<>("FORMATTER_MAX_TRAILING_BLANK_LINES", 1);
}
