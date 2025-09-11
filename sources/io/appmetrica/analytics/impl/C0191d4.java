package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
/* renamed from: io.appmetrica.analytics.impl.d4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0191d4 extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final C0611tf f836a;

    public C0191d4(C0611tf c0611tf) {
        super(c0611tf.e(), "[ClientApiTrackingStatusToggle]");
        this.f836a = c0611tf;
    }

    public final void a(boolean z) {
        updateState(z);
        this.f836a.f(z);
    }
}
