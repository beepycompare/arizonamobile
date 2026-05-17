package io.appmetrica.analytics.impl;

import android.os.Process;
/* loaded from: classes5.dex */
public final class Gd implements InterfaceC0126al {

    /* renamed from: a  reason: collision with root package name */
    public final int f600a;

    public Gd(int i) {
        this.f600a = i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0126al
    public final boolean a(String str) {
        return this.f600a != Process.myPid();
    }
}
