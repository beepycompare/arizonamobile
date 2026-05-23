package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class D extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0571s f501a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(C0571s c0571s) {
        super(1);
        this.f501a = c0571s;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f501a.j = (byte[]) obj;
        return Unit.INSTANCE;
    }
}
