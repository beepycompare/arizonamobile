package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;
/* renamed from: io.appmetrica.analytics.impl.g3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0268g3 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0294h3 f888a;

    public C0268g3(C0294h3 c0294h3) {
        this.f888a = c0294h3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        Intent intent = (Intent) obj;
        BatteryInfo batteryInfo = this.f888a.b;
        ChargeType chargeType = batteryInfo == null ? null : batteryInfo.chargeType;
        this.f888a.getClass();
        BatteryInfo a2 = C0294h3.a(intent);
        this.f888a.b = a2;
        if (chargeType != a2.chargeType) {
            this.f888a.f906a.execute(new C0242f3(this, a2));
        }
    }
}
