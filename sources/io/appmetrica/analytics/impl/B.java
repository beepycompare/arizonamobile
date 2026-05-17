package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class B extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0561s f510a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(C0561s c0561s) {
        super(1);
        this.f510a = c0561s;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f510a.g = (byte[]) obj;
        return Unit.INSTANCE;
    }
}
