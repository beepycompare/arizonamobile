package io.appmetrica.analytics.impl;

import android.content.Intent;
/* loaded from: classes4.dex */
public final class H0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f451a;
    public final /* synthetic */ C0502p1 b;

    public H0(C0502p1 c0502p1, Intent intent) {
        this.b = c0502p1;
        this.f451a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        R7 r7 = this.b.d().b;
        Intent intent = this.f451a;
        r7.getClass();
        if (intent != null) {
            r7.a(intent.getDataString(), false);
        }
    }
}
