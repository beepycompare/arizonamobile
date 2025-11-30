package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.nd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0449nd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1028a;

    public C0449nd(String str) {
        this.f1028a = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0735z0 c0735z0 = C0158c4.l().p;
        String str = this.f1028a;
        c0735z0.getClass();
        C0710y0.c().a(str);
    }
}
