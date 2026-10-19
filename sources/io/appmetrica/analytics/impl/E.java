package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class E extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0564s f522a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(C0564s c0564s) {
        super(1);
        this.f522a = c0564s;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f522a.c = (byte[]) obj;
        return Unit.INSTANCE;
    }
}
