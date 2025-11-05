package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.StartupParamsCallback;
/* loaded from: classes3.dex */
public final class Rl implements H6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StartupParamsCallback f670a;
    public final /* synthetic */ Sl b;

    public Rl(Sl sl, StartupParamsCallback startupParamsCallback) {
        this.b = sl;
        this.f670a = startupParamsCallback;
    }

    @Override // io.appmetrica.analytics.impl.H6
    public final void a(int i, Bundle bundle) {
        this.b.b(bundle, this.f670a);
    }
}
