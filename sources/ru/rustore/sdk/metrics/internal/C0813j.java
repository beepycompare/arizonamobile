package ru.rustore.sdk.metrics.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* renamed from: ru.rustore.sdk.metrics.internal.j  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0813j extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0817n f1545a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0813j(C0817n c0817n) {
        super(1);
        this.f1545a = c0817n;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable th) {
        Throwable it = th;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f1545a.e.a(C0812i.f1544a);
        return Unit.INSTANCE;
    }
}
