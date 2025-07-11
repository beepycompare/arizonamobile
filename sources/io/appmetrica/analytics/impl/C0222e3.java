package io.appmetrica.analytics.impl;

import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeTypeChangeListener;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeTypeProvider;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.e3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0222e3 implements ChargeTypeProvider {
    public static final ChargeType d = ChargeType.UNKNOWN;

    /* renamed from: a  reason: collision with root package name */
    public final ICommonExecutor f815a;
    public volatile BatteryInfo b;
    public final ArrayList c = new ArrayList();

    public C0222e3(ICommonExecutor iCommonExecutor, C0145b3 c0145b3) {
        C0197d3 c0197d3 = new C0197d3(this);
        this.f815a = iCommonExecutor;
        this.b = a(c0145b3.a(c0197d3));
    }

    public static BatteryInfo a(Intent intent) {
        ChargeType chargeType = d;
        Integer num = null;
        if (intent != null) {
            int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra > 0 && intExtra2 > 0) {
                num = Integer.valueOf((intExtra * 100) / intExtra2);
            }
            int intExtra3 = intent.getIntExtra("plugged", -1);
            chargeType = ChargeType.NONE;
            if (intExtra3 == 1) {
                chargeType = ChargeType.AC;
            } else if (intExtra3 == 2) {
                chargeType = ChargeType.USB;
            } else if (intExtra3 == 4) {
                chargeType = ChargeType.WIRELESS;
            }
        }
        return new BatteryInfo(num, chargeType);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeTypeProvider
    public final Integer getBatteryLevel() {
        BatteryInfo batteryInfo = this.b;
        if (batteryInfo == null) {
            return null;
        }
        return batteryInfo.batteryLevel;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeTypeProvider
    public final ChargeType getChargeType() {
        BatteryInfo batteryInfo = this.b;
        return batteryInfo == null ? ChargeType.UNKNOWN : batteryInfo.chargeType;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeTypeProvider
    public final synchronized void registerChargeTypeListener(ChargeTypeChangeListener chargeTypeChangeListener) {
        this.c.add(chargeTypeChangeListener);
        chargeTypeChangeListener.onChargeTypeChanged(getChargeType());
    }
}
