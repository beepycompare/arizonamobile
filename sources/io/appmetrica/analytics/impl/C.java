package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class C extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0558s f514a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(C0558s c0558s) {
        super(1);
        this.f514a = c0558s;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f514a.j = (byte[]) obj;
        return Unit.INSTANCE;
    }
}
