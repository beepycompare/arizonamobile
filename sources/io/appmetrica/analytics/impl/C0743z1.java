package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.z1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0743z1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I1 f1155a;

    public C0743z1(I1 i1) {
        this.f1155a = i1;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        synchronized (this.f1155a) {
            I1 i1 = this.f1155a;
            if (i1.c) {
                i1.b.onCreate();
            }
        }
    }
}
