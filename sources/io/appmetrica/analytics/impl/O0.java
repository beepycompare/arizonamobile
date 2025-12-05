package io.appmetrica.analytics.impl;

import android.content.Intent;
/* loaded from: classes5.dex */
public final class O0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f696a;
    public final /* synthetic */ C0610u1 b;

    public O0(C0610u1 c0610u1, Intent intent) {
        this.b = c0610u1;
        this.f696a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0741z7 c0741z7 = this.b.d().b;
        Intent intent = this.f696a;
        c0741z7.getClass();
        if (intent != null) {
            c0741z7.a(intent.getDataString(), false);
        }
    }
}
