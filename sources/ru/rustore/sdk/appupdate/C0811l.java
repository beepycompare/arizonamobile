package ru.rustore.sdk.appupdate;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.MetricsEvent;
import ru.rustore.sdk.reactive.single.Single;
/* renamed from: ru.rustore.sdk.appupdate.l  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0811l extends Lambda implements Function1<MetricsEvent, Single<Unit>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0813n f1531a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0811l(C0813n c0813n) {
        super(1);
        this.f1531a = c0813n;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Single<Unit> invoke(MetricsEvent metricsEvent) {
        MetricsEvent dto = metricsEvent;
        Intrinsics.checkNotNullParameter(dto, "dto");
        return this.f1531a.b.send(dto);
    }
}
