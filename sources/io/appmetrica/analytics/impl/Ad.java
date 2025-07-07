package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class Ad extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bd f334a;
    public final /* synthetic */ String b;
    public final /* synthetic */ byte[] c;

    public Ad(Bd bd, String str, byte[] bArr) {
        this.f334a = bd;
        this.b = str;
        this.c = bArr;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Bd.a(this.f334a).setSessionExtra(this.b, this.c);
    }
}
