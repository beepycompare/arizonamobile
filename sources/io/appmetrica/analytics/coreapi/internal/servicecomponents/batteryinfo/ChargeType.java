package io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo;
/* loaded from: classes4.dex */
public enum ChargeType {
    UNKNOWN(-1),
    NONE(0),
    USB(1),
    WIRELESS(2),
    AC(3);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f252a;

    ChargeType(int i) {
        this.f252a = i;
    }

    public static ChargeType fromId(Integer num) {
        ChargeType[] values;
        if (num != null) {
            for (ChargeType chargeType : values()) {
                if (chargeType.getId() == num.intValue()) {
                    return chargeType;
                }
            }
        }
        return UNKNOWN;
    }

    public int getId() {
        return this.f252a;
    }
}
