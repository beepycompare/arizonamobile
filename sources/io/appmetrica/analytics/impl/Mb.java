package io.appmetrica.analytics.impl;

import android.os.Process;
/* loaded from: classes4.dex */
public final class Mb implements InterfaceC0363jl {
    @Override // io.appmetrica.analytics.impl.InterfaceC0363jl
    public final boolean a(Jb jb) {
        Integer num = jb.f;
        return num == null || num.intValue() != Process.myPid();
    }
}
