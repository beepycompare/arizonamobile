package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;
/* renamed from: io.appmetrica.analytics.impl.d3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0198d3 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0223e3 f810a;

    public C0198d3(C0223e3 c0223e3) {
        this.f810a = c0223e3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        Intent intent = (Intent) obj;
        BatteryInfo batteryInfo = this.f810a.b;
        ChargeType chargeType = batteryInfo == null ? null : batteryInfo.chargeType;
        this.f810a.getClass();
        BatteryInfo a2 = C0223e3.a(intent);
        this.f810a.b = a2;
        if (chargeType != a2.chargeType) {
            this.f810a.f824a.execute(new C0172c3(this, a2));
        }
    }
}
