package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class T9 implements Hg {

    /* renamed from: a  reason: collision with root package name */
    public final Hg f774a;
    public final ICommonExecutor b;

    public T9(Hg hg, ICommonExecutor iCommonExecutor) {
        this.f774a = hg;
        this.b = iCommonExecutor;
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final String a() {
        return this.f774a.a();
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final void a(final Dg dg) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.T9$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                T9.a(T9.this, dg);
            }
        });
    }

    public static final void a(final T9 t9, final Dg dg) {
        final Thread currentThread = Thread.currentThread();
        t9.f774a.a(new Dg() { // from class: io.appmetrica.analytics.impl.T9$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.Dg
            public final void a(Lg lg) {
                T9.a(currentThread, dg, t9, lg);
            }
        });
    }

    public static final void a(Thread thread, final Dg dg, T9 t9, final Lg lg) {
        if (Intrinsics.areEqual(Thread.currentThread(), thread)) {
            dg.a(lg);
        } else {
            t9.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.T9$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    T9.a(Dg.this, lg);
                }
            });
        }
    }

    public static final void a(Dg dg, Lg lg) {
        dg.a(lg);
    }
}
