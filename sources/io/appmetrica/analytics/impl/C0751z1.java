package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.z1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0751z1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I1 f1154a;

    public C0751z1(I1 i1) {
        this.f1154a = i1;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        synchronized (this.f1154a) {
            I1 i1 = this.f1154a;
            if (i1.c) {
                i1.b.onCreate();
            }
        }
    }
}
