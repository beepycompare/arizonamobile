package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes3.dex */
public final class B extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0559s f403a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(C0559s c0559s) {
        super(1);
        this.f403a = c0559s;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f403a.g = (byte[]) obj;
        return Unit.INSTANCE;
    }
}
