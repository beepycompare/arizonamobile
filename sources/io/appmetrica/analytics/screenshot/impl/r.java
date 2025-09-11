package io.appmetrica.analytics.screenshot.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class r extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0789u f1331a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(C0789u c0789u) {
        super(0);
        this.f1331a = c0789u;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ((C0790v) this.f1331a.b).a("ContentObserverScreenshotCaptor");
        return Unit.INSTANCE;
    }
}
