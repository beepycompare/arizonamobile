package io.appmetrica.analytics.impl;

import android.os.Process;
/* loaded from: classes4.dex */
public final class Hb implements InterfaceC0138al {
    @Override // io.appmetrica.analytics.impl.InterfaceC0138al
    public final boolean a(Eb eb) {
        Integer num = eb.f;
        return num == null || num.intValue() != Process.myPid();
    }
}
