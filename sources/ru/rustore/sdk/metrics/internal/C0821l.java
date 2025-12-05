package ru.rustore.sdk.metrics.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* renamed from: ru.rustore.sdk.metrics.internal.l  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0821l extends Lambda implements Function1<Unit, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0823n f1589a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0821l(C0823n c0823n) {
        super(1);
        this.f1589a = c0823n;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Unit unit) {
        Unit it = unit;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f1589a.e.a(C0820k.f1588a);
        return Unit.INSTANCE;
    }
}
