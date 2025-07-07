package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.wa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC0685wa {
    UNKNOWN(0),
    FIRST_OCCURRENCE(1),
    NON_FIRST_OCCURENCE(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f1103a;

    EnumC0685wa(int i) {
        this.f1103a = i;
    }

    public static EnumC0685wa a(Integer num) {
        EnumC0685wa[] values;
        if (num != null) {
            for (EnumC0685wa enumC0685wa : values()) {
                if (enumC0685wa.f1103a == num.intValue()) {
                    return enumC0685wa;
                }
            }
        }
        return UNKNOWN;
    }
}
