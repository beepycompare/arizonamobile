package io.appmetrica.analytics.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.BiConsumer;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.t2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0589t2 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final BiConsumer f1234a;
    public final ICommonExecutor b;

    public C0589t2(N2 n2, ICommonExecutor iCommonExecutor) {
        this.f1234a = n2;
        this.b = iCommonExecutor;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.b.execute(new RunnableC0564s2(this, context, intent));
    }
}
