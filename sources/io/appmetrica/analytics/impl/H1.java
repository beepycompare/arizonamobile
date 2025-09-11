package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class H1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f468a;
    public final /* synthetic */ Bundle b;
    public final /* synthetic */ K1 c;

    public H1(K1 k1, int i, Bundle bundle) {
        this.c = k1;
        this.f468a = i;
        this.b = bundle;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.c.b.reportData(this.f468a, this.b);
    }
}
