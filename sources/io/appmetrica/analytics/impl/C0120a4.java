package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
/* renamed from: io.appmetrica.analytics.impl.a4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0120a4 extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final C0408lf f751a;

    public C0120a4(C0408lf c0408lf) {
        super(c0408lf.e(), "[ClientApiTrackingStatusToggle]");
        this.f751a = c0408lf;
    }

    public final void a(boolean z) {
        updateState(z);
        this.f751a.f(z);
    }
}
