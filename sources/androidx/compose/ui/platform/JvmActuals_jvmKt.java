package androidx.compose.ui.platform;

import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
/* compiled from: JvmActuals.jvm.kt */
@Metadata(d1 = {"\u0000$\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0081\b¢\u0006\u0004\b\u0007\u0010\b\u001a\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0000\u001a\f\u0010\r\u001a\u00020\u0003*\u00020\u0003H\u0000*\f\b\u0000\u0010\u000e\"\u00020\u000f2\u00020\u000f¨\u0006\u0010"}, d2 = {"oldSynchronized", "R", "lock", "", "Landroidx/compose/ui/platform/SynchronizedObject;", "block", "Lkotlin/Function0;", "synchronized", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "simpleIdentityToString", "", "obj", "name", "nativeClass", "AtomicInt", "Ljava/util/concurrent/atomic/AtomicInteger;", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class JvmActuals_jvmKt {
    public static /* synthetic */ void AtomicInt$annotations() {
    }

    public static final String simpleIdentityToString(Object obj, String str) {
        if (str == null) {
            if (obj.getClass().isAnonymousClass()) {
                str = obj.getClass().getName();
            } else {
                str = obj.getClass().getSimpleName();
            }
        }
        StringBuilder append = new StringBuilder().append(str).append('@');
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%07x", Arrays.copyOf(new Object[]{Integer.valueOf(System.identityHashCode(obj))}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return append.append(format).toString();
    }

    public static final Object nativeClass(Object obj) {
        return obj.getClass();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "not expected to be referenced directly as the old version had to be inlined")
    /* renamed from: synchronized  reason: not valid java name */
    public static final /* synthetic */ <R> R m5854synchronized(Object obj, Function0<? extends R> function0) {
        R invoke;
        synchronized (obj) {
            invoke = function0.invoke();
        }
        return invoke;
    }
}
