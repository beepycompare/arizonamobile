package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class T extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ U f684a;
    public final /* synthetic */ Hi b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T(U u, Hi hi) {
        super(0);
        this.f684a = u;
        this.b = hi;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        U u = this.f684a;
        N n = u.h;
        Context context = u.f700a;
        Hi hi = this.b;
        n.getClass();
        return N.a(new M(n, context, hi));
    }
}
