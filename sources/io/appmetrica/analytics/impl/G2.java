package io.appmetrica.analytics.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.BiConsumer;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* loaded from: classes5.dex */
public final class G2 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final BiConsumer f555a;
    public final ICommonExecutor b;

    public G2(C0110a3 c0110a3, ICommonExecutor iCommonExecutor) {
        this.f555a = c0110a3;
        this.b = iCommonExecutor;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.b.execute(new F2(this, context, intent));
    }
}
