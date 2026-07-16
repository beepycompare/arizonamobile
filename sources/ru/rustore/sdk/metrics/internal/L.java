package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.rustore.sdk.metrics.MetricsEvent;
/* loaded from: classes6.dex */
public final class L {

    /* renamed from: a  reason: collision with root package name */
    public final C0844t f1565a;

    public L(C0844t metricsEventSerializer) {
        Intrinsics.checkNotNullParameter(metricsEventSerializer, "metricsEventSerializer");
        this.f1565a = metricsEventSerializer;
    }

    public final J a(D model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String str = model.f1555a;
        C0844t c0844t = this.f1565a;
        MetricsEvent metricsEvent = model.b;
        c0844t.getClass();
        byte[] bytes = C0844t.a(metricsEvent).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return new J(str, bytes);
    }
}
