package ru.rustore.sdk.appupdate;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.MetricsEvent;
/* renamed from: ru.rustore.sdk.appupdate.k  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0797k extends Lambda implements Function0<MetricsEvent> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0800n f1557a;
    public final /* synthetic */ C0795i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0797k(C0800n c0800n, C0795i c0795i) {
        super(0);
        this.f1557a = c0800n;
        this.b = c0795i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final MetricsEvent invoke() {
        C0796j c0796j = this.f1557a.f1562a;
        C0795i model = this.b;
        c0796j.getClass();
        Intrinsics.checkNotNullParameter(model, "model");
        return new MetricsEvent(model.f1555a, model.b);
    }
}
