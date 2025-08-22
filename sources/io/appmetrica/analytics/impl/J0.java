package io.appmetrica.analytics.impl;

import android.content.Intent;
/* loaded from: classes4.dex */
public final class J0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f505a;
    public final /* synthetic */ C0494p1 b;

    public J0(C0494p1 c0494p1, Intent intent) {
        this.b = c0494p1;
        this.f505a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        V7 v7 = this.b.d().b;
        Intent intent = this.f505a;
        v7.getClass();
        if (intent != null) {
            v7.a(intent.getDataString(), false);
        }
    }
}
