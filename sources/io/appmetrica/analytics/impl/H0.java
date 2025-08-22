package io.appmetrica.analytics.impl;

import android.content.Intent;
/* loaded from: classes4.dex */
public final class H0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f466a;
    public final /* synthetic */ C0494p1 b;

    public H0(C0494p1 c0494p1, Intent intent) {
        this.b = c0494p1;
        this.f466a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        V7 v7 = this.b.d().b;
        Intent intent = this.f466a;
        v7.getClass();
        if (intent != null) {
            v7.a(intent.getDataString(), false);
        }
    }
}
