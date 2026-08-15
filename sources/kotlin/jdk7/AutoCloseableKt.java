package kotlin.jdk7;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import kotlin.ExceptionsKt;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AutoCloseableJVM.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\u0000\u001a\u00060\u0001j\u0002`\u00052\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0087\u0088\u0004b\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004b\u0002\b\tø\u0001\u0000\u001ae\u0010\n\u001a\u0002H\u000b\"\u0010\b\u0000\u0010\f*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0005\"\u0004\b\u0001\u0010\u000b*\u0002H\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0087\u0088\bb\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0010b\u0002\b\tb\u0002\b\u0011ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000f\u001a2\u0010\u0012\u001a\u00020\b*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0081\u0080\u0004b\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0010b\u0002\b\u0015*\u001a\b\u0007\u0010\u0000\"\u00020\u00012\u00020\u0001B\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"AutoCloseable", "Ljava/lang/AutoCloseable;", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "2.0", "Lkotlin/AutoCloseable;", "closeAction", "Lkotlin/Function0;", "", "Lkotlin/internal/InlineOnly;", "use", "R", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "(Ljava/lang/AutoCloseable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "1.2", "Lkotlin/IgnorableReturnValue;", "closeFinally", "cause", "", "Lkotlin/PublishedApi;", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, pn = "kotlin", xi = 48)
/* loaded from: classes5.dex */
public final class AutoCloseableKt {
    public static /* synthetic */ void AutoCloseable$annotations() {
    }

    private static final AutoCloseable AutoCloseable(final Function0<Unit> closeAction) {
        Intrinsics.checkNotNullParameter(closeAction, "closeAction");
        return new AutoCloseable() { // from class: kotlin.jdk7.AutoCloseableKt$AutoCloseable$1
            @Override // java.lang.AutoCloseable
            public final void close() {
                closeAction.invoke();
            }
        };
    }

    @IgnorableReturnValue
    private static final <T extends AutoCloseable, R> R use(T t, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            R invoke = block.invoke(t);
            closeFinally(t, null);
            return invoke;
        } finally {
        }
    }

    public static final void closeFinally(AutoCloseable autoCloseable, Throwable th) {
        if (autoCloseable != null) {
            if (th == null) {
                UByte$$ExternalSyntheticBackport0.m9989m((Object) autoCloseable);
                return;
            }
            try {
                UByte$$ExternalSyntheticBackport0.m9989m((Object) autoCloseable);
            } catch (Throwable th2) {
                ExceptionsKt.addSuppressed(th, th2);
            }
        }
    }
}
