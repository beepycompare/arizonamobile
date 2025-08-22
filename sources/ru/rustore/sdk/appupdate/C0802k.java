package ru.rustore.sdk.appupdate;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.MetricsEvent;
/* renamed from: ru.rustore.sdk.appupdate.k  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0802k extends Lambda implements Function0<MetricsEvent> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0805n f1391a;
    public final /* synthetic */ C0800i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0802k(C0805n c0805n, C0800i c0800i) {
        super(0);
        this.f1391a = c0805n;
        this.b = c0800i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final MetricsEvent invoke() {
        C0801j c0801j = this.f1391a.f1396a;
        C0800i model = this.b;
        c0801j.getClass();
        Intrinsics.checkNotNullParameter(model, "model");
        return new MetricsEvent(model.f1389a, model.b);
    }
}
