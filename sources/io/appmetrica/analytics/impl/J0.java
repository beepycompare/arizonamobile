package io.appmetrica.analytics.impl;

import android.content.Intent;
/* loaded from: classes4.dex */
public final class J0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f506a;
    public final /* synthetic */ C0548r1 b;

    public J0(C0548r1 c0548r1, Intent intent) {
        this.b = c0548r1;
        this.f506a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Y7 y7 = this.b.d().b;
        Intent intent = this.f506a;
        y7.getClass();
        if (intent != null) {
            y7.a(intent.getDataString(), false);
        }
    }
}
