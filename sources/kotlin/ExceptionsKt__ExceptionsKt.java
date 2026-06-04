package kotlin;

import com.facebook.internal.NativeProtocol;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Exceptions.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0087\u0088\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0087\u0088\u0004b\u0002\b\u0003\u001a\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u001a(\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0087\u0080\u0004b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016b\u0002\b\u0017\"%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u00028FX\u0086\u0084\b¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"3\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019*\u00020\u00028FX\u0087\u0084\br\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¢\u0006\f\u0012\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"printStackTrace", "", "", "Lkotlin/internal/InlineOnly;", "writer", "Ljava/io/PrintWriter;", "stream", "Ljava/io/PrintStream;", "stackTrace", "", "Ljava/lang/StackTraceElement;", "getStackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "stackTraceToString", "", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.4", "addSuppressed", "exception", "1.1", "Lkotlin/internal/HidesMembers;", "suppressedExceptions", "", "getSuppressedExceptions$annotations", "getSuppressedExceptions", "(Ljava/lang/Throwable;)Ljava/util/List;", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/ExceptionsKt")
/* loaded from: classes5.dex */
public class ExceptionsKt__ExceptionsKt {
    public static /* synthetic */ void getStackTrace$annotations(Throwable th) {
    }

    public static /* synthetic */ void getSuppressedExceptions$annotations(Throwable th) {
    }

    private static final void printStackTrace(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        th.printStackTrace();
    }

    private static final void printStackTrace(Throwable th, PrintWriter writer) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Intrinsics.checkNotNullParameter(writer, "writer");
        th.printStackTrace(writer);
    }

    private static final void printStackTrace(Throwable th, PrintStream stream) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Intrinsics.checkNotNullParameter(stream, "stream");
        th.printStackTrace(stream);
    }

    public static final StackTraceElement[] getStackTrace(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.checkNotNull(stackTrace);
        return stackTrace;
    }

    public static final String stackTraceToString(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "toString(...)");
        return stringWriter2;
    }

    public static final void addSuppressed(Throwable th, Throwable exception) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (th != exception) {
            PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(th, exception);
        }
    }

    public static final List<Throwable> getSuppressedExceptions(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getSuppressed(th);
    }
}
