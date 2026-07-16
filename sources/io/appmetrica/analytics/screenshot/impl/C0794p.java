package io.appmetrica.analytics.screenshot.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.screenshot.impl.p  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0794p extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0796s f1456a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0794p(C0796s c0796s) {
        super(0);
        this.f1456a = c0796s;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ((C0798u) this.f1456a.b).a("ContentObserverScreenshotCaptor");
        return Unit.INSTANCE;
    }
}
