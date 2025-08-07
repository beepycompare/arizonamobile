package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.lc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0408lc extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final C0408lc f937a = new C0408lc();

    public C0408lc() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ((LocationControllerObserver) obj).startLocationTracking();
        return Unit.INSTANCE;
    }
}
