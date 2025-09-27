package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class B1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ K1 f360a;

    public B1(K1 k1) {
        this.f360a = k1;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        synchronized (this.f360a) {
            K1 k1 = this.f360a;
            if (k1.c) {
                k1.b.onCreate();
            }
        }
    }
}
