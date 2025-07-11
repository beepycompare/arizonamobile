package kotlinx.datetime.internal.format.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.UtilKt;
/* compiled from: ParserOperation.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lkotlinx/datetime/internal/format/parser/PlainStringParserOperation;", "Output", "Lkotlinx/datetime/internal/format/parser/ParserOperation;", TypedValues.Custom.S_STRING, "", "<init>", "(Ljava/lang/String;)V", "getString", "()Ljava/lang/String;", "consume", "Lkotlinx/datetime/internal/format/parser/ParseResult;", "storage", "input", "", "startIndex", "", "consume-FANa98k", "(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;", "toString", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PlainStringParserOperation<Output> implements ParserOperation<Output> {
    private final String string;

    public PlainStringParserOperation(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.string = string;
        if (string.length() <= 0) {
            throw new IllegalArgumentException("Empty string is not allowed".toString());
        }
        if (UtilKt.isAsciiDigit(string.charAt(0))) {
            throw new IllegalArgumentException(("String '" + string + "' starts with a digit").toString());
        }
        if (UtilKt.isAsciiDigit(string.charAt(string.length() - 1))) {
            throw new IllegalArgumentException(("String '" + string + "' ends with a digit").toString());
        }
    }

    public final String getString() {
        return this.string;
    }

    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    /* renamed from: consume-FANa98k */
    public Object mo10120consumeFANa98k(Output output, final CharSequence input, final int i) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (this.string.length() + i > input.length()) {
            return ParseResult.Companion.m10130ErrorRg3Co2E(i, new Function0() { // from class: kotlinx.datetime.internal.format.parser.PlainStringParserOperation$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String consume_FANa98k$lambda$3;
                    consume_FANa98k$lambda$3 = PlainStringParserOperation.consume_FANa98k$lambda$3(PlainStringParserOperation.this);
                    return consume_FANa98k$lambda$3;
                }
            });
        }
        int length = this.string.length();
        for (final int i2 = 0; i2 < length; i2++) {
            if (input.charAt(i + i2) != this.string.charAt(i2)) {
                return ParseResult.Companion.m10130ErrorRg3Co2E(i, new Function0() { // from class: kotlinx.datetime.internal.format.parser.PlainStringParserOperation$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        String consume_FANa98k$lambda$4;
                        consume_FANa98k$lambda$4 = PlainStringParserOperation.consume_FANa98k$lambda$4(PlainStringParserOperation.this, input, i, i2);
                        return consume_FANa98k$lambda$4;
                    }
                });
            }
        }
        return ParseResult.Companion.m10131OkQi1bsqg(i + this.string.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String consume_FANa98k$lambda$3(PlainStringParserOperation plainStringParserOperation) {
        return "Unexpected end of input: yet to parse '" + plainStringParserOperation.string + '\'';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String consume_FANa98k$lambda$4(PlainStringParserOperation plainStringParserOperation, CharSequence charSequence, int i, int i2) {
        return "Expected " + plainStringParserOperation.string + " but got " + charSequence.subSequence(i, i2 + i + 1).toString();
    }

    public String toString() {
        return "'" + this.string + '\'';
    }
}
