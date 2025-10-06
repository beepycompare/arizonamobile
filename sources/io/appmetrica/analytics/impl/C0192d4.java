package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
/* renamed from: io.appmetrica.analytics.impl.d4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0192d4 extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final C0612tf f837a;

    public C0192d4(C0612tf c0612tf) {
        super(c0612tf.e(), "[ClientApiTrackingStatusToggle]");
        this.f837a = c0612tf;
    }

    public final void a(boolean z) {
        updateState(z);
        this.f837a.f(z);
    }
}
