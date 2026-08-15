package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
/* loaded from: classes5.dex */
public final class V3 extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final C0768zf f805a;

    public V3(C0768zf c0768zf) {
        super(c0768zf.e(), "[ClientApiTrackingStatusToggle]");
        this.f805a = c0768zf;
    }

    public final void a(boolean z) {
        updateState(z);
        this.f805a.f(z);
    }
}
