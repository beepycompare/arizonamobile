package io.appmetrica.analytics.screenshot.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.screenshot.impl.s  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0775s extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0778v f1475a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0775s(C0778v c0778v) {
        super(0);
        this.f1475a = c0778v;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ((C0780x) this.f1475a.b).a("ContentObserverScreenshotCaptor");
        return Unit.INSTANCE;
    }
}
