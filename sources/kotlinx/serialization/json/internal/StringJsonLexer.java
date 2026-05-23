package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonConfiguration;
/* compiled from: StringJsonLexer.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\u000bH\u0096\u0080\u0004J\u0012\u0010\r\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0003H\u0096\u0080\u0004J5\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00102!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00120\u0019H\u0096\u0080\u0004J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0010H\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0094\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001f"}, d2 = {"Lkotlinx/serialization/json/internal/StringJsonLexer;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "source", "", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonConfiguration;)V", "getSource", "()Ljava/lang/String;", "prefetchOrEof", "", "position", "consumeNextToken", "", "canConsumeValue", "", "skipWhitespaces", "", "expected", "", "consumeKeyString", "consumeStringChunked", "isLenient", "consumeChunk", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "stringChunk", "peekLeadingMatchingValue", "keyToMatch", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StringJsonLexer extends AbstractJsonLexer {
    private final String source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringJsonLexer(String source, JsonConfiguration configuration) {
        super(configuration);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.source = source;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String getSource() {
        return this.source;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int prefetchOrEof(int i) {
        if (i < getSource().length()) {
            return i;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte consumeNextToken() {
        String source = getSource();
        int i = this.currentPosition;
        while (i != -1 && i < source.length()) {
            int i2 = i + 1;
            char charAt = source.charAt(i);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.currentPosition = i2;
                return AbstractJsonLexerKt.charToTokenClass(charAt);
            }
            i = i2;
        }
        this.currentPosition = source.length();
        return (byte) 10;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean canConsumeValue() {
        int i = this.currentPosition;
        if (i == -1) {
            return false;
        }
        String source = getSource();
        while (i < source.length()) {
            char charAt = source.charAt(i);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.currentPosition = i;
                return isValidValueStart(charAt);
            }
            i++;
        }
        this.currentPosition = i;
        return false;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int skipWhitespaces() {
        char charAt;
        int i = this.currentPosition;
        if (i == -1) {
            return i;
        }
        String source = getSource();
        while (i < source.length() && ((charAt = source.charAt(i)) == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
            i++;
        }
        this.currentPosition = i;
        return i;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void consumeNextToken(char c) {
        if (this.currentPosition == -1) {
            unexpectedToken(c);
        }
        String source = getSource();
        int i = this.currentPosition;
        while (i < source.length()) {
            int i2 = i + 1;
            char charAt = source.charAt(i);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.currentPosition = i2;
                if (charAt == c) {
                    return;
                }
                unexpectedToken(c);
            }
            i = i2;
        }
        this.currentPosition = -1;
        unexpectedToken(c);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String consumeKeyString() {
        consumeNextToken('\"');
        int i = this.currentPosition;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) getSource(), '\"', i, false, 4, (Object) null);
        if (indexOf$default == -1) {
            consumeStringLenient();
            StringJsonLexer stringJsonLexer = this;
            String str = AbstractJsonLexerKt.tokenDescription((byte) 1);
            int i2 = stringJsonLexer.currentPosition;
            AbstractJsonLexer.fail$default(stringJsonLexer, "Expected " + str + ", but had '" + ((stringJsonLexer.currentPosition == stringJsonLexer.getSource().length() || i2 < 0) ? "EOF" : String.valueOf(stringJsonLexer.getSource().charAt(i2))) + "' instead", i2, null, 4, null);
            throw new KotlinNothingValueException();
        }
        for (int i3 = i; i3 < indexOf$default; i3++) {
            if (getSource().charAt(i3) == '\\') {
                return consumeString(getSource(), this.currentPosition, i3);
            }
        }
        this.currentPosition = indexOf$default + 1;
        String substring = getSource().substring(i, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void consumeStringChunked(boolean z, Function1<? super String, Unit> consumeChunk) {
        Intrinsics.checkNotNullParameter(consumeChunk, "consumeChunk");
        for (Object obj : StringsKt.chunked(z ? consumeStringLenient() : consumeString(), 16384)) {
            consumeChunk.invoke(obj);
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String peekLeadingMatchingValue(String keyToMatch, boolean z) {
        Intrinsics.checkNotNullParameter(keyToMatch, "keyToMatch");
        int i = this.currentPosition;
        try {
            if (consumeNextToken() == 6 && Intrinsics.areEqual(peekString(z), keyToMatch)) {
                discardPeeked();
                if (consumeNextToken() == 5) {
                    return peekString(z);
                }
            }
            return null;
        } finally {
            this.currentPosition = i;
            discardPeeked();
        }
    }
}
