package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class Cd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Fd f380a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public Cd(Fd fd, int i, String str) {
        this.f380a = fd;
        this.b = i;
        this.c = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Fd.a(this.f380a).a(new C0171ca(this.b, this.c));
    }
}
