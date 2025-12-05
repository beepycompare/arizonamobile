package io.appmetrica.analytics.impl;

import android.os.Process;
/* renamed from: io.appmetrica.analytics.impl.nb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0446nb implements InterfaceC0148bl {
    @Override // io.appmetrica.analytics.impl.InterfaceC0148bl
    public final boolean a(C0370kb c0370kb) {
        Integer num = c0370kb.f;
        return num == null || num.intValue() != Process.myPid();
    }
}
