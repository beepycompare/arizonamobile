package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.StartupParamsCallback;
/* renamed from: io.appmetrica.analytics.impl.pm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0517pm implements S6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StartupParamsCallback f1150a;
    public final /* synthetic */ C0543qm b;

    public C0517pm(C0543qm c0543qm, StartupParamsCallback startupParamsCallback) {
        this.b = c0543qm;
        this.f1150a = startupParamsCallback;
    }

    @Override // io.appmetrica.analytics.impl.S6
    public final void a(int i, Bundle bundle) {
        this.b.b(bundle, this.f1150a);
    }
}
