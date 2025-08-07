package ru.rustore.sdk.metrics.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* renamed from: ru.rustore.sdk.metrics.internal.j  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0830j extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0834n f1439a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0830j(C0834n c0834n) {
        super(1);
        this.f1439a = c0834n;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable th) {
        Throwable it = th;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f1439a.e.a(C0829i.f1438a);
        return Unit.INSTANCE;
    }
}
