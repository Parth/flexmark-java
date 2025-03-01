package com.vladsch.flexmark.formatter.test.suite;

import com.vladsch.flexmark.core.test.util.formatter.ComboCoreFormatterSpecTest;
import com.vladsch.flexmark.core.test.util.formatter.ComboCoreTranslationFormatterSpecTest;
import com.vladsch.flexmark.core.test.util.formatter.MergeFormatterCoreTest;
import com.vladsch.flexmark.ext.abbreviation.ComboAbbreviationFormatterSpecTest;
import com.vladsch.flexmark.ext.abbreviation.ComboAbbreviationTranslationFormatterSpecTest;
import com.vladsch.flexmark.ext.abbreviation.MergeAbbreviationsTest;
import com.vladsch.flexmark.ext.admonition.ComboAdmonitionFormatterSpecTest;
import com.vladsch.flexmark.ext.admonition.ComboAdmonitionTranslationFormatterSpecTest;
import com.vladsch.flexmark.ext.attributes.ComboAttributesFormatterSpecTest;
import com.vladsch.flexmark.ext.attributes.ComboAttributesTranslationFormatterSpecTest;
import com.vladsch.flexmark.ext.attributes.MergeAttributesTest;
import com.vladsch.flexmark.ext.autolink.MergeAutoLinkTest;
import com.vladsch.flexmark.ext.definition.ComboDefinitionFormatterSpecTest;
import com.vladsch.flexmark.ext.emoji.ComboEmojiTranslationFormatterSpecTest;
import com.vladsch.flexmark.ext.enumerated.reference.ComboEnumeratedReferenceFormatterSpecTest;
import com.vladsch.flexmark.ext.enumerated.reference.ComboEnumeratedReferenceTranslationFormatterSpecTest;
import com.vladsch.flexmark.ext.enumerated.reference.MergeEnumeratedReferenceTest;
import com.vladsch.flexmark.ext.footnotes.ComboFootnotesFormatterSpecTest;
import com.vladsch.flexmark.ext.footnotes.ComboFootnotesTranslationFormatterSpecTest;
import com.vladsch.flexmark.ext.footnotes.MergeFootnotesTest;
import com.vladsch.flexmark.ext.gfm.tasklist.ComboGfmTaskListFormatterSpecTest;
import com.vladsch.flexmark.ext.jekyll.front.matter.ComboJekyllFrontMatterFormatterSpecTest;
import com.vladsch.flexmark.ext.macros.ComboMacrosFormatterSpecTest;
import com.vladsch.flexmark.ext.macros.ComboMacrosTranslationFormatterSpecTest;
import com.vladsch.flexmark.ext.macros.MergeMacrosTest;
import com.vladsch.flexmark.ext.tables.ComboTableFormatterSpecTest;
import com.vladsch.flexmark.ext.tables.ComboTableTranslationFormatterSpecTest;
import com.vladsch.flexmark.ext.yaml.front.matter.ComboYamlFrontMatterFormatterSpecTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ComboAdmonitionFormatterSpecTest.class,
        ComboAdmonitionTranslationFormatterSpecTest.class,
        ComboAbbreviationFormatterSpecTest.class,
        ComboAbbreviationTranslationFormatterSpecTest.class,
        ComboAttributesFormatterSpecTest.class,
        ComboAttributesTranslationFormatterSpecTest.class,
        ComboDefinitionFormatterSpecTest.class,
        ComboEmojiTranslationFormatterSpecTest.class,
        ComboEnumeratedReferenceFormatterSpecTest.class,
        ComboEnumeratedReferenceTranslationFormatterSpecTest.class,
        ComboFootnotesFormatterSpecTest.class,
        ComboFootnotesTranslationFormatterSpecTest.class,
        ComboGfmTaskListFormatterSpecTest.class,
        ComboJekyllFrontMatterFormatterSpecTest.class,
        ComboMacrosFormatterSpecTest.class,
        ComboMacrosTranslationFormatterSpecTest.class,
        ComboTableFormatterSpecTest.class,
        ComboTableTranslationFormatterSpecTest.class,
        ComboYamlFrontMatterFormatterSpecTest.class,
        ComboCoreFormatterSpecTest.class,
        ComboCoreTranslationFormatterSpecTest.class,
        ComboFormatterTestSpecTest.class,
        ComboFormatterIssueSpecTest.class,
        MergeAbbreviationsTest.class,
        MergeAttributesTest.class,
        MergeEnumeratedReferenceTest.class,
        MergeFootnotesTest.class,
        MergeMacrosTest.class,
        MergeFormatterCoreTest.class,
        MergeAutoLinkTest.class,
})
public class FlexmarkFormatterTestSuite {
}
