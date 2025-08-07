package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class Cd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Dd f376a;
    public final /* synthetic */ String b;
    public final /* synthetic */ byte[] c;

    public Cd(Dd dd, String str, byte[] bArr) {
        this.f376a = dd;
        this.b = str;
        this.c = bArr;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Dd.a(this.f376a).setSessionExtra(this.b, this.c);
    }
}
