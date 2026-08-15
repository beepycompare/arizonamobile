package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes5.dex */
public final class Jd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Nd f613a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public Jd(Nd nd, int i, String str) {
        this.f613a = nd;
        this.b = i;
        this.c = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Nd.a(this.f613a).a(new C0116aa(this.b, this.c));
    }
}
