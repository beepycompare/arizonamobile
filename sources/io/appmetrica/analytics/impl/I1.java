package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes5.dex */
public final class I1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f586a;
    public final /* synthetic */ N1 b;

    public I1(N1 n1, Intent intent) {
        this.b = n1;
        this.f586a = intent;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.b.b.c(this.f586a);
    }
}
