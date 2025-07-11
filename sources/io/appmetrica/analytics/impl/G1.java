package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class G1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bundle f435a;
    public final /* synthetic */ I1 b;

    public G1(I1 i1, Bundle bundle) {
        this.b = i1;
        this.f435a = bundle;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.b.b.resumeUserSession(this.f435a);
    }
}
