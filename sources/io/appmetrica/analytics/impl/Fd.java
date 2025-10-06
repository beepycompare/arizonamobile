package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class Fd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Jd f445a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public Fd(Jd jd, int i, String str) {
        this.f445a = jd;
        this.b = i;
        this.c = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Jd.a(this.f445a).a(new C0249fa(this.b, this.c));
    }
}
