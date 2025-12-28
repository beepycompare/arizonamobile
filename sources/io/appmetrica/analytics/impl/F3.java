package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
/* loaded from: classes5.dex */
public final class F3 extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final C0116af f570a;

    public F3(C0116af c0116af) {
        super(c0116af.e(), "[ClientApiTrackingStatusToggle]");
        this.f570a = c0116af;
    }

    public final void a(boolean z) {
        updateState(z);
        this.f570a.f(z);
    }
}
