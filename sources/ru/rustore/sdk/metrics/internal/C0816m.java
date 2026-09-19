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
public final class C0816m extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0817n f1548a;
    public final /* synthetic */ MetricsEvent b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0816m(C0817n c0817n, MetricsEvent metricsEvent) {
        super(0);
        this.f1548a = c0817n;
        this.b = metricsEvent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        C0817n c0817n = this.f1548a;
        if (!c0817n.f) {
            SingleSubscribeKt.subscribe(SingleSubscribeOnKt.subscribeOn(Single.Companion.from(new C0811h(c0817n)), Dispatchers.INSTANCE.getIo()), new C0813j(c0817n), new C0815l(c0817n));
            c0817n.c.a();
            c0817n.f = true;
        }
        C0806c c0806c = this.f1548a.b;
        MetricsEvent metricsEvent = this.b;
        c0806c.getClass();
        Intrinsics.checkNotNullParameter(metricsEvent, "metricsEvent");
        N n = c0806c.f1537a;
        n.getClass();
        Intrinsics.checkNotNullParameter(metricsEvent, "metricsEvent");
        n.d.a(new M(metricsEvent));
        n.f1522a.a(n.b.a(metricsEvent));
        return Unit.INSTANCE;
    }
}
