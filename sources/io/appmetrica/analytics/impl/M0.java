package io.appmetrica.analytics.impl;

import android.content.Intent;
/* loaded from: classes5.dex */
public final class M0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f688a;
    public final /* synthetic */ C0588t1 b;

    public M0(C0588t1 c0588t1, Intent intent) {
        this.b = c0588t1;
        this.f688a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0719y7 c0719y7 = this.b.d().b;
        Intent intent = this.f688a;
        c0719y7.getClass();
        if (intent != null) {
            c0719y7.a(intent.getDataString(), false);
        }
    }
}
