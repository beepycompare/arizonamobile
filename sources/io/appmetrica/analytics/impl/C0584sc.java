package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.sc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0584sc extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final C0584sc f1196a = new C0584sc();

    public C0584sc() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ((LocationControllerObserver) obj).startLocationTracking();
        return Unit.INSTANCE;
    }
}
