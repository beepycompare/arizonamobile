package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class Q extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ T f587a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(T t) {
        super(0);
        this.f587a = t;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        T t = this.f587a;
        M m = t.g;
        Context context = t.f632a;
        m.getClass();
        return M.a(new K(m, context));
    }
}
