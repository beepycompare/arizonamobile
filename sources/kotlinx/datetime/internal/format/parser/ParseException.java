package kotlinx.datetime.internal.format.parser;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Parser.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/datetime/internal/format/parser/ParseException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errors", "", "Lkotlinx/datetime/internal/format/parser/ParseError;", "<init>", "(Ljava/util/List;)V", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ParseException extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ParseException(List<ParseError> errors) {
        super(r2);
        String formatError;
        Intrinsics.checkNotNullParameter(errors, "errors");
        formatError = ParserKt.formatError(errors);
    }
}
