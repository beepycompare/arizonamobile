package io.appmetrica.analytics.impl;

import android.os.Process;
/* renamed from: io.appmetrica.analytics.impl.nb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0447nb implements InterfaceC0149bl {
    @Override // io.appmetrica.analytics.impl.InterfaceC0149bl
    public final boolean a(C0371kb c0371kb) {
        Integer num = c0371kb.f;
        return num == null || num.intValue() != Process.myPid();
    }
}
