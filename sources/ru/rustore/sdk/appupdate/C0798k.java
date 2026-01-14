package ru.rustore.sdk.appupdate;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.MetricsEvent;
/* renamed from: ru.rustore.sdk.appupdate.k  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0798k extends Lambda implements Function0<MetricsEvent> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0801n f1553a;
    public final /* synthetic */ C0796i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0798k(C0801n c0801n, C0796i c0796i) {
        super(0);
        this.f1553a = c0801n;
        this.b = c0796i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final MetricsEvent invoke() {
        C0797j c0797j = this.f1553a.f1558a;
        C0796i model = this.b;
        c0797j.getClass();
        Intrinsics.checkNotNullParameter(model, "model");
        return new MetricsEvent(model.f1551a, model.b);
    }
}
