package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class T extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ W f770a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T(W w) {
        super(0);
        this.f770a = w;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        W w = this.f770a;
        K k = w.f;
        Context context = w.f817a;
        k.getClass();
        return K.a(new I(k, context));
    }
}
