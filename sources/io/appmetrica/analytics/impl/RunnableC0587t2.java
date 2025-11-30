package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
/* renamed from: io.appmetrica.analytics.impl.t2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0587t2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1127a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ C0612u2 c;

    public RunnableC0587t2(C0612u2 c0612u2, Context context, Intent intent) {
        this.c = c0612u2;
        this.f1127a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.f1142a.consume(this.f1127a, this.b);
    }
}
