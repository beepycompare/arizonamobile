package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
/* renamed from: io.appmetrica.analytics.impl.s2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0565s2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1216a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ C0590t2 c;

    public RunnableC0565s2(C0590t2 c0590t2, Context context, Intent intent) {
        this.c = c0590t2;
        this.f1216a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.f1230a.consume(this.f1216a, this.b);
    }
}
