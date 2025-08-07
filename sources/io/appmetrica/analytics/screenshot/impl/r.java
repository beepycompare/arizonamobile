package io.appmetrica.analytics.screenshot.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class r extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0788u f1312a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(C0788u c0788u) {
        super(0);
        this.f1312a = c0788u;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ((C0789v) this.f1312a.b).a("ContentObserverScreenshotCaptor");
        return Unit.INSTANCE;
    }
}
