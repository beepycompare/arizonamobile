package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;
/* renamed from: io.appmetrica.analytics.impl.g3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0267g3 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0293h3 f883a;

    public C0267g3(C0293h3 c0293h3) {
        this.f883a = c0293h3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        Intent intent = (Intent) obj;
        BatteryInfo batteryInfo = this.f883a.b;
        ChargeType chargeType = batteryInfo == null ? null : batteryInfo.chargeType;
        this.f883a.getClass();
        BatteryInfo a2 = C0293h3.a(intent);
        this.f883a.b = a2;
        if (chargeType != a2.chargeType) {
            this.f883a.f901a.execute(new C0241f3(this, a2));
        }
    }
}
