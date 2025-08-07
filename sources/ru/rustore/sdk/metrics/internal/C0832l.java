package ru.rustore.sdk.metrics.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* renamed from: ru.rustore.sdk.metrics.internal.l  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0832l extends Lambda implements Function1<Unit, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0834n f1441a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0832l(C0834n c0834n) {
        super(1);
        this.f1441a = c0834n;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Unit unit) {
        Unit it = unit;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f1441a.e.a(C0831k.f1440a);
        return Unit.INSTANCE;
    }
}
