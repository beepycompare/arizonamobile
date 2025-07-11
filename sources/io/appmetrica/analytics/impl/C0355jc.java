package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.jc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0355jc extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final C0355jc f891a = new C0355jc();

    public C0355jc() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ((LocationControllerObserver) obj).startLocationTracking();
        return Unit.INSTANCE;
    }
}
