package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.jd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0351jd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0452nd f1064a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public C0351jd(C0452nd c0452nd, int i, String str) {
        this.f1064a = c0452nd;
        this.b = i;
        this.c = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0452nd.a(this.f1064a).a(new F9(this.b, this.c));
    }
}
