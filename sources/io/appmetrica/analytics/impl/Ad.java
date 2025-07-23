package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class Ad extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Dd f337a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public Ad(Dd dd, int i, String str) {
        this.f337a = dd;
        this.b = i;
        this.c = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Dd.a(this.f337a).a(new C0126aa(this.b, this.c));
    }
}
