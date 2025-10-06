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
public final class C0835m extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0836n f1462a;
    public final /* synthetic */ MetricsEvent b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0835m(C0836n c0836n, MetricsEvent metricsEvent) {
        super(0);
        this.f1462a = c0836n;
        this.b = metricsEvent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        C0836n c0836n = this.f1462a;
        if (!c0836n.f) {
            SingleSubscribeKt.subscribe(SingleSubscribeOnKt.subscribeOn(Single.Companion.from(new C0830h(c0836n)), Dispatchers.INSTANCE.getIo()), new C0832j(c0836n), new C0834l(c0836n));
            c0836n.c.a();
            c0836n.f = true;
        }
        C0825c c0825c = this.f1462a.b;
        MetricsEvent metricsEvent = this.b;
        c0825c.getClass();
        Intrinsics.checkNotNullParameter(metricsEvent, "metricsEvent");
        N n = c0825c.f1451a;
        n.getClass();
        Intrinsics.checkNotNullParameter(metricsEvent, "metricsEvent");
        n.d.a(new M(metricsEvent));
        n.f1436a.a(n.b.a(metricsEvent));
        return Unit.INSTANCE;
    }
}
