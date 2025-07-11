package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;
/* renamed from: io.appmetrica.analytics.impl.d3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0197d3 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0222e3 f796a;

    public C0197d3(C0222e3 c0222e3) {
        this.f796a = c0222e3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        Intent intent = (Intent) obj;
        BatteryInfo batteryInfo = this.f796a.b;
        ChargeType chargeType = batteryInfo == null ? null : batteryInfo.chargeType;
        this.f796a.getClass();
        BatteryInfo a2 = C0222e3.a(intent);
        this.f796a.b = a2;
        if (chargeType != a2.chargeType) {
            this.f796a.f815a.execute(new C0171c3(this, a2));
        }
    }
}
