package com.arkivanov.decompose;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Relay.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\u001a\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/arkivanov/decompose/Relay;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "lock", "Lcom/arkivanov/decompose/Lock;", "queue", "Lkotlin/collections/ArrayDeque;", "isDraining", "", "observers", "", "Lkotlin/Function1;", "", "accept", "value", "(Ljava/lang/Object;)V", "drainLoop", "subscribe", "Lcom/arkivanov/decompose/Cancellation;", "observer", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Relay<T> {
    private boolean isDraining;
    private final Lock lock = new Lock();
    private final ArrayDeque<T> queue = new ArrayDeque<>();
    private Set<? extends Function1<? super T, Unit>> observers = SetsKt.emptySet();

    public final void accept(T t) {
        synchronized (this.lock) {
            this.queue.addLast(t);
            if (this.isDraining) {
                return;
            }
            this.isDraining = true;
            Unit unit = Unit.INSTANCE;
            drainLoop();
        }
    }

    private final void drainLoop() {
        T removeFirst;
        Set<? extends Function1<? super T, Unit>> set;
        while (true) {
            synchronized (this.lock) {
                if (this.queue.isEmpty()) {
                    this.isDraining = false;
                    return;
                }
                removeFirst = this.queue.removeFirst();
                set = this.observers;
                Unit unit = Unit.INSTANCE;
            }
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(removeFirst);
            }
        }
    }

    public final Cancellation subscribe(final Function1<? super T, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        synchronized (this.lock) {
            this.observers = SetsKt.plus(this.observers, observer);
            Unit unit = Unit.INSTANCE;
        }
        return new Cancellation() { // from class: com.arkivanov.decompose.Relay$$ExternalSyntheticLambda0
            @Override // com.arkivanov.decompose.Cancellation
            public final void cancel() {
                Relay.subscribe$lambda$5(Relay.this, observer);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void subscribe$lambda$5(Relay relay, Function1 function1) {
        synchronized (relay.lock) {
            relay.observers = SetsKt.minus(relay.observers, function1);
            Unit unit = Unit.INSTANCE;
        }
    }
}
