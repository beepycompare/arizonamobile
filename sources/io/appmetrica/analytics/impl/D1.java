package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class D1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f401a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ K1 d;

    public D1(K1 k1, Intent intent, int i, int i2) {
        this.d = k1;
        this.f401a = intent;
        this.b = i;
        this.c = i2;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.d.b.a(this.f401a, this.b, this.c);
    }
}
