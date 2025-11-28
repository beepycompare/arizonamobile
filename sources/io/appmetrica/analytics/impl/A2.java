package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes5.dex */
public final class A2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f388a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ B2 c;

    public A2(B2 b2, Context context, Intent intent) {
        this.c = b2;
        this.f388a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.f405a.consume(this.f388a, this.b);
    }
}
