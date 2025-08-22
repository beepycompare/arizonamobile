package io.appmetrica.analytics.impl;

import android.os.Process;
/* loaded from: classes4.dex */
public final class Xd implements InterfaceC0259fl {

    /* renamed from: a  reason: collision with root package name */
    public final int f726a;

    public Xd(int i) {
        this.f726a = i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0259fl
    public final boolean a(String str) {
        return this.f726a != Process.myPid();
    }
}
