package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;
/* loaded from: classes5.dex */
public final class Q2 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ R2 f752a;

    public Q2(R2 r2) {
        this.f752a = r2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        Intent intent = (Intent) obj;
        BatteryInfo batteryInfo = this.f752a.b;
        ChargeType chargeType = batteryInfo == null ? null : batteryInfo.chargeType;
        this.f752a.getClass();
        BatteryInfo a2 = R2.a(intent);
        this.f752a.b = a2;
        if (chargeType != a2.chargeType) {
            this.f752a.f763a.execute(new P2(this, a2));
        }
    }
}
