package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class C1 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f380a;
    public final /* synthetic */ int b;
    public final /* synthetic */ K1 c;

    public C1(K1 k1, Intent intent, int i) {
        this.c = k1;
        this.f380a = intent;
        this.b = i;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.c.b.a(this.f380a, this.b);
    }
}
