package io.appmetrica.analytics.impl;

import android.os.Process;
/* loaded from: classes5.dex */
public final class Hd implements InterfaceC0149bl {

    /* renamed from: a  reason: collision with root package name */
    public final int f506a;

    public Hd(int i) {
        this.f506a = i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0149bl
    public final boolean a(String str) {
        return this.f506a != Process.myPid();
    }
}
