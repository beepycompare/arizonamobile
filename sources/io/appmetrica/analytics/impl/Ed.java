package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class Ed extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Fd f412a;
    public final /* synthetic */ String b;
    public final /* synthetic */ byte[] c;

    public Ed(Fd fd, String str, byte[] bArr) {
        this.f412a = fd;
        this.b = str;
        this.c = bArr;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Fd.a(this.f412a).setSessionExtra(this.b, this.c);
    }
}
