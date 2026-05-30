package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes5.dex */
public final class K1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f622a;
    public final /* synthetic */ Bundle b;
    public final /* synthetic */ N1 c;

    public K1(N1 n1, int i, Bundle bundle) {
        this.c = n1;
        this.f622a = i;
        this.b = bundle;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.c.b.reportData(this.f622a, this.b);
    }
}
