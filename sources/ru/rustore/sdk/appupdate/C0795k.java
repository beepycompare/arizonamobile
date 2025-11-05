package ru.rustore.sdk.appupdate;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.MetricsEvent;
/* renamed from: ru.rustore.sdk.appupdate.k  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0795k extends Lambda implements Function0<MetricsEvent> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0798n f1444a;
    public final /* synthetic */ C0793i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0795k(C0798n c0798n, C0793i c0793i) {
        super(0);
        this.f1444a = c0798n;
        this.b = c0793i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final MetricsEvent invoke() {
        C0794j c0794j = this.f1444a.f1449a;
        C0793i model = this.b;
        c0794j.getClass();
        Intrinsics.checkNotNullParameter(model, "model");
        return new MetricsEvent(model.f1442a, model.b);
    }
}
