package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.rc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0559rc extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final C0559rc f1066a = new C0559rc();

    public C0559rc() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ((LocationControllerObserver) obj).stopLocationTracking();
        return Unit.INSTANCE;
    }
}
