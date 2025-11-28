package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.x  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0684x extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0559s f1195a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0684x(C0559s c0559s) {
        super(1);
        this.f1195a = c0559s;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f1195a.e = (byte[]) obj;
        return Unit.INSTANCE;
    }
}
