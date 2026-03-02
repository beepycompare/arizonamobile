package io.appmetrica.analytics.screenshot.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.screenshot.impl.s  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0778s extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0781v f1483a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0778s(C0781v c0781v) {
        super(0);
        this.f1483a = c0781v;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ((C0783x) this.f1483a.b).a("ContentObserverScreenshotCaptor");
        return Unit.INSTANCE;
    }
}
