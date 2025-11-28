package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes5.dex */
public final class D1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f434a;
    public final /* synthetic */ int b;
    public final /* synthetic */ L1 c;

    public D1(L1 l1, Intent intent, int i) {
        this.c = l1;
        this.f434a = intent;
        this.b = i;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.c.b.a(this.f434a, this.b);
    }
}
