package io.appmetrica.analytics.impl;

import android.content.Intent;
/* loaded from: classes4.dex */
public final class H0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f461a;
    public final /* synthetic */ C0496p1 b;

    public H0(C0496p1 c0496p1, Intent intent) {
        this.b = c0496p1;
        this.f461a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        U7 u7 = this.b.d().b;
        Intent intent = this.f461a;
        u7.getClass();
        if (intent != null) {
            u7.a(intent.getDataString(), false);
        }
    }
}
