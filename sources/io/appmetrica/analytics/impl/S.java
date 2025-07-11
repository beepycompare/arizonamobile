package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class S extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ T f617a;
    public final /* synthetic */ Qi b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(T t, Qi qi) {
        super(0);
        this.f617a = t;
        this.b = qi;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        T t = this.f617a;
        M m = t.h;
        Context context = t.f632a;
        Qi qi = this.b;
        m.getClass();
        return M.a(new L(m, context, qi));
    }
}
