package ru.rustore.sdk.metrics.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* renamed from: ru.rustore.sdk.metrics.internal.j  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0832j extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0836n f1459a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0832j(C0836n c0836n) {
        super(1);
        this.f1459a = c0836n;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable th) {
        Throwable it = th;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f1459a.e.a(C0831i.f1458a);
        return Unit.INSTANCE;
    }
}
