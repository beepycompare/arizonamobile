package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
/* loaded from: classes5.dex */
public final class V3 extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final C0762zf f808a;

    public V3(C0762zf c0762zf) {
        super(c0762zf.e(), "[ClientApiTrackingStatusToggle]");
        this.f808a = c0762zf;
    }

    public final void a(boolean z) {
        updateState(z);
        this.f808a.f(z);
    }
}
