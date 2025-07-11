package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class B1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f347a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ I1 d;

    public B1(I1 i1, Intent intent, int i, int i2) {
        this.d = i1;
        this.f347a = intent;
        this.b = i;
        this.c = i2;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.d.b.a(this.f347a, this.b, this.c);
    }
}
