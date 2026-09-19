package ru.rustore.sdk.appupdate;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.MetricsEvent;
/* renamed from: ru.rustore.sdk.appupdate.k  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0788k extends Lambda implements Function0<MetricsEvent> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0791n f1487a;
    public final /* synthetic */ C0786i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0788k(C0791n c0791n, C0786i c0786i) {
        super(0);
        this.f1487a = c0791n;
        this.b = c0786i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final MetricsEvent invoke() {
        C0787j c0787j = this.f1487a.f1492a;
        C0786i model = this.b;
        c0787j.getClass();
        Intrinsics.checkNotNullParameter(model, "model");
        return new MetricsEvent(model.f1485a, model.b);
    }
}
