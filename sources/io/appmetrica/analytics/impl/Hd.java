package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class Hd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Jd f477a;
    public final /* synthetic */ String b;
    public final /* synthetic */ byte[] c;

    public Hd(Jd jd, String str, byte[] bArr) {
        this.f477a = jd;
        this.b = str;
        this.c = bArr;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Jd.a(this.f477a).setSessionExtra(this.b, this.c);
    }
}
