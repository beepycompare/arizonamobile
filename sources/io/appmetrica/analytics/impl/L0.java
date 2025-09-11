package io.appmetrica.analytics.impl;

import android.content.Intent;
/* loaded from: classes4.dex */
public final class L0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f548a;
    public final /* synthetic */ C0547r1 b;

    public L0(C0547r1 c0547r1, Intent intent) {
        this.b = c0547r1;
        this.f548a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Y7 y7 = this.b.d().b;
        Intent intent = this.f548a;
        y7.getClass();
        if (intent != null) {
            y7.a(intent.getDataString(), false);
        }
    }
}
