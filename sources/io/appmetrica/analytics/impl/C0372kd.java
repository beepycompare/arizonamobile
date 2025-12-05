package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.kd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0372kd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0473od f1059a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public C0372kd(C0473od c0473od, int i, String str) {
        this.f1059a = c0473od;
        this.b = i;
        this.c = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0473od.a(this.f1059a).a(new G9(this.b, this.c));
    }
}
