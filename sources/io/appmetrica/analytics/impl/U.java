package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class U extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ W f785a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U(W w) {
        super(0);
        this.f785a = w;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        W w = this.f785a;
        K k = w.g;
        Context context = w.f817a;
        k.getClass();
        return K.a(new I(k, context));
    }
}
