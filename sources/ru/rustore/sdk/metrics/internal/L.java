package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.rustore.sdk.metrics.MetricsEvent;
/* loaded from: classes6.dex */
public final class L {

    /* renamed from: a  reason: collision with root package name */
    public final C0828t f1576a;

    public L(C0828t metricsEventSerializer) {
        Intrinsics.checkNotNullParameter(metricsEventSerializer, "metricsEventSerializer");
        this.f1576a = metricsEventSerializer;
    }

    public final J a(D model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String str = model.f1566a;
        C0828t c0828t = this.f1576a;
        MetricsEvent metricsEvent = model.b;
        c0828t.getClass();
        byte[] bytes = C0828t.a(metricsEvent).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return new J(str, bytes);
    }
}
