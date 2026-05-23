package io.appmetrica.analytics.impl;

import android.os.Process;
/* loaded from: classes5.dex */
public final class Ob implements Fl {
    @Override // io.appmetrica.analytics.impl.Fl
    public final boolean a(Lb lb) {
        Integer num = lb.f;
        return num == null || num.intValue() != Process.myPid();
    }
}
