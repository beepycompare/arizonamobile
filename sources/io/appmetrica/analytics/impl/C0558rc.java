package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.rc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0558rc extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final C0558rc f1061a = new C0558rc();

    public C0558rc() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ((LocationControllerObserver) obj).stopLocationTracking();
        return Unit.INSTANCE;
    }
}
