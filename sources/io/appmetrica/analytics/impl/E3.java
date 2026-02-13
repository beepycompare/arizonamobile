package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
/* loaded from: classes5.dex */
public final class E3 extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final Ze f560a;

    public E3(Ze ze) {
        super(ze.e(), "[ClientApiTrackingStatusToggle]");
        this.f560a = ze;
    }

    public final void a(boolean z) {
        updateState(z);
        this.f560a.f(z);
    }
}
