package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.StartupParamsCallback;
/* renamed from: io.appmetrica.analytics.impl.pm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0510pm implements S6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StartupParamsCallback f1156a;
    public final /* synthetic */ C0536qm b;

    public C0510pm(C0536qm c0536qm, StartupParamsCallback startupParamsCallback) {
        this.b = c0536qm;
        this.f1156a = startupParamsCallback;
    }

    @Override // io.appmetrica.analytics.impl.S6
    public final void a(int i, Bundle bundle) {
        this.b.b(bundle, this.f1156a);
    }
}
