package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.jd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0350jd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0451nd f1068a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public C0350jd(C0451nd c0451nd, int i, String str) {
        this.f1068a = c0451nd;
        this.b = i;
        this.c = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0451nd.a(this.f1068a).a(new F9(this.b, this.c));
    }
}
