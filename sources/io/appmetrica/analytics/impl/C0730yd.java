package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.yd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0730yd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bd f1145a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public C0730yd(Bd bd, int i, String str) {
        this.f1145a = bd;
        this.b = i;
        this.c = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Bd.a(this.f1145a).a(new Y9(this.b, this.c));
    }
}
