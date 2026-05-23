package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes5.dex */
public final class F1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f535a;
    public final /* synthetic */ int b;
    public final /* synthetic */ N1 c;

    public F1(N1 n1, Intent intent, int i) {
        this.c = n1;
        this.f535a = intent;
        this.b = i;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.c.b.a(this.f535a, this.b);
    }
}
