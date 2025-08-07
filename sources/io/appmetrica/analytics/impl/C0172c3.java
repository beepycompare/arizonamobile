package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeTypeChangeListener;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.c3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0172c3 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BatteryInfo f792a;
    public final /* synthetic */ C0198d3 b;

    public C0172c3(C0198d3 c0198d3, BatteryInfo batteryInfo) {
        this.b = c0198d3;
        this.f792a = batteryInfo;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0223e3 c0223e3 = this.b.f810a;
        ChargeType chargeType = this.f792a.chargeType;
        ChargeType chargeType2 = C0223e3.d;
        synchronized (c0223e3) {
            Iterator it = c0223e3.c.iterator();
            while (it.hasNext()) {
                ((ChargeTypeChangeListener) it.next()).onChargeTypeChanged(chargeType);
            }
        }
    }
}
