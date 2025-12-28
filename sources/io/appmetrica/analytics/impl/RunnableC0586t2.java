package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
/* renamed from: io.appmetrica.analytics.impl.t2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0586t2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1225a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ C0611u2 c;

    public RunnableC0586t2(C0611u2 c0611u2, Context context, Intent intent) {
        this.c = c0611u2;
        this.f1225a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.f1240a.consume(this.f1225a, this.b);
    }
}
