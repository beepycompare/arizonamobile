package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class V extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ W f802a;
    public final /* synthetic */ InterfaceC0150bj b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(W w, C0439mo c0439mo) {
        super(0);
        this.f802a = w;
        this.b = c0439mo;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        W w = this.f802a;
        K k = w.h;
        Context context = w.f817a;
        InterfaceC0150bj interfaceC0150bj = this.b;
        k.getClass();
        return K.a(new J(k, context, interfaceC0150bj));
    }
}
