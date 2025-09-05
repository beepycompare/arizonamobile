package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.oh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0488oh implements C6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1017a;
    public final C0750z4 b;
    public final IHandlerExecutor c = Na.j().w().e();

    public C0488oh(Context context, C0750z4 c0750z4) {
        this.f1017a = context;
        this.b = c0750z4;
    }

    public final void a(C0477o6 c0477o6, Bundle bundle) {
        if (c0477o6.m()) {
            return;
        }
        this.c.execute(new Hh(this.f1017a, c0477o6, bundle, this.b));
    }

    public final void a(C0475o4 c0475o4, C0477o6 c0477o6, N4 n4) {
        this.b.a(c0475o4, n4).a(c0477o6, n4);
        this.b.a(c0475o4.b, c0475o4.c, c0475o4.d);
    }
}
