package io.appmetrica.analytics.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.BiConsumer;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* loaded from: classes5.dex */
public final class B2 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final BiConsumer f405a;
    public final ICommonExecutor b;

    public B2(V2 v2, ICommonExecutor iCommonExecutor) {
        this.f405a = v2;
        this.b = iCommonExecutor;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.b.execute(new A2(this, context, intent));
    }
}
