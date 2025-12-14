package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.nd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0448nd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1125a;

    public C0448nd(String str) {
        this.f1125a = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0734z0 c0734z0 = C0157c4.l().p;
        String str = this.f1125a;
        c0734z0.getClass();
        C0709y0.c().a(str);
    }
}
