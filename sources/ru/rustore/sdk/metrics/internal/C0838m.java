package ru.rustore.sdk.metrics.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.MetricsEvent;
import ru.rustore.sdk.reactive.core.Dispatchers;
import ru.rustore.sdk.reactive.single.Single;
import ru.rustore.sdk.reactive.single.SingleSubscribeKt;
import ru.rustore.sdk.reactive.single.SingleSubscribeOnKt;
/* renamed from: ru.rustore.sdk.metrics.internal.m  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0838m extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0839n f1593a;
    public final /* synthetic */ MetricsEvent b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0838m(C0839n c0839n, MetricsEvent metricsEvent) {
        super(0);
        this.f1593a = c0839n;
        this.b = metricsEvent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        C0839n c0839n = this.f1593a;
        if (!c0839n.f) {
            SingleSubscribeKt.subscribe(SingleSubscribeOnKt.subscribeOn(Single.Companion.from(new C0833h(c0839n)), Dispatchers.INSTANCE.getIo()), new C0835j(c0839n), new C0837l(c0839n));
            c0839n.c.a();
            c0839n.f = true;
        }
        C0828c c0828c = this.f1593a.b;
        MetricsEvent metricsEvent = this.b;
        c0828c.getClass();
        Intrinsics.checkNotNullParameter(metricsEvent, "metricsEvent");
        N n = c0828c.f1582a;
        n.getClass();
        Intrinsics.checkNotNullParameter(metricsEvent, "metricsEvent");
        n.d.a(new M(metricsEvent));
        n.f1567a.a(n.b.a(metricsEvent));
        return Unit.INSTANCE;
    }
}
