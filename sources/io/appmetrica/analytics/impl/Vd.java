package io.appmetrica.analytics.impl;

import android.os.Process;
/* loaded from: classes4.dex */
public final class Vd implements InterfaceC0137al {

    /* renamed from: a  reason: collision with root package name */
    public final int f686a;

    public Vd(int i) {
        this.f686a = i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0137al
    public final boolean a(String str) {
        return this.f686a != Process.myPid();
    }
}
