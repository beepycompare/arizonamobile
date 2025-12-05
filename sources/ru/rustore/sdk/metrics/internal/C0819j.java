package ru.rustore.sdk.metrics.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* renamed from: ru.rustore.sdk.metrics.internal.j  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0819j extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0823n f1587a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0819j(C0823n c0823n) {
        super(1);
        this.f1587a = c0823n;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable th) {
        Throwable it = th;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f1587a.e.a(C0818i.f1586a);
        return Unit.INSTANCE;
    }
}
