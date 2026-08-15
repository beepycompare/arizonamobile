package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.StartupParamsCallback;
/* renamed from: io.appmetrica.analytics.impl.pm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0516pm implements S6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StartupParamsCallback f1153a;
    public final /* synthetic */ C0542qm b;

    public C0516pm(C0542qm c0542qm, StartupParamsCallback startupParamsCallback) {
        this.b = c0542qm;
        this.f1153a = startupParamsCallback;
    }

    @Override // io.appmetrica.analytics.impl.S6
    public final void a(int i, Bundle bundle) {
        this.b.b(bundle, this.f1153a);
    }
}
