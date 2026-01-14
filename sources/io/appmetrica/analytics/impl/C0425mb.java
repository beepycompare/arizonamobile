package io.appmetrica.analytics.impl;

import android.os.Process;
/* renamed from: io.appmetrica.analytics.impl.mb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0425mb implements InterfaceC0127al {
    @Override // io.appmetrica.analytics.impl.InterfaceC0127al
    public final boolean a(C0349jb c0349jb) {
        Integer num = c0349jb.f;
        return num == null || num.intValue() != Process.myPid();
    }
}
