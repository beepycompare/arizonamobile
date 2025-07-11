package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.zd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0755zd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bd f1165a;
    public final /* synthetic */ boolean b;

    public C0755zd(Bd bd, boolean z) {
        this.f1165a = bd;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Bd.a(this.f1165a).b(this.b);
    }
}
