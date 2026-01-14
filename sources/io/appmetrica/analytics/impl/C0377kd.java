package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.kd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0377kd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0452nd f1082a;
    public final /* synthetic */ boolean b;

    public C0377kd(C0452nd c0452nd, boolean z) {
        this.f1082a = c0452nd;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0452nd.a(this.f1082a).a(this.b, false);
    }
}
