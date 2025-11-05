package io.appmetrica.analytics.screenshot.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.screenshot.impl.s  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0776s extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0779v f1375a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0776s(C0779v c0779v) {
        super(0);
        this.f1375a = c0779v;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ((C0781x) this.f1375a.b).a("ContentObserverScreenshotCaptor");
        return Unit.INSTANCE;
    }
}
