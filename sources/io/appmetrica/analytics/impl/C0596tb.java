package io.appmetrica.analytics.impl;

import android.os.Process;
/* renamed from: io.appmetrica.analytics.impl.tb  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0596tb implements InterfaceC0226el {
    @Override // io.appmetrica.analytics.impl.InterfaceC0226el
    public final boolean a(C0522qb c0522qb) {
        Integer num = c0522qb.f;
        return num == null || num.intValue() != Process.myPid();
    }
}
