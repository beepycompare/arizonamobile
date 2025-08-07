package io.appmetrica.analytics.impl;

import android.os.Process;
/* loaded from: classes4.dex */
public final class Vd implements InterfaceC0138al {

    /* renamed from: a  reason: collision with root package name */
    public final int f685a;

    public Vd(int i) {
        this.f685a = i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0138al
    public final boolean a(String str) {
        return this.f685a != Process.myPid();
    }
}
