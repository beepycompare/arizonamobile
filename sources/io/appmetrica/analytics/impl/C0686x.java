package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.x  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0686x extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0561s f1299a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0686x(C0561s c0561s) {
        super(1);
        this.f1299a = c0561s;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f1299a.e = (byte[]) obj;
        return Unit.INSTANCE;
    }
}
