package ru.rustore.sdk.appupdate;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.MetricsEvent;
/* renamed from: ru.rustore.sdk.appupdate.k  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0807k extends Lambda implements Function0<MetricsEvent> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0810n f1401a;
    public final /* synthetic */ C0805i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0807k(C0810n c0810n, C0805i c0805i) {
        super(0);
        this.f1401a = c0810n;
        this.b = c0805i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final MetricsEvent invoke() {
        C0806j c0806j = this.f1401a.f1406a;
        C0805i model = this.b;
        c0806j.getClass();
        Intrinsics.checkNotNullParameter(model, "model");
        return new MetricsEvent(model.f1399a, model.b);
    }
}
