package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.y  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0727y extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0571s f1282a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0727y(C0571s c0571s) {
        super(1);
        this.f1282a = c0571s;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f1282a.e = (byte[]) obj;
        return Unit.INSTANCE;
    }
}
