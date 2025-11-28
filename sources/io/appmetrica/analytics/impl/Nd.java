package io.appmetrica.analytics.impl;

import android.os.Process;
/* loaded from: classes5.dex */
public final class Nd implements InterfaceC0226el {

    /* renamed from: a  reason: collision with root package name */
    public final int f606a;

    public Nd(int i) {
        this.f606a = i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0226el
    public final boolean a(String str) {
        return this.f606a != Process.myPid();
    }
}
