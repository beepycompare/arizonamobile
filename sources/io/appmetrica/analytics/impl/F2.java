package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes5.dex */
public final class F2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f539a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ G2 c;

    public F2(G2 g2, Context context, Intent intent) {
        this.c = g2;
        this.f539a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.f558a.consume(this.f539a, this.b);
    }
}
