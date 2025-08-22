package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
/* renamed from: io.appmetrica.analytics.impl.a4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0113a4 extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final C0508pf f770a;

    public C0113a4(C0508pf c0508pf) {
        super(c0508pf.e(), "[ClientApiTrackingStatusToggle]");
        this.f770a = c0508pf;
    }

    public final void a(boolean z) {
        updateState(z);
        this.f770a.f(z);
    }
}
