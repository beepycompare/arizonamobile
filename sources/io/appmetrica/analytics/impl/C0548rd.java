package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.rd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0548rd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0623ud f1093a;
    public final /* synthetic */ boolean b;

    public C0548rd(C0623ud c0623ud, boolean z) {
        this.f1093a = c0623ud;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0623ud.a(this.f1093a).a(this.b, false);
    }
}
