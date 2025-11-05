package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes3.dex */
public final class I1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f517a;
    public final /* synthetic */ Bundle b;
    public final /* synthetic */ L1 c;

    public I1(L1 l1, int i, Bundle bundle) {
        this.c = l1;
        this.f517a = i;
        this.b = bundle;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.c.b.reportData(this.f517a, this.b);
    }
}
