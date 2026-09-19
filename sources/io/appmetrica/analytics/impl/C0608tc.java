package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.tc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0608tc extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final C0608tc f1216a = new C0608tc();

    public C0608tc() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ((LocationControllerObserver) obj).stopLocationTracking();
        return Unit.INSTANCE;
    }
}
