package com.vladsch.flexmark.test.util.spec;

import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.IParse;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.CharSubSequence;
import com.vladsch.flexmark.util.sequence.SubSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public abstract class IParseBase implements IParse {
    private final DataHolder myOptions;

    public IParseBase() {
        this(null);
    }

    public IParseBase(DataHolder options) {
        myOptions = options;
    }

    @Override
    public @NotNull Node parse(@NotNull String input) {
        return parse(BasedSequence.of(input));
    }

    @Override
    public boolean transferReferences(@NotNull Document document, @NotNull Document included, Boolean onlyIfUndefined) {
        return false;
    }

    @Override
    public @NotNull Node parseReader(@NotNull Reader input) throws IOException {
        BufferedReader bufferedReader;
        if (input instanceof BufferedReader) {
            bufferedReader = (BufferedReader) input;
        } else {
            bufferedReader = new BufferedReader(input);
        }

        StringBuilder file = new StringBuilder();
        char[] buffer = new char[16384];

        while (true) {
            int charsRead = bufferedReader.read(buffer);
            file.append(buffer, 0, charsRead);
            if (charsRead < buffer.length) break;
        }

        BasedSequence source = BasedSequence.of(file.toString());
        return parse(source);
    }

    @Nullable
    public DataHolder getOptions() {
        return myOptions;
    }
}
