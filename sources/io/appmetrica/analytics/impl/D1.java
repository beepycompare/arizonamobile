package io.appmetrica.analytics.impl;

import android.content.res.Configuration;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes5.dex */
public final class D1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Configuration f506a;
    public final /* synthetic */ N1 b;

    public D1(N1 n1, Configuration configuration) {
        this.b = n1;
        this.f506a = configuration;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.b.b.onConfigurationChanged(this.f506a);
    }
}
