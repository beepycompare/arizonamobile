package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public abstract class R9 {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f621a;
    public static final EnumSet b;
    public static final EnumSet c;
    public static final EnumSet d;
    public static final EnumSet e;
    public static final EnumSet f;
    public static final EnumSet g;
    public static final EnumSet h;
    public static final List i;
    public static final List j;

    static {
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        EnumC0680wb enumC0680wb2 = EnumC0680wb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        EnumC0680wb enumC0680wb3 = EnumC0680wb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        EnumC0680wb enumC0680wb4 = EnumC0680wb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC0680wb enumC0680wb5 = EnumC0680wb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC0680wb enumC0680wb6 = EnumC0680wb.EVENT_TYPE_ANR;
        f621a = CollectionUtils.unmodifiableSetOf(5892, 5896, 5891, 5889, 5890, 5968);
        EnumC0680wb enumC0680wb7 = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        EnumC0680wb enumC0680wb8 = EnumC0680wb.EVENT_TYPE_PURGE_BUFFER;
        EnumC0680wb enumC0680wb9 = EnumC0680wb.EVENT_TYPE_SEND_REFERRER;
        EnumC0680wb enumC0680wb10 = EnumC0680wb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        EnumC0680wb enumC0680wb11 = EnumC0680wb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        EnumC0680wb enumC0680wb12 = EnumC0680wb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        EnumC0680wb enumC0680wb13 = EnumC0680wb.EVENT_TYPE_SET_SESSION_EXTRA;
        b = EnumSet.of(enumC0680wb7, enumC0680wb8, enumC0680wb9, enumC0680wb10, enumC0680wb11, EnumC0680wb.EVENT_TYPE_ACTIVATION, enumC0680wb12, enumC0680wb5, enumC0680wb13);
        EnumC0680wb enumC0680wb14 = EnumC0680wb.EVENT_TYPE_UPDATE_FOREGROUND_TIME;
        EnumC0680wb enumC0680wb15 = EnumC0680wb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        c = EnumSet.of(enumC0680wb14, enumC0680wb4, enumC0680wb5, enumC0680wb12, enumC0680wb15);
        EnumC0680wb enumC0680wb16 = EnumC0680wb.EVENT_TYPE_REGULAR;
        d = EnumSet.of(enumC0680wb4, enumC0680wb5, enumC0680wb3, enumC0680wb, enumC0680wb2, enumC0680wb15, enumC0680wb12, enumC0680wb16, EnumC0680wb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, EnumC0680wb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, EnumC0680wb.EVENT_TYPE_SEND_REVENUE_EVENT, EnumC0680wb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, enumC0680wb8, EnumC0680wb.EVENT_TYPE_INIT, EnumC0680wb.EVENT_TYPE_SEND_USER_PROFILE, EnumC0680wb.EVENT_TYPE_SET_USER_PROFILE_ID, enumC0680wb9, enumC0680wb10, enumC0680wb11, EnumC0680wb.EVENT_TYPE_FIRST_ACTIVATION, EnumC0680wb.EVENT_TYPE_START, EnumC0680wb.EVENT_TYPE_APP_OPEN, EnumC0680wb.EVENT_TYPE_APP_UPDATE, enumC0680wb6);
        e = EnumSet.of(enumC0680wb16);
        f = EnumSet.of(enumC0680wb16);
        g = EnumSet.of(enumC0680wb12);
        h = EnumSet.of(EnumC0680wb.EVENT_TYPE_ALIVE, enumC0680wb8, enumC0680wb13, enumC0680wb5, enumC0680wb12);
        i = Arrays.asList(0, 6145, Integer.valueOf((int) FragmentTransaction.TRANSIT_FRAGMENT_OPEN), 8224);
        EnumC0680wb enumC0680wb17 = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        j = Arrays.asList(12290);
    }
}
