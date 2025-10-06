package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class S extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ T f661a;
    public final /* synthetic */ InterfaceC0181cj b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(T t, InterfaceC0181cj interfaceC0181cj) {
        super(0);
        this.f661a = t;
        this.b = interfaceC0181cj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        T t = this.f661a;
        M m = t.h;
        Context context = t.f677a;
        InterfaceC0181cj interfaceC0181cj = this.b;
        m.getClass();
        return M.a(new L(m, context, interfaceC0181cj));
    }
}
