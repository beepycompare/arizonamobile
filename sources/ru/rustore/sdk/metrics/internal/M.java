package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.MetricsEvent;
/* loaded from: classes6.dex */
public final class M extends Lambda implements Function0<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MetricsEvent f1586a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(MetricsEvent metricsEvent) {
        super(0);
        this.f1586a = metricsEvent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return "Insert new event with name: " + this.f1586a.getEventName();
    }
}
