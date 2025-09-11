package ru.rustore.sdk.metrics.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* renamed from: ru.rustore.sdk.metrics.internal.l  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0833l extends Lambda implements Function1<Unit, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0835n f1460a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0833l(C0835n c0835n) {
        super(1);
        this.f1460a = c0835n;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Unit unit) {
        Unit it = unit;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f1460a.e.a(C0832k.f1459a);
        return Unit.INSTANCE;
    }
}
