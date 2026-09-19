package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;
/* renamed from: io.appmetrica.analytics.impl.d3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0186d3 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0211e3 f939a;

    public C0186d3(C0211e3 c0211e3) {
        this.f939a = c0211e3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        Intent intent = (Intent) obj;
        BatteryInfo batteryInfo = this.f939a.b;
        ChargeType chargeType = batteryInfo == null ? null : batteryInfo.chargeType;
        this.f939a.getClass();
        BatteryInfo a2 = C0211e3.a(intent);
        this.f939a.b = a2;
        if (chargeType != a2.chargeType) {
            this.f939a.f958a.execute(new C0160c3(this, a2));
        }
    }
}
