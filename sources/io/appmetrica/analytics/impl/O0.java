package io.appmetrica.analytics.impl;

import android.content.Intent;
/* loaded from: classes5.dex */
public final class O0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f613a;
    public final /* synthetic */ C0611u1 b;

    public O0(C0611u1 c0611u1, Intent intent) {
        this.b = c0611u1;
        this.f613a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0742z7 c0742z7 = this.b.d().b;
        Intent intent = this.f613a;
        c0742z7.getClass();
        if (intent != null) {
            c0742z7.a(intent.getDataString(), false);
        }
    }
}
