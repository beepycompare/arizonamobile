package io.appmetrica.analytics.impl;

import android.os.Process;
/* loaded from: classes4.dex */
public final class Fb implements Xk {
    @Override // io.appmetrica.analytics.impl.Xk
    public final boolean a(Cb cb) {
        Integer num = cb.f;
        return num == null || num.intValue() != Process.myPid();
    }
}
