package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeTypeChangeListener;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.c3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0171c3 extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BatteryInfo f779a;
    public final /* synthetic */ C0197d3 b;

    public C0171c3(C0197d3 c0197d3, BatteryInfo batteryInfo) {
        this.b = c0197d3;
        this.f779a = batteryInfo;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0222e3 c0222e3 = this.b.f796a;
        ChargeType chargeType = this.f779a.chargeType;
        ChargeType chargeType2 = C0222e3.d;
        synchronized (c0222e3) {
            Iterator it = c0222e3.c.iterator();
            while (it.hasNext()) {
                ((ChargeTypeChangeListener) it.next()).onChargeTypeChanged(chargeType);
            }
        }
    }
}
