package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class S extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ T f642a;
    public final /* synthetic */ Yi b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(T t, Yi yi) {
        super(0);
        this.f642a = t;
        this.b = yi;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        T t = this.f642a;
        M m = t.h;
        Context context = t.f653a;
        Yi yi = this.b;
        m.getClass();
        return M.a(new L(m, context, yi));
    }
}
