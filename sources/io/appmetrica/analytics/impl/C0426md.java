package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.md  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0426md extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1120a;

    public C0426md(String str) {
        this.f1120a = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0737z0 c0737z0 = C0135b4.l().p;
        String str = this.f1120a;
        c0737z0.getClass();
        C0712y0.c().a(str);
    }
}
