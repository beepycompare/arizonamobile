package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.z1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0745z1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I1 f1161a;

    public C0745z1(I1 i1) {
        this.f1161a = i1;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        synchronized (this.f1161a) {
            I1 i1 = this.f1161a;
            if (i1.c) {
                i1.b.onCreate();
            }
        }
    }
}
