package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;
/* loaded from: classes5.dex */
public final class Y2 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Z2 f764a;

    public Y2(Z2 z2) {
        this.f764a = z2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        Intent intent = (Intent) obj;
        BatteryInfo batteryInfo = this.f764a.b;
        ChargeType chargeType = batteryInfo == null ? null : batteryInfo.chargeType;
        this.f764a.getClass();
        BatteryInfo a2 = Z2.a(intent);
        this.f764a.b = a2;
        if (chargeType != a2.chargeType) {
            this.f764a.f779a.execute(new X2(this, a2));
        }
    }
}
