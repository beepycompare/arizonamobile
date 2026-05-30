package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeTypeChangeListener;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.c3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0162c3 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BatteryInfo f918a;
    public final /* synthetic */ C0188d3 b;

    public C0162c3(C0188d3 c0188d3, BatteryInfo batteryInfo) {
        this.b = c0188d3;
        this.f918a = batteryInfo;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0213e3 c0213e3 = this.b.f937a;
        ChargeType chargeType = this.f918a.chargeType;
        ChargeType chargeType2 = C0213e3.d;
        synchronized (c0213e3) {
            Iterator it = c0213e3.c.iterator();
            while (it.hasNext()) {
                ((ChargeTypeChangeListener) it.next()).onChargeTypeChanged(chargeType);
            }
        }
    }
}
