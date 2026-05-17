package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
/* renamed from: io.appmetrica.analytics.impl.s2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0564s2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1220a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ C0589t2 c;

    public RunnableC0564s2(C0589t2 c0589t2, Context context, Intent intent) {
        this.c = c0589t2;
        this.f1220a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.f1234a.consume(this.f1220a, this.b);
    }
}
