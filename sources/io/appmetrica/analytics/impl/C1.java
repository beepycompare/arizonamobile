package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes3.dex */
public final class C1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L1 f418a;

    public C1(L1 l1) {
        this.f418a = l1;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        synchronized (this.f418a) {
            L1 l1 = this.f418a;
            if (l1.c) {
                l1.b.onCreate();
            }
        }
    }
}
