package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes5.dex */
public final class Ld extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Nd f645a;
    public final /* synthetic */ String b;
    public final /* synthetic */ byte[] c;

    public Ld(Nd nd, String str, byte[] bArr) {
        this.f645a = nd;
        this.b = str;
        this.c = bArr;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Nd.a(this.f645a).setSessionExtra(this.b, this.c);
    }
}
