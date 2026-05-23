package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes5.dex */
public final class E1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ N1 f518a;

    public E1(N1 n1) {
        this.f518a = n1;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        synchronized (this.f518a) {
            N1 n1 = this.f518a;
            if (n1.c) {
                n1.b.onCreate();
            }
        }
    }
}
