package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.StartupParamsCallback;
/* renamed from: io.appmetrica.analytics.impl.pm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0515pm implements S6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StartupParamsCallback f1153a;
    public final /* synthetic */ C0541qm b;

    public C0515pm(C0541qm c0541qm, StartupParamsCallback startupParamsCallback) {
        this.b = c0541qm;
        this.f1153a = startupParamsCallback;
    }

    @Override // io.appmetrica.analytics.impl.S6
    public final void a(int i, Bundle bundle) {
        this.b.b(bundle, this.f1153a);
    }
}
