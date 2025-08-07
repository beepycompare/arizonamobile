package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.mc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0433mc extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final C0433mc f952a = new C0433mc();

    public C0433mc() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ((LocationControllerObserver) obj).stopLocationTracking();
        return Unit.INSTANCE;
    }
}
