package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes4.dex */
public final class E2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f399a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ F2 c;

    public E2(F2 f2, Context context, Intent intent) {
        this.c = f2;
        this.f399a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.f421a.consume(this.f399a, this.b);
    }
}
