package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.StartupParamsCallback;
/* loaded from: classes5.dex */
public final class Nl implements A6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StartupParamsCallback f714a;
    public final /* synthetic */ Ol b;

    public Nl(Ol ol, StartupParamsCallback startupParamsCallback) {
        this.b = ol;
        this.f714a = startupParamsCallback;
    }

    @Override // io.appmetrica.analytics.impl.A6
    public final void a(int i, Bundle bundle) {
        this.b.b(bundle, this.f714a);
    }
}
