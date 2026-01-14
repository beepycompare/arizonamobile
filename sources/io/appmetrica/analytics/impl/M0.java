package io.appmetrica.analytics.impl;

import android.content.Intent;
/* loaded from: classes5.dex */
public final class M0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f684a;
    public final /* synthetic */ C0589t1 b;

    public M0(C0589t1 c0589t1, Intent intent) {
        this.b = c0589t1;
        this.f684a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0720y7 c0720y7 = this.b.d().b;
        Intent intent = this.f684a;
        c0720y7.getClass();
        if (intent != null) {
            c0720y7.a(intent.getDataString(), false);
        }
    }
}
