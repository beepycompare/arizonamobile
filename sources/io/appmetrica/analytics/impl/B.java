package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class B extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0569s f467a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(C0569s c0569s) {
        super(1);
        this.f467a = c0569s;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f467a.f = (byte[]) obj;
        return Unit.INSTANCE;
    }
}
