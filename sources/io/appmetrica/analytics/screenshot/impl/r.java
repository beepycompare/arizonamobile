package io.appmetrica.analytics.screenshot.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class r extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0787u f1313a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(C0787u c0787u) {
        super(0);
        this.f1313a = c0787u;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ((C0788v) this.f1313a.b).a("ContentObserverScreenshotCaptor");
        return Unit.INSTANCE;
    }
}
