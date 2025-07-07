package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class A extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f326a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(r rVar) {
        super(1);
        this.f326a = rVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f326a.g = (byte[]) obj;
        return Unit.INSTANCE;
    }
}
