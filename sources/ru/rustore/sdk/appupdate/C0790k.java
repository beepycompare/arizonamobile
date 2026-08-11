package ru.rustore.sdk.appupdate;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.MetricsEvent;
/* renamed from: ru.rustore.sdk.appupdate.k  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0790k extends Lambda implements Function0<MetricsEvent> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0793n f1487a;
    public final /* synthetic */ C0788i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0790k(C0793n c0793n, C0788i c0788i) {
        super(0);
        this.f1487a = c0793n;
        this.b = c0788i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final MetricsEvent invoke() {
        C0789j c0789j = this.f1487a.f1492a;
        C0788i model = this.b;
        c0789j.getClass();
        Intrinsics.checkNotNullParameter(model, "model");
        return new MetricsEvent(model.f1485a, model.b);
    }
}
