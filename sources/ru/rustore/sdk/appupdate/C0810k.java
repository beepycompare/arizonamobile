package ru.rustore.sdk.appupdate;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.MetricsEvent;
/* renamed from: ru.rustore.sdk.appupdate.k  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0810k extends Lambda implements Function0<MetricsEvent> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0813n f1530a;
    public final /* synthetic */ C0808i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0810k(C0813n c0813n, C0808i c0808i) {
        super(0);
        this.f1530a = c0813n;
        this.b = c0808i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final MetricsEvent invoke() {
        C0809j c0809j = this.f1530a.f1535a;
        C0808i model = this.b;
        c0809j.getClass();
        Intrinsics.checkNotNullParameter(model, "model");
        return new MetricsEvent(model.f1528a, model.b);
    }
}
