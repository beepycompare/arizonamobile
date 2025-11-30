package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
/* loaded from: classes5.dex */
public final class F3 extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final C0117af f472a;

    public F3(C0117af c0117af) {
        super(c0117af.e(), "[ClientApiTrackingStatusToggle]");
        this.f472a = c0117af;
    }

    public final void a(boolean z) {
        updateState(z);
        this.f472a.f(z);
    }
}
