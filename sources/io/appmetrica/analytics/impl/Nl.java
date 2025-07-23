package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.StartupParamsCallback;
/* loaded from: classes4.dex */
public final class Nl implements V6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StartupParamsCallback f567a;
    public final /* synthetic */ Ol b;

    public Nl(Ol ol, StartupParamsCallback startupParamsCallback) {
        this.b = ol;
        this.f567a = startupParamsCallback;
    }

    @Override // io.appmetrica.analytics.impl.V6
    public final void a(int i, Bundle bundle) {
        this.b.b(bundle, this.f567a);
    }
}
