package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class F1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f420a;
    public final /* synthetic */ Bundle b;
    public final /* synthetic */ I1 c;

    public F1(I1 i1, int i, Bundle bundle) {
        this.c = i1;
        this.f420a = i;
        this.b = bundle;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.c.b.reportData(this.f420a, this.b);
    }
}
