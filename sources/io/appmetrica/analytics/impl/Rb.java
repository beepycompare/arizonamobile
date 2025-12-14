package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class Rb extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Rb f757a = new Rb();

    public Rb() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ((LocationControllerObserver) obj).startLocationTracking();
        return Unit.INSTANCE;
    }
}
