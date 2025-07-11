package io.appmetrica.analytics.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.BiConsumer;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* loaded from: classes4.dex */
public final class F2 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final BiConsumer f421a;
    public final ICommonExecutor b;

    public F2(C0119a3 c0119a3, ICommonExecutor iCommonExecutor) {
        this.f421a = c0119a3;
        this.b = iCommonExecutor;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.b.execute(new E2(this, context, intent));
    }
}
