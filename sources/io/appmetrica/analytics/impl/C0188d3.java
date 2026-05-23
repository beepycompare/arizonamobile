package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;
/* renamed from: io.appmetrica.analytics.impl.d3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0188d3 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0213e3 f936a;

    public C0188d3(C0213e3 c0213e3) {
        this.f936a = c0213e3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        Intent intent = (Intent) obj;
        BatteryInfo batteryInfo = this.f936a.b;
        ChargeType chargeType = batteryInfo == null ? null : batteryInfo.chargeType;
        this.f936a.getClass();
        BatteryInfo a2 = C0213e3.a(intent);
        this.f936a.b = a2;
        if (chargeType != a2.chargeType) {
            this.f936a.f955a.execute(new C0162c3(this, a2));
        }
    }
}
