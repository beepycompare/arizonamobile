package io.appmetrica.analytics.impl;

import android.os.Process;
/* loaded from: classes4.dex */
public final class Td implements Xk {

    /* renamed from: a  reason: collision with root package name */
    public final int f640a;

    public Td(int i) {
        this.f640a = i;
    }

    @Override // io.appmetrica.analytics.impl.Xk
    public final boolean a(String str) {
        return this.f640a != Process.myPid();
    }
}
