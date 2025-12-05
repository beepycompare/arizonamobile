package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CompositionLocal.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/CompositionLocalContext;", "", "compositionLocals", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "<init>", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "getCompositionLocals$runtime", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "equals", "", "other", "hashCode", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositionLocalContext {
    public static final int $stable = 0;
    private final PersistentCompositionLocalMap compositionLocals;

    public CompositionLocalContext(PersistentCompositionLocalMap persistentCompositionLocalMap) {
        this.compositionLocals = persistentCompositionLocalMap;
    }

    public final PersistentCompositionLocalMap getCompositionLocals$runtime() {
        return this.compositionLocals;
    }

    public boolean equals(Object obj) {
        return (obj instanceof CompositionLocalContext) && Intrinsics.areEqual(((CompositionLocalContext) obj).compositionLocals, this.compositionLocals);
    }

    public int hashCode() {
        return this.compositionLocals.hashCode();
    }
}
