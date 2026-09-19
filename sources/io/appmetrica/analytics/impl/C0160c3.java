package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeTypeChangeListener;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.c3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0160c3 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BatteryInfo f920a;
    public final /* synthetic */ C0186d3 b;

    public C0160c3(C0186d3 c0186d3, BatteryInfo batteryInfo) {
        this.b = c0186d3;
        this.f920a = batteryInfo;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0211e3 c0211e3 = this.b.f939a;
        ChargeType chargeType = this.f920a.chargeType;
        ChargeType chargeType2 = C0211e3.d;
        synchronized (c0211e3) {
            Iterator it = c0211e3.c.iterator();
            while (it.hasNext()) {
                ((ChargeTypeChangeListener) it.next()).onChargeTypeChanged(chargeType);
            }
        }
    }
}
