package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.StartupParamsCallback;
/* loaded from: classes4.dex */
public final class Kl implements S6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StartupParamsCallback f509a;
    public final /* synthetic */ Ll b;

    public Kl(Ll ll, StartupParamsCallback startupParamsCallback) {
        this.b = ll;
        this.f509a = startupParamsCallback;
    }

    @Override // io.appmetrica.analytics.impl.S6
    public final void a(int i, Bundle bundle) {
        this.b.b(bundle, this.f509a);
    }
}
