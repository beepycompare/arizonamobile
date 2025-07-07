package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
/* renamed from: io.appmetrica.analytics.impl.a4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0128a4 extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final C0416lf f750a;

    public C0128a4(C0416lf c0416lf) {
        super(c0416lf.e(), "[ClientApiTrackingStatusToggle]");
        this.f750a = c0416lf;
    }

    public final void a(boolean z) {
        updateState(z);
        this.f750a.f(z);
    }
}
