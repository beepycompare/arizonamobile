package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.qc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0534qc extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final C0534qc f1049a = new C0534qc();

    public C0534qc() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ((LocationControllerObserver) obj).startLocationTracking();
        return Unit.INSTANCE;
    }
}
