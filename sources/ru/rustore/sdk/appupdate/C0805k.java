package ru.rustore.sdk.appupdate;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.MetricsEvent;
/* renamed from: ru.rustore.sdk.appupdate.k  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0805k extends Lambda implements Function0<MetricsEvent> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0808n f1381a;
    public final /* synthetic */ C0803i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0805k(C0808n c0808n, C0803i c0803i) {
        super(0);
        this.f1381a = c0808n;
        this.b = c0803i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final MetricsEvent invoke() {
        C0804j c0804j = this.f1381a.f1386a;
        C0803i model = this.b;
        c0804j.getClass();
        Intrinsics.checkNotNullParameter(model, "model");
        return new MetricsEvent(model.f1379a, model.b);
    }
}
