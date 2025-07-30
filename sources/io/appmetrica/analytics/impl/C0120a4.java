package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
/* renamed from: io.appmetrica.analytics.impl.a4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0120a4 extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final C0460nf f762a;

    public C0120a4(C0460nf c0460nf) {
        super(c0460nf.e(), "[ClientApiTrackingStatusToggle]");
        this.f762a = c0460nf;
    }

    public final void a(boolean z) {
        updateState(z);
        this.f762a.f(z);
    }
}
