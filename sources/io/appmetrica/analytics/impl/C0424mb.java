package io.appmetrica.analytics.impl;

import android.os.Process;
/* renamed from: io.appmetrica.analytics.impl.mb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0424mb implements InterfaceC0126al {
    @Override // io.appmetrica.analytics.impl.InterfaceC0126al
    public final boolean a(C0348jb c0348jb) {
        Integer num = c0348jb.f;
        return num == null || num.intValue() != Process.myPid();
    }
}
