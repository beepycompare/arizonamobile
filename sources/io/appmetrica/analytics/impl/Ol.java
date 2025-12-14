package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.StartupParamsCallback;
/* loaded from: classes5.dex */
public final class Ol implements B6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StartupParamsCallback f723a;
    public final /* synthetic */ Pl b;

    public Ol(Pl pl, StartupParamsCallback startupParamsCallback) {
        this.b = pl;
        this.f723a = startupParamsCallback;
    }

    @Override // io.appmetrica.analytics.impl.B6
    public final void a(int i, Bundle bundle) {
        this.b.b(bundle, this.f723a);
    }
}
