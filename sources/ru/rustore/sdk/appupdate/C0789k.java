package ru.rustore.sdk.appupdate;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.MetricsEvent;
/* renamed from: ru.rustore.sdk.appupdate.k  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0789k extends Lambda implements Function0<MetricsEvent> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0792n f1487a;
    public final /* synthetic */ C0787i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0789k(C0792n c0792n, C0787i c0787i) {
        super(0);
        this.f1487a = c0792n;
        this.b = c0787i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final MetricsEvent invoke() {
        C0788j c0788j = this.f1487a.f1492a;
        C0787i model = this.b;
        c0788j.getClass();
        Intrinsics.checkNotNullParameter(model, "model");
        return new MetricsEvent(model.f1485a, model.b);
    }
}
