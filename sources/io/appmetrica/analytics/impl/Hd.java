package io.appmetrica.analytics.impl;

import android.os.Process;
/* loaded from: classes5.dex */
public final class Hd implements InterfaceC0148bl {

    /* renamed from: a  reason: collision with root package name */
    public final int f603a;

    public Hd(int i) {
        this.f603a = i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0148bl
    public final boolean a(String str) {
        return this.f603a != Process.myPid();
    }
}
