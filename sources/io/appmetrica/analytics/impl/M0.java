package io.appmetrica.analytics.impl;

import android.content.Intent;
/* loaded from: classes5.dex */
public final class M0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f578a;
    public final /* synthetic */ C0611u1 b;

    public M0(C0611u1 c0611u1, Intent intent) {
        this.b = c0611u1;
        this.f578a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0742z7 c0742z7 = this.b.d().b;
        Intent intent = this.f578a;
        c0742z7.getClass();
        if (intent != null) {
            c0742z7.a(intent.getDataString(), false);
        }
    }
}
