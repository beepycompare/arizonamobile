package io.appmetrica.analytics.impl;

import android.content.Intent;
/* loaded from: classes5.dex */
public final class M0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f583a;
    public final /* synthetic */ C0561s1 b;

    public M0(C0561s1 c0561s1, Intent intent) {
        this.b = c0561s1;
        this.f583a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        G7 g7 = this.b.d().b;
        Intent intent = this.f583a;
        g7.getClass();
        if (intent != null) {
            g7.a(intent.getDataString(), false);
        }
    }
}
