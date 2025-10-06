package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeTypeChangeListener;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.f3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0242f3 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BatteryInfo f872a;
    public final /* synthetic */ C0268g3 b;

    public C0242f3(C0268g3 c0268g3, BatteryInfo batteryInfo) {
        this.b = c0268g3;
        this.f872a = batteryInfo;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0294h3 c0294h3 = this.b.f888a;
        ChargeType chargeType = this.f872a.chargeType;
        ChargeType chargeType2 = C0294h3.d;
        synchronized (c0294h3) {
            Iterator it = c0294h3.c.iterator();
            while (it.hasNext()) {
                ((ChargeTypeChangeListener) it.next()).onChargeTypeChanged(chargeType);
            }
        }
    }
}
