package io.appmetrica.analytics.screenshot.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class r extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0793u f1308a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(C0793u c0793u) {
        super(0);
        this.f1308a = c0793u;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ((C0794v) this.f1308a.b).a("ContentObserverScreenshotCaptor");
        return Unit.INSTANCE;
    }
}
