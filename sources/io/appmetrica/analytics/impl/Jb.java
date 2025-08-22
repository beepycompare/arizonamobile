package io.appmetrica.analytics.impl;

import android.os.Process;
/* loaded from: classes4.dex */
public final class Jb implements InterfaceC0259fl {
    @Override // io.appmetrica.analytics.impl.InterfaceC0259fl
    public final boolean a(Gb gb) {
        Integer num = gb.f;
        return num == null || num.intValue() != Process.myPid();
    }
}
