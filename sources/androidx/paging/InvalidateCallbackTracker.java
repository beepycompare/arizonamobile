package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.paging.internal.SynchronizedLock;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InvalidateCallbackTracker.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0013\u001a\u00020\u0014H\u0001¢\u0006\u0002\b\u0015J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\r\u0010\u001c\u001a\u00020\bH\u0000¢\u0006\u0002\b\u001dR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Landroidx/paging/InvalidateCallbackTracker;", ExifInterface.GPS_DIRECTION_TRUE, "", "callbackInvoker", "Lkotlin/Function1;", "", "invalidGetter", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "lock", "Landroidx/paging/internal/SynchronizedLock;", "callbacks", "", "value", "invalid", "getInvalid$paging_common", "()Z", "callbackCount", "", "callbackCount$paging_common", "registerInvalidatedCallback", "callback", "registerInvalidatedCallback$paging_common", "(Ljava/lang/Object;)V", "unregisterInvalidatedCallback", "unregisterInvalidatedCallback$paging_common", "invalidate", "invalidate$paging_common", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InvalidateCallbackTracker<T> {
    private final Function1<T, Unit> callbackInvoker;
    private final List<T> callbacks;
    private boolean invalid;
    private final Function0<Boolean> invalidGetter;
    private final SynchronizedLock lock;

    /* JADX WARN: Multi-variable type inference failed */
    public InvalidateCallbackTracker(Function1<? super T, Unit> callbackInvoker, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(callbackInvoker, "callbackInvoker");
        this.callbackInvoker = callbackInvoker;
        this.invalidGetter = function0;
        this.lock = new SynchronizedLock();
        this.callbacks = new ArrayList();
    }

    public /* synthetic */ InvalidateCallbackTracker(Function1 function1, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? null : function0);
    }

    public final boolean getInvalid$paging_common() {
        return this.invalid;
    }

    public final int callbackCount$paging_common() {
        return this.callbacks.size();
    }

    public final void registerInvalidatedCallback$paging_common(T t) {
        Function0<Boolean> function0 = this.invalidGetter;
        boolean z = true;
        if (function0 != null && function0.invoke().booleanValue()) {
            invalidate$paging_common();
        }
        if (this.invalid) {
            this.callbackInvoker.invoke(t);
            return;
        }
        synchronized (this.lock) {
            if (!this.invalid) {
                this.callbacks.add(t);
                z = false;
            }
        }
        if (z) {
            this.callbackInvoker.invoke(t);
        }
    }

    public final void unregisterInvalidatedCallback$paging_common(T t) {
        synchronized (this.lock) {
            this.callbacks.remove(t);
        }
    }

    public final boolean invalidate$paging_common() {
        if (this.invalid) {
            return false;
        }
        synchronized (this.lock) {
            if (this.invalid) {
                return false;
            }
            this.invalid = true;
            List<T> list = CollectionsKt.toList(this.callbacks);
            this.callbacks.clear();
            Function1<T, Unit> function1 = this.callbackInvoker;
            for (T t : list) {
                function1.invoke(t);
            }
            return true;
        }
    }
}
