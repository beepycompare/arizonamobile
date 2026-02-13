package io.appmetrica.analytics.impl;

import android.os.Process;
/* loaded from: classes5.dex */
public final class Gd implements InterfaceC0127al {

    /* renamed from: a  reason: collision with root package name */
    public final int f595a;

    public Gd(int i) {
        this.f595a = i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0127al
    public final boolean a(String str) {
        return this.f595a != Process.myPid();
    }
}
