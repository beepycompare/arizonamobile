package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.StartupParamsCallback;
/* loaded from: classes4.dex */
public final class Wl implements Z6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StartupParamsCallback f726a;
    public final /* synthetic */ Xl b;

    public Wl(Xl xl, StartupParamsCallback startupParamsCallback) {
        this.b = xl;
        this.f726a = startupParamsCallback;
    }

    @Override // io.appmetrica.analytics.impl.Z6
    public final void a(int i, Bundle bundle) {
        this.b.b(bundle, this.f726a);
    }
}
