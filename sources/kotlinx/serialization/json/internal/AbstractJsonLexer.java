package kotlinx.serialization.json.internal;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.IgnorableReturnValue;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: AbstractJsonLexer.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\b \u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r*\u00020\u000eH\u0084\u0088\u0004J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\rH\u0086\u0080\u0004J\u0012\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH¦\u0080\u0004J\n\u0010\u0014\u001a\u00020\rH¦\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0016H¦\u0080\u0004J\n\u0010\u0017\u001a\u00020\rH\u0086\u0080\u0004J\u0012\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000eH\u0084\u0080\u0004J\n\u0010\u001a\u001a\u00020\u0010H\u0086\u0080\u0004J\u0012\u0010\u0015\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0016H\u0087\u0080\bJ\u0012\u0010\u0015\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u000eH¦\u0080\u0004J\u0012\u0010%\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u000eH\u0084\u0080\u0004J^\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00162\b\b\u0002\u0010)\u001a\u00020\r28\b\u0002\u0010*\u001a2\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u001c0+H\u0080\u0088\u0004ø\u0001\u0000¢\u0006\u0002\b.J\n\u0010/\u001a\u00020\u0016H\u0096\u0080\u0004J\u0014\u00100\u001a\u00020\r2\b\b\u0002\u00101\u001a\u00020\rH\u0086\u0080\u0004J\n\u00102\u001a\u00020\tH¦\u0080\u0004J\u001c\u00103\u001a\u0004\u0018\u00010\u001c2\u0006\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\rH¦\u0080\u0004J\u0014\u00106\u001a\u0004\u0018\u00010\u001c2\u0006\u00105\u001a\u00020\rH\u0086\u0080\u0004J\n\u00107\u001a\u00020\u0010H\u0086\u0080\u0004J\u001a\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\tH\u0096\u0080\u0004J\u001a\u0010;\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\t2\u0006\u0010<\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010=\u001a\u00020\u001cH¦\u0080\u0004J\u001a\u0010>\u001a\u00020\r2\u0006\u00105\u001a\u00020\r2\u0006\u00109\u001a\u00020\u000eH\u0082\u0080\u0004J5\u0010?\u001a\u00020\u00102\u0006\u00105\u001a\u00020\r2!\u0010@\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\u00100AH\u0096\u0080\u0004JE\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\r2!\u0010@\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\u00100AH\u0082\u0080\u0004J\n\u0010G\u001a\u00020\u001cH\u0086\u0080\u0004J\"\u0010G\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\tH\u0085\u0080\u0004J\u001a\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020\t2\u0006\u0010I\u001a\u00020\tH\u0082\u0080\u0004J\u001a\u0010L\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0082\u0080\u0004J\n\u0010M\u001a\u00020\u001cH\u0082\u0080\u0004J\n\u0010N\u001a\u00020\u001cH\u0086\u0080\u0004J\n\u0010O\u001a\u00020\rH\u0082\u0080\u0004J\n\u0010P\u001a\u00020\u001cH\u0086\u0080\u0004J\u001a\u0010Q\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\tH\u0094\u0080\u0004J\u0012\u0010R\u001a\u00020\t2\u0006\u0010H\u001a\u00020\tH\u0082\u0080\u0004J\u001a\u0010S\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\tH\u0082\u0080\u0004J2\u0010T\u001a\u00020\u00102\u0006\u0010U\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\t2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0VH\u0080\u0088\u0004ø\u0001\u0000¢\u0006\u0002\bWJ\u001a\u0010X\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0082\u0080\u0004J\u0012\u0010Y\u001a\u00020\u00102\u0006\u0010Z\u001a\u00020\rH\u0086\u0080\u0004J\n\u0010[\u001a\u00020\u001cH\u0096\u0080\u0004J\u0012\u0010\\\u001a\u00020\u00102\u0006\u0010]\u001a\u00020\u001cH\u0086\u0080\u0004J&\u0010&\u001a\u00020'2\u0006\u0010*\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010^\u001a\u00020\u001cH\u0086\u0080\u0004J\n\u0010_\u001a\u00020`H\u0086\u0080\u0004J\n\u0010a\u001a\u00020`H\u0086\u0080\u0004J\n\u0010b\u001a\u00020\rH\u0086\u0080\u0004J\n\u0010c\u001a\u00020\rH\u0086\u0080\u0004J\u0012\u0010b\u001a\u00020\r2\u0006\u0010d\u001a\u00020\tH\u0083\u0080\u0004J\u001a\u0010e\u001a\u00020\u00102\u0006\u0010f\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\tH\u0082\u0080\u0004J#\u0010g\u001a\u0002Hh\"\u0004\b\u0000\u0010h2\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hh0VH\u0082\u0088\u0004¢\u0006\u0002\u0010jR\u0013\u0010\u0004\u001a\u00020\u0005X¤\u0084\b¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t8\u0000@\u0000X\u0081\u008e\b¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u001f\u0010\u001d\u001a\u00060\u001ej\u0002`\u001fX\u0084\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006k"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "", "<init>", "()V", "source", "", "getSource", "()Ljava/lang/CharSequence;", "currentPosition", "", "path", "Lkotlinx/serialization/json/internal/JsonPath;", "isWs", "", "", "ensureHaveChars", "", "isNotEof", "prefetchOrEof", "position", "canConsumeValue", "consumeNextToken", "", "tryConsumeComma", "isValidValueStart", "c", "expectEof", "peekedString", "", "escapedString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getEscapedString", "()Ljava/lang/StringBuilder;", "setEscapedString", "(Ljava/lang/StringBuilder;)V", "expected", "unexpectedToken", "fail", "", "expectedToken", "wasConsumed", "message", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "fail$kotlinx_serialization_json", "peekNextToken", "tryConsumeNull", "doConsume", "skipWhitespaces", "peekLeadingMatchingValue", "keyToMatch", "isLenient", "peekString", "discardPeeked", "indexOf", "char", "startPos", "substring", "endPos", "consumeKeyString", "insideString", "consumeStringChunked", "consumeChunk", "Lkotlin/Function1;", "stringChunk", "writeRange", "fromIndex", "toIndex", "currentChunkHasEscape", "consumeString", "startPosition", "current", "appendEscape", "lastPosition", "decodedString", "takePeeked", "consumeStringLenientNotNull", "wasUnquotedString", "consumeStringLenient", "appendRange", "appendEsc", "appendHex", "require", "condition", "Lkotlin/Function0;", "require$kotlinx_serialization_json", "fromHexChar", "skipElement", "allowLenientStrings", "toString", "failOnUnknownKey", "key", "hint", "consumeNumericLiteral", "", "consumeNumericLiteralFully", "consumeBoolean", "consumeBooleanLenient", TtmlNode.START, "consumeBooleanLiteral", "literalSuffix", "withPositionRollback", ExifInterface.GPS_DIRECTION_TRUE, "action", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AbstractJsonLexer {
    public int currentPosition;
    private String peekedString;
    public final JsonPath path = new JsonPath();
    private StringBuilder escapedString = new StringBuilder();

    public abstract boolean canConsumeValue();

    public abstract String consumeKeyString();

    public abstract byte consumeNextToken();

    public abstract void consumeNextToken(char c);

    public void ensureHaveChars() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract CharSequence getSource();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isValidValueStart(char c) {
        return (c == ',' || c == ':' || c == ']' || c == '}') ? false : true;
    }

    protected final boolean isWs(char c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t';
    }

    public abstract String peekLeadingMatchingValue(String str, boolean z);

    public abstract int prefetchOrEof(int i);

    public abstract int skipWhitespaces();

    public final boolean isNotEof() {
        return peekNextToken() != 10;
    }

    public final boolean tryConsumeComma() {
        int skipWhitespaces = skipWhitespaces();
        CharSequence source = getSource();
        if (skipWhitespaces >= source.length() || skipWhitespaces == -1 || source.charAt(skipWhitespaces) != ',') {
            return false;
        }
        this.currentPosition++;
        return true;
    }

    public final void expectEof() {
        if (consumeNextToken() == 10) {
            return;
        }
        fail$default(this, "Expected EOF after parsing, but had " + getSource().charAt(this.currentPosition - 1) + " instead", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final StringBuilder getEscapedString() {
        return this.escapedString;
    }

    protected final void setEscapedString(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "<set-?>");
        this.escapedString = sb;
    }

    @IgnorableReturnValue
    public final byte consumeNextToken(byte b) {
        byte consumeNextToken = consumeNextToken();
        if (consumeNextToken != b) {
            String str = AbstractJsonLexerKt.tokenDescription(b);
            int i = this.currentPosition;
            int i2 = i - 1;
            fail$default(this, "Expected " + str + ", but had '" + ((i == getSource().length() || i2 < 0) ? "EOF" : String.valueOf(getSource().charAt(i2))) + "' instead", i2, null, 4, null);
            throw new KotlinNothingValueException();
        }
        return consumeNextToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void unexpectedToken(char c) {
        int i = this.currentPosition;
        if (i > 0 && c == '\"') {
            try {
                this.currentPosition = i - 1;
                String consumeStringLenient = consumeStringLenient();
                this.currentPosition = i;
                if (Intrinsics.areEqual(consumeStringLenient, AbstractJsonLexerKt.NULL)) {
                    fail("Expected string literal but 'null' literal was found", this.currentPosition - 1, AbstractJsonLexerKt.coerceInputValuesHint);
                    throw new KotlinNothingValueException();
                }
            } catch (Throwable th) {
                this.currentPosition = i;
                throw th;
            }
        }
        String str = AbstractJsonLexerKt.tokenDescription(AbstractJsonLexerKt.charToTokenClass(c));
        int i2 = this.currentPosition;
        int i3 = i2 - 1;
        fail$default(this, "Expected " + str + ", but had '" + ((i2 == getSource().length() || i3 < 0) ? "EOF" : String.valueOf(getSource().charAt(i3))) + "' instead", i3, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Void fail$kotlinx_serialization_json$default(AbstractJsonLexer abstractJsonLexer, byte b, boolean z, Function2 message, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                message = new Function2<String, String, String>() { // from class: kotlinx.serialization.json.internal.AbstractJsonLexer$fail$1
                    @Override // kotlin.jvm.functions.Function2
                    public final String invoke(String expected, String source) {
                        Intrinsics.checkNotNullParameter(expected, "expected");
                        Intrinsics.checkNotNullParameter(source, "source");
                        return "Expected " + expected + ", but had '" + source + "' instead";
                    }
                };
            }
            Intrinsics.checkNotNullParameter(message, "message");
            String str = AbstractJsonLexerKt.tokenDescription(b);
            int i2 = z ? abstractJsonLexer.currentPosition - 1 : abstractJsonLexer.currentPosition;
            fail$default(abstractJsonLexer, (String) message.invoke(str, (abstractJsonLexer.currentPosition == abstractJsonLexer.getSource().length() || i2 < 0) ? "EOF" : String.valueOf(abstractJsonLexer.getSource().charAt(i2))), i2, null, 4, null);
            throw new KotlinNothingValueException();
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
    }

    public final Void fail$kotlinx_serialization_json(byte b, boolean z, Function2<? super String, ? super String, String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        String str = AbstractJsonLexerKt.tokenDescription(b);
        int i = this.currentPosition;
        if (z) {
            i--;
        }
        int i2 = i;
        fail$default(this, message.invoke(str, (this.currentPosition == getSource().length() || i2 < 0) ? "EOF" : String.valueOf(getSource().charAt(i2))), i2, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public byte peekNextToken() {
        CharSequence source = getSource();
        int i = this.currentPosition;
        while (true) {
            int prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof != -1) {
                char charAt = source.charAt(prefetchOrEof);
                if (charAt != '\t' && charAt != '\n' && charAt != '\r' && charAt != ' ') {
                    this.currentPosition = prefetchOrEof;
                    return AbstractJsonLexerKt.charToTokenClass(charAt);
                }
                i = prefetchOrEof + 1;
            } else {
                this.currentPosition = prefetchOrEof;
                return (byte) 10;
            }
        }
    }

    public static /* synthetic */ boolean tryConsumeNull$default(AbstractJsonLexer abstractJsonLexer, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            return abstractJsonLexer.tryConsumeNull(z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
    }

    public final boolean tryConsumeNull(boolean z) {
        int prefetchOrEof = prefetchOrEof(skipWhitespaces());
        int length = getSource().length() - prefetchOrEof;
        if (length < 4 || prefetchOrEof == -1) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (AbstractJsonLexerKt.NULL.charAt(i) != getSource().charAt(prefetchOrEof + i)) {
                return false;
            }
        }
        if (length <= 4 || AbstractJsonLexerKt.charToTokenClass(getSource().charAt(prefetchOrEof + 4)) != 0) {
            if (z) {
                this.currentPosition = prefetchOrEof + 4;
                return true;
            }
            return true;
        }
        return false;
    }

    public final String peekString(boolean z) {
        String consumeString;
        byte peekNextToken = peekNextToken();
        if (z) {
            if (peekNextToken != 1 && peekNextToken != 0) {
                return null;
            }
            consumeString = consumeStringLenient();
        } else if (peekNextToken != 1) {
            return null;
        } else {
            consumeString = consumeString();
        }
        this.peekedString = consumeString;
        return consumeString;
    }

    public final void discardPeeked() {
        this.peekedString = null;
    }

    public int indexOf(char c, int i) {
        return StringsKt.indexOf$default(getSource(), c, i, false, 4, (Object) null);
    }

    public String substring(int i, int i2) {
        return getSource().subSequence(i, i2).toString();
    }

    private final boolean insideString(boolean z, char c) {
        return z ? AbstractJsonLexerKt.charToTokenClass(c) == 0 : c != '\"';
    }

    public void consumeStringChunked(boolean z, Function1<? super String, Unit> consumeChunk) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(consumeChunk, "consumeChunk");
        byte peekNextToken = peekNextToken();
        if (!z || peekNextToken == 0) {
            if (!z) {
                consumeNextToken('\"');
            }
            int i3 = this.currentPosition;
            char charAt = getSource().charAt(i3);
            boolean z2 = false;
            int i4 = i3;
            while (this.insideString(z, charAt)) {
                if (z || charAt != '\\') {
                    int i5 = i4 + 1;
                    i = i3;
                    i2 = i5;
                } else {
                    i2 = this.prefetchOrEof(this.appendEscape(i3, i4));
                    z2 = true;
                    i = i2;
                }
                if (i2 >= this.getSource().length()) {
                    this.writeRange(i, i2, z2, consumeChunk);
                    int prefetchOrEof = this.prefetchOrEof(i2);
                    if (prefetchOrEof == -1) {
                        fail$default(this, "EOF", prefetchOrEof, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                    z2 = false;
                    i3 = prefetchOrEof;
                    i4 = i3;
                } else {
                    int i6 = i;
                    i4 = i2;
                    i3 = i6;
                }
                AbstractJsonLexer abstractJsonLexer = this;
                charAt = abstractJsonLexer.getSource().charAt(i4);
                this = abstractJsonLexer;
            }
            AbstractJsonLexer abstractJsonLexer2 = this;
            abstractJsonLexer2.writeRange(i3, i4, z2, consumeChunk);
            abstractJsonLexer2.currentPosition = i4;
            if (z) {
                return;
            }
            abstractJsonLexer2.consumeNextToken('\"');
        }
    }

    private final void writeRange(int i, int i2, boolean z, Function1<? super String, Unit> function1) {
        if (z) {
            function1.invoke(decodedString(i, i2));
        } else {
            function1.invoke(substring(i, i2));
        }
    }

    public final String consumeString() {
        if (this.peekedString != null) {
            return takePeeked();
        }
        return consumeKeyString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String consumeString(CharSequence source, int i, int i2) {
        String decodedString;
        AbstractJsonLexer abstractJsonLexer;
        Intrinsics.checkNotNullParameter(source, "source");
        char charAt = source.charAt(i2);
        boolean z = false;
        while (charAt != '\"') {
            if (charAt == '\\') {
                int prefetchOrEof = this.prefetchOrEof(this.appendEscape(i, i2));
                if (prefetchOrEof == -1) {
                    fail$default(this, "Unexpected EOF", prefetchOrEof, null, 4, null);
                    throw new KotlinNothingValueException();
                }
                abstractJsonLexer = this;
                z = true;
                i = prefetchOrEof;
                i2 = i;
            } else {
                abstractJsonLexer = this;
                i2++;
                if (i2 >= source.length()) {
                    abstractJsonLexer.appendRange(i, i2);
                    int prefetchOrEof2 = abstractJsonLexer.prefetchOrEof(i2);
                    if (prefetchOrEof2 == -1) {
                        fail$default(abstractJsonLexer, "Unexpected EOF", prefetchOrEof2, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                    i = prefetchOrEof2;
                    i2 = i;
                    z = true;
                } else {
                    continue;
                }
            }
            AbstractJsonLexer abstractJsonLexer2 = abstractJsonLexer;
            charAt = source.charAt(i2);
            this = abstractJsonLexer2;
        }
        AbstractJsonLexer abstractJsonLexer3 = this;
        if (!z) {
            decodedString = abstractJsonLexer3.substring(i, i2);
        } else {
            decodedString = abstractJsonLexer3.decodedString(i, i2);
        }
        abstractJsonLexer3.currentPosition = i2 + 1;
        return decodedString;
    }

    private final int appendEscape(int i, int i2) {
        appendRange(i, i2);
        return appendEsc(i2 + 1);
    }

    private final String decodedString(int i, int i2) {
        appendRange(i, i2);
        String sb = this.escapedString.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        this.escapedString.setLength(0);
        return sb;
    }

    private final String takePeeked() {
        String str = this.peekedString;
        Intrinsics.checkNotNull(str);
        this.peekedString = null;
        return str;
    }

    public final String consumeStringLenientNotNull() {
        String consumeStringLenient = consumeStringLenient();
        if (Intrinsics.areEqual(consumeStringLenient, AbstractJsonLexerKt.NULL) && wasUnquotedString()) {
            fail$default(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        return consumeStringLenient;
    }

    private final boolean wasUnquotedString() {
        return getSource().charAt(this.currentPosition - 1) != '\"';
    }

    public final String consumeStringLenient() {
        String decodedString;
        if (this.peekedString != null) {
            return takePeeked();
        }
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces >= getSource().length() || skipWhitespaces == -1) {
            fail$default(this, "EOF", skipWhitespaces, null, 4, null);
            throw new KotlinNothingValueException();
        }
        byte charToTokenClass = AbstractJsonLexerKt.charToTokenClass(getSource().charAt(skipWhitespaces));
        if (charToTokenClass == 1) {
            return consumeString();
        }
        if (charToTokenClass != 0) {
            fail$default(this, "Expected beginning of the string, but got " + getSource().charAt(skipWhitespaces), 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        boolean z = false;
        while (AbstractJsonLexerKt.charToTokenClass(getSource().charAt(skipWhitespaces)) == 0) {
            skipWhitespaces++;
            if (skipWhitespaces >= getSource().length()) {
                appendRange(this.currentPosition, skipWhitespaces);
                int prefetchOrEof = prefetchOrEof(skipWhitespaces);
                if (prefetchOrEof == -1) {
                    this.currentPosition = skipWhitespaces;
                    return decodedString(0, 0);
                }
                skipWhitespaces = prefetchOrEof;
                z = true;
            }
        }
        int i = this.currentPosition;
        if (!z) {
            decodedString = substring(i, skipWhitespaces);
        } else {
            decodedString = decodedString(i, skipWhitespaces);
        }
        this.currentPosition = skipWhitespaces;
        return decodedString;
    }

    protected void appendRange(int i, int i2) {
        this.escapedString.append(getSource(), i, i2);
    }

    private final int appendEsc(int i) {
        int prefetchOrEof = prefetchOrEof(i);
        if (prefetchOrEof == -1) {
            fail$default(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i2 = prefetchOrEof + 1;
        char charAt = getSource().charAt(prefetchOrEof);
        if (charAt == 'u') {
            return appendHex(getSource(), i2);
        }
        char escapeToChar = AbstractJsonLexerKt.escapeToChar(charAt);
        if (escapeToChar == 0) {
            fail$default(this, "Invalid escaped char '" + charAt + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        this.escapedString.append(escapeToChar);
        return i2;
    }

    private final int appendHex(CharSequence charSequence, int i) {
        int i2 = i + 4;
        if (i2 >= charSequence.length()) {
            this.currentPosition = i;
            ensureHaveChars();
            if (this.currentPosition + 4 >= charSequence.length()) {
                fail$default(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            return appendHex(charSequence, this.currentPosition);
        }
        this.escapedString.append((char) ((fromHexChar(charSequence, i) << 12) + (fromHexChar(charSequence, i + 1) << 8) + (fromHexChar(charSequence, i + 2) << 4) + fromHexChar(charSequence, i + 3)));
        return i2;
    }

    public static /* synthetic */ void require$kotlinx_serialization_json$default(AbstractJsonLexer abstractJsonLexer, boolean z, int i, Function0 message, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: require");
        }
        if ((i2 & 2) != 0) {
            i = abstractJsonLexer.currentPosition;
        }
        int i3 = i;
        Intrinsics.checkNotNullParameter(message, "message");
        if (z) {
            return;
        }
        fail$default(abstractJsonLexer, (String) message.invoke(), i3, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public final void require$kotlinx_serialization_json(boolean z, int i, Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (z) {
            return;
        }
        fail$default(this, message.invoke(), i, null, 4, null);
        throw new KotlinNothingValueException();
    }

    private final int fromHexChar(CharSequence charSequence, int i) {
        char charAt = charSequence.charAt(i);
        if ('0' > charAt || charAt >= ':') {
            if ('a' > charAt || charAt >= 'g') {
                if ('A' > charAt || charAt >= 'G') {
                    fail$default(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                return charAt - '7';
            }
            return charAt - 'W';
        }
        return charAt - '0';
    }

    public final void skipElement(boolean z) {
        AbstractJsonLexer abstractJsonLexer;
        ArrayList arrayList = new ArrayList();
        byte peekNextToken = peekNextToken();
        if (peekNextToken != 8 && peekNextToken != 6) {
            consumeStringLenient();
            return;
        }
        while (true) {
            byte peekNextToken2 = this.peekNextToken();
            if (peekNextToken2 != 1) {
                if (peekNextToken2 == 8 || peekNextToken2 == 6) {
                    abstractJsonLexer = this;
                    arrayList.add(Byte.valueOf(peekNextToken2));
                } else {
                    if (peekNextToken2 == 9) {
                        if (((Number) CollectionsKt.last((List<? extends Object>) arrayList)).byteValue() != 8) {
                            throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found ] instead of } at path: " + this.path, this.getSource());
                        }
                        CollectionsKt.removeLast(arrayList);
                    } else if (peekNextToken2 == 7) {
                        if (((Number) CollectionsKt.last((List<? extends Object>) arrayList)).byteValue() != 6) {
                            throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found } instead of ] at path: " + this.path, this.getSource());
                        }
                        CollectionsKt.removeLast(arrayList);
                    } else if (peekNextToken2 == 10) {
                        fail$default(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    abstractJsonLexer = this;
                }
                abstractJsonLexer.consumeNextToken();
                if (arrayList.size() == 0) {
                    return;
                }
                this = abstractJsonLexer;
            } else if (z) {
                this.consumeStringLenient();
            } else {
                this.consumeKeyString();
            }
        }
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) getSource()) + "', currentPosition=" + this.currentPosition + ')';
    }

    public final void failOnUnknownKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) substring(0, this.currentPosition), key, 0, false, 6, (Object) null);
        throw new JsonDecodingException("Encountered an unknown key '" + key + "' at offset " + lastIndexOf$default + " at path: " + this.path.getPath() + "\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder or '@JsonIgnoreUnknownKeys' annotation to ignore unknown keys.\nJSON input: " + ((Object) JsonExceptionsKt.minify(getSource(), lastIndexOf$default)));
    }

    public static /* synthetic */ Void fail$default(AbstractJsonLexer abstractJsonLexer, String str, int i, String str2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = abstractJsonLexer.currentPosition;
            }
            if ((i2 & 4) != 0) {
                str2 = "";
            }
            return abstractJsonLexer.fail(str, i, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
    }

    public final Void fail(String message, int i, String hint) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(hint, "hint");
        throw JsonExceptionsKt.JsonDecodingException(i, message + " at path: " + this.path.getPath() + (hint.length() == 0 ? "" : "\n" + hint), getSource());
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01ec, code lost:
        fail$default(r18, "Expected numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01fc, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x013b, code lost:
        if (r2 == r1) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x013d, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x013f, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0140, code lost:
        if (r1 == r2) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0142, code lost:
        if (r9 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0146, code lost:
        if (r1 == (r2 - 1)) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0148, code lost:
        if (r0 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x014a, code lost:
        if (r4 == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0154, code lost:
        if (getSource().charAt(r2) != '\"') goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0156, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0159, code lost:
        fail$default(r18, "Expected closing quotation mark", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0169, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x016a, code lost:
        fail$default(r18, "EOF", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x017a, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x017b, code lost:
        r18.currentPosition = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x017f, code lost:
        if (r8 == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0181, code lost:
        r1 = r10 * consumeNumericLiteral$calculateExponent(r12, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x018b, code lost:
        if (r1 > 9.223372036854776E18d) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0191, code lost:
        if (r1 < (-9.223372036854776E18d)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0199, code lost:
        if (java.lang.Math.floor(r1) != r1) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x019b, code lost:
        r10 = (long) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x019d, code lost:
        fail$default(r18, "Can't convert " + r1 + " to Long", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01be, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01bf, code lost:
        fail$default(r18, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01cf, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d0, code lost:
        if (r9 == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d2, code lost:
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d7, code lost:
        if (r10 == Long.MIN_VALUE) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01da, code lost:
        return -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01db, code lost:
        fail$default(r18, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01eb, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long consumeNumericLiteral() {
        boolean z;
        char charAt;
        int prefetchOrEof = prefetchOrEof(skipWhitespaces());
        if (prefetchOrEof >= getSource().length() || prefetchOrEof == -1) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (getSource().charAt(prefetchOrEof) == '\"') {
            prefetchOrEof++;
            if (prefetchOrEof == getSource().length()) {
                fail$default(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            z = true;
        } else {
            z = false;
        }
        int i = prefetchOrEof;
        long j = 0;
        long j2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        loop0: while (true) {
            boolean z4 = false;
            while (i != getSource().length()) {
                charAt = getSource().charAt(i);
                if ((charAt == 'e' || charAt == 'E') && !z2) {
                    if (i == prefetchOrEof) {
                        fail$default(this, "Unexpected symbol " + charAt + " in numeric literal", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    i++;
                    z2 = true;
                } else if (charAt == '-' && z2) {
                    if (i == prefetchOrEof) {
                        fail$default(this, "Unexpected symbol '-' in numeric literal", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    i++;
                } else if (charAt != '+' || !z2) {
                    if (charAt != '-') {
                        if (AbstractJsonLexerKt.charToTokenClass(charAt) != 0) {
                            break loop0;
                        }
                        i++;
                        int i2 = charAt - '0';
                        if (i2 < 0 || i2 >= 10) {
                            break loop0;
                        } else if (z2) {
                            j2 = (j2 * 10) + i2;
                        } else {
                            j = (j * 10) - i2;
                            if (j > 0) {
                                fail$default(this, "Numeric value overflow", 0, null, 6, null);
                                throw new KotlinNothingValueException();
                            }
                        }
                    } else if (i != prefetchOrEof) {
                        fail$default(this, "Unexpected symbol '-' in numeric literal", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    } else {
                        i++;
                        z3 = true;
                    }
                } else if (i == prefetchOrEof) {
                    fail$default(this, "Unexpected symbol '+' in numeric literal", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                } else {
                    i++;
                }
                z4 = true;
            }
            break loop0;
        }
        fail$default(this, "Unexpected symbol '" + charAt + "' in numeric literal", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private static final double consumeNumericLiteral$calculateExponent(long j, boolean z) {
        if (z) {
            if (!z) {
                throw new NoWhenBranchMatchedException();
            }
            return Math.pow(10.0d, j);
        }
        return Math.pow(10.0d, -j);
    }

    public final long consumeNumericLiteralFully() {
        long consumeNumericLiteral = consumeNumericLiteral();
        if (consumeNextToken() != 10) {
            AbstractJsonLexerKt.tokenDescription((byte) 10);
            int i = this.currentPosition;
            int i2 = i - 1;
            fail$default(this, "Expected input to contain a single valid number, but got '" + ((i == getSource().length() || i2 < 0) ? "EOF" : String.valueOf(getSource().charAt(i2))) + "' after it", i2, null, 4, null);
            throw new KotlinNothingValueException();
        }
        return consumeNumericLiteral;
    }

    public final boolean consumeBoolean() {
        return consumeBoolean(skipWhitespaces());
    }

    public final boolean consumeBooleanLenient() {
        boolean z;
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces == getSource().length()) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (getSource().charAt(skipWhitespaces) == '\"') {
            skipWhitespaces++;
            z = true;
        } else {
            z = false;
        }
        boolean consumeBoolean = consumeBoolean(skipWhitespaces);
        if (z) {
            if (this.currentPosition == getSource().length()) {
                fail$default(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            } else if (getSource().charAt(this.currentPosition) != '\"') {
                fail$default(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new KotlinNothingValueException();
            } else {
                this.currentPosition++;
                return consumeBoolean;
            }
        }
        return consumeBoolean;
    }

    private final boolean consumeBoolean(int i) {
        int prefetchOrEof = prefetchOrEof(i);
        if (prefetchOrEof >= getSource().length() || prefetchOrEof == -1) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i2 = prefetchOrEof + 1;
        int charAt = getSource().charAt(prefetchOrEof) | ' ';
        if (charAt == 102) {
            consumeBooleanLiteral("alse", i2);
            return false;
        } else if (charAt == 116) {
            consumeBooleanLiteral("rue", i2);
            return true;
        } else {
            fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    private final void consumeBooleanLiteral(String str, int i) {
        if (getSource().length() - i < str.length()) {
            fail$default(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) != (getSource().charAt(i + i2) | ' ')) {
                fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        this.currentPosition = i + str.length();
    }

    private final <T> T withPositionRollback(Function0<? extends T> function0) {
        int i = this.currentPosition;
        try {
            return function0.invoke();
        } finally {
            this.currentPosition = i;
        }
    }
}
