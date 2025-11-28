package io.appmetrica.analytics.impl;

import android.content.res.Configuration;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes5.dex */
public final class B1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Configuration f404a;
    public final /* synthetic */ L1 b;

    public B1(L1 l1, Configuration configuration) {
        this.b = l1;
        this.f404a = configuration;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.b.b.onConfigurationChanged(this.f404a);
    }
}
