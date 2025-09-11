package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class S extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ T f660a;
    public final /* synthetic */ InterfaceC0180cj b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(T t, InterfaceC0180cj interfaceC0180cj) {
        super(0);
        this.f660a = t;
        this.b = interfaceC0180cj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        T t = this.f660a;
        M m = t.h;
        Context context = t.f676a;
        InterfaceC0180cj interfaceC0180cj = this.b;
        m.getClass();
        return M.a(new L(m, context, interfaceC0180cj));
    }
}
