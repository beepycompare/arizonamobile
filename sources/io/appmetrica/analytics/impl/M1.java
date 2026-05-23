package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes5.dex */
public final class M1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bundle f655a;
    public final /* synthetic */ N1 b;

    public M1(N1 n1, Bundle bundle) {
        this.b = n1;
        this.f655a = bundle;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.b.b.pauseUserSession(this.f655a);
    }
}
