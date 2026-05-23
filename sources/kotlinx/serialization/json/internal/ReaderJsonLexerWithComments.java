package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonConfiguration;
/* compiled from: CommentLexers.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B!\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010\n\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\u0010H\u0096\u0080\u0004J\u001e\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0006\u0010\u0015\u001a\u00020\u0014H\u0082\u0080\u0004J\u0012\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0082\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0014H\u0096\u0080\u0004¨\u0006\u0018"}, d2 = {"Lkotlinx/serialization/json/internal/ReaderJsonLexerWithComments;", "Lkotlinx/serialization/json/internal/ReaderJsonLexer;", "reader", "Lkotlinx/serialization/json/internal/InternalJsonReader;", "buffer", "", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonReader;[CLkotlinx/serialization/json/JsonConfiguration;)V", "consumeNextToken", "", "expected", "", "canConsumeValue", "", "", "peekNextToken", "handleComment", "Lkotlin/Pair;", "", "position", "prefetchWithinThreshold", "skipWhitespaces", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReaderJsonLexerWithComments extends ReaderJsonLexer {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReaderJsonLexerWithComments(InternalJsonReader reader, char[] buffer, JsonConfiguration configuration) {
        super(reader, buffer, configuration);
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
    }

    @Override // kotlinx.serialization.json.internal.ReaderJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public void consumeNextToken(char c) {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces >= source.length() || skipWhitespaces == -1) {
            this.currentPosition = -1;
            unexpectedToken(c);
        }
        char charAt = source.charAt(skipWhitespaces);
        this.currentPosition = skipWhitespaces + 1;
        if (charAt == c) {
            return;
        }
        unexpectedToken(c);
    }

    @Override // kotlinx.serialization.json.internal.ReaderJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean canConsumeValue() {
        ensureHaveChars();
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces >= getSource().length() || skipWhitespaces == -1) {
            return false;
        }
        return isValidValueStart(getSource().charAt(skipWhitespaces));
    }

    @Override // kotlinx.serialization.json.internal.ReaderJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte consumeNextToken() {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces >= source.length() || skipWhitespaces == -1) {
            return (byte) 10;
        }
        this.currentPosition = skipWhitespaces + 1;
        return AbstractJsonLexerKt.charToTokenClass(source.charAt(skipWhitespaces));
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte peekNextToken() {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces >= source.length() || skipWhitespaces == -1) {
            return (byte) 10;
        }
        this.currentPosition = skipWhitespaces;
        return AbstractJsonLexerKt.charToTokenClass(source.charAt(skipWhitespaces));
    }

    private final Pair<Integer, Boolean> handleComment(int i) {
        int i2 = i + 2;
        char charAt = getSource().charAt(i + 1);
        boolean z = false;
        if (charAt != '*') {
            if (charAt == '/') {
                int i3 = i2;
                while (i != -1) {
                    int indexOf$default = StringsKt.indexOf$default((CharSequence) getSource(), '\n', i3, false, 4, (Object) null);
                    if (indexOf$default == -1) {
                        i3 = prefetchOrEof(getSource().length());
                        i = i3;
                    } else {
                        return TuplesKt.to(Integer.valueOf(indexOf$default + 1), true);
                    }
                }
                return TuplesKt.to(-1, true);
            }
            return TuplesKt.to(Integer.valueOf(i), false);
        }
        int i4 = i2;
        while (i != -1) {
            int indexOf$default2 = StringsKt.indexOf$default((CharSequence) getSource(), "*/", i4, false, 4, (Object) null);
            if (indexOf$default2 != -1) {
                return TuplesKt.to(Integer.valueOf(indexOf$default2 + 2), true);
            }
            if (getSource().charAt(getSource().length() - 1) != '*') {
                i4 = prefetchOrEof(getSource().length());
            } else {
                i4 = prefetchWithinThreshold(getSource().length() - 1);
                if (z) {
                    break;
                }
                z = true;
            }
            i = i4;
        }
        this.currentPosition = getSource().length();
        AbstractJsonLexer.fail$default(this, "Expected end of the block comment: \"*/\", but had EOF instead", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final int prefetchWithinThreshold(int i) {
        if (getSource().length() - i > this.threshold) {
            return i;
        }
        this.currentPosition = i;
        ensureHaveChars();
        return (this.currentPosition != 0 || getSource().length() == 0) ? -1 : 0;
    }

    @Override // kotlinx.serialization.json.internal.ReaderJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public int skipWhitespaces() {
        int prefetchOrEof;
        int i = this.currentPosition;
        while (true) {
            prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof != -1) {
                char charAt = getSource().charAt(prefetchOrEof);
                if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                    if (charAt != '/' || prefetchOrEof + 1 >= getSource().length()) {
                        break;
                    }
                    Pair<Integer, Boolean> handleComment = handleComment(prefetchOrEof);
                    int intValue = handleComment.component1().intValue();
                    if (!handleComment.component2().booleanValue()) {
                        prefetchOrEof = intValue;
                        break;
                    }
                    i = intValue;
                } else {
                    i = prefetchOrEof + 1;
                }
            } else {
                break;
            }
        }
        this.currentPosition = prefetchOrEof;
        return prefetchOrEof;
    }
}
