package ru.rustore.sdk.metrics.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* renamed from: ru.rustore.sdk.metrics.internal.j  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0831j extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0835n f1454a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0831j(C0835n c0835n) {
        super(1);
        this.f1454a = c0835n;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable th) {
        Throwable it = th;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f1454a.e.a(C0830i.f1453a);
        return Unit.INSTANCE;
    }
}
