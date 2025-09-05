package ru.rustore.sdk.appupdate;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.MetricsEvent;
/* renamed from: ru.rustore.sdk.appupdate.k  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0806k extends Lambda implements Function0<MetricsEvent> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0809n f1396a;
    public final /* synthetic */ C0804i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0806k(C0809n c0809n, C0804i c0804i) {
        super(0);
        this.f1396a = c0809n;
        this.b = c0804i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final MetricsEvent invoke() {
        C0805j c0805j = this.f1396a.f1401a;
        C0804i model = this.b;
        c0805j.getClass();
        Intrinsics.checkNotNullParameter(model, "model");
        return new MetricsEvent(model.f1394a, model.b);
    }
}
