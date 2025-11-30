package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.kd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0373kd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0474od f976a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public C0373kd(C0474od c0474od, int i, String str) {
        this.f976a = c0474od;
        this.b = i;
        this.c = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0474od.a(this.f976a).a(new G9(this.b, this.c));
    }
}
