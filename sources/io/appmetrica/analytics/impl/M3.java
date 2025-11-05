package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
/* loaded from: classes3.dex */
public final class M3 extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final C0220ef f585a;

    public M3(C0220ef c0220ef) {
        super(c0220ef.e(), "[ClientApiTrackingStatusToggle]");
        this.f585a = c0220ef;
    }

    public final void a(boolean z) {
        updateState(z);
        this.f585a.f(z);
    }
}
