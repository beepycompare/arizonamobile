package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
/* renamed from: io.appmetrica.analytics.impl.a4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0121a4 extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final C0461nf f761a;

    public C0121a4(C0461nf c0461nf) {
        super(c0461nf.e(), "[ClientApiTrackingStatusToggle]");
        this.f761a = c0461nf;
    }

    public final void a(boolean z) {
        updateState(z);
        this.f761a.f(z);
    }
}
