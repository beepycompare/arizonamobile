package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.md  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0427md extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1116a;

    public C0427md(String str) {
        this.f1116a = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0738z0 c0738z0 = C0136b4.l().p;
        String str = this.f1116a;
        c0738z0.getClass();
        C0713y0.c().a(str);
    }
}
