package ru.rustore.sdk.metrics.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* renamed from: ru.rustore.sdk.metrics.internal.l  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0817l extends Lambda implements Function1<Unit, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0819n f1547a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0817l(C0819n c0819n) {
        super(1);
        this.f1547a = c0819n;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Unit unit) {
        Unit it = unit;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f1547a.e.a(C0816k.f1546a);
        return Unit.INSTANCE;
    }
}
