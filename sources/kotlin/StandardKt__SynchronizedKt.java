package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Synchronized.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0087\u0088\bb\u0002\b\u0007b\u0002\b\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"synchronized", "R", "lock", "", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/internal/InlineOnly;", "Lkotlin/IgnorableReturnValue;", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/StandardKt")
/* loaded from: classes5.dex */
class StandardKt__SynchronizedKt extends StandardKt__StandardKt {
    @IgnorableReturnValue
    /* renamed from: synchronized  reason: not valid java name */
    private static final <R> R m9925synchronized(Object lock, Function0<? extends R> block) {
        R invoke;
        Intrinsics.checkNotNullParameter(lock, "lock");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (lock) {
            invoke = block.invoke();
        }
        return invoke;
    }
}
