package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.oh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0489oh implements C6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1022a;
    public final C0751z4 b;
    public final IHandlerExecutor c = Na.j().w().e();

    public C0489oh(Context context, C0751z4 c0751z4) {
        this.f1022a = context;
        this.b = c0751z4;
    }

    public final void a(C0478o6 c0478o6, Bundle bundle) {
        if (c0478o6.m()) {
            return;
        }
        this.c.execute(new Hh(this.f1022a, c0478o6, bundle, this.b));
    }

    public final void a(C0476o4 c0476o4, C0478o6 c0478o6, N4 n4) {
        this.b.a(c0476o4, n4).a(c0478o6, n4);
        this.b.a(c0476o4.b, c0476o4.c, c0476o4.d);
    }
}
