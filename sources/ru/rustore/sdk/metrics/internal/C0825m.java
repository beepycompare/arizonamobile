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
public final class C0825m extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0826n f1618a;
    public final /* synthetic */ MetricsEvent b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0825m(C0826n c0826n, MetricsEvent metricsEvent) {
        super(0);
        this.f1618a = c0826n;
        this.b = metricsEvent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        C0826n c0826n = this.f1618a;
        if (!c0826n.f) {
            SingleSubscribeKt.subscribe(SingleSubscribeOnKt.subscribeOn(Single.Companion.from(new C0820h(c0826n)), Dispatchers.INSTANCE.getIo()), new C0822j(c0826n), new C0824l(c0826n));
            c0826n.c.a();
            c0826n.f = true;
        }
        C0815c c0815c = this.f1618a.b;
        MetricsEvent metricsEvent = this.b;
        c0815c.getClass();
        Intrinsics.checkNotNullParameter(metricsEvent, "metricsEvent");
        N n = c0815c.f1607a;
        n.getClass();
        Intrinsics.checkNotNullParameter(metricsEvent, "metricsEvent");
        n.d.a(new M(metricsEvent));
        n.f1592a.a(n.b.a(metricsEvent));
        return Unit.INSTANCE;
    }
}
