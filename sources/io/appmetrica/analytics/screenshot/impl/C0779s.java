package io.appmetrica.analytics.screenshot.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.screenshot.impl.s  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0779s extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0782v f1483a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0779s(C0782v c0782v) {
        super(0);
        this.f1483a = c0782v;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ((C0784x) this.f1483a.b).a("ContentObserverScreenshotCaptor");
        return Unit.INSTANCE;
    }
}
