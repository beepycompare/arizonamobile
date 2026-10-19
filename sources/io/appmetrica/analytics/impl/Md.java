package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes5.dex */
public final class Md extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f668a;

    public Md(String str) {
        this.f668a = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        B0 b0 = C0569s4.l().q;
        String str = this.f668a;
        b0.getClass();
        A0.c().a(str);
    }
}
