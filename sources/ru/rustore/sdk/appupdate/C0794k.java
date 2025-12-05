package ru.rustore.sdk.appupdate;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.MetricsEvent;
/* renamed from: ru.rustore.sdk.appupdate.k  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0794k extends Lambda implements Function0<MetricsEvent> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0797n f1529a;
    public final /* synthetic */ C0792i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0794k(C0797n c0797n, C0792i c0792i) {
        super(0);
        this.f1529a = c0797n;
        this.b = c0792i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final MetricsEvent invoke() {
        C0793j c0793j = this.f1529a.f1534a;
        C0792i model = this.b;
        c0793j.getClass();
        Intrinsics.checkNotNullParameter(model, "model");
        return new MetricsEvent(model.f1527a, model.b);
    }
}
