package io.appmetrica.analytics.impl;

import android.content.Intent;
/* loaded from: classes5.dex */
public final class Q0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f722a;
    public final /* synthetic */ C0651v1 b;

    public Q0(C0651v1 c0651v1, Intent intent) {
        this.b = c0651v1;
        this.f722a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Q7 q7 = this.b.c().b;
        Intent intent = this.f722a;
        q7.getClass();
        if (intent != null) {
            q7.a(intent.getDataString(), false);
        }
    }
}
