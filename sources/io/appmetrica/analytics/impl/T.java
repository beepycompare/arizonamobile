package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class T extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ U f789a;
    public final /* synthetic */ Gi b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T(U u, Gi gi) {
        super(0);
        this.f789a = u;
        this.b = gi;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        U u = this.f789a;
        N n = u.h;
        Context context = u.f805a;
        Gi gi = this.b;
        n.getClass();
        return N.a(new M(n, context, gi));
    }
}
