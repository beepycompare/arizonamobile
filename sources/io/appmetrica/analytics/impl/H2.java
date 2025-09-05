package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes4.dex */
public final class H2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f465a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ I2 c;

    public H2(I2 i2, Context context, Intent intent) {
        this.c = i2;
        this.f465a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.f482a.consume(this.f465a, this.b);
    }
}
