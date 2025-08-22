package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.StartupParamsCallback;
/* loaded from: classes4.dex */
public final class Sl implements W6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StartupParamsCallback f651a;
    public final /* synthetic */ Tl b;

    public Sl(Tl tl, StartupParamsCallback startupParamsCallback) {
        this.b = tl;
        this.f651a = startupParamsCallback;
    }

    @Override // io.appmetrica.analytics.impl.W6
    public final void a(int i, Bundle bundle) {
        this.b.b(bundle, this.f651a);
    }
}
