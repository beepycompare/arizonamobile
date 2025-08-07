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
    public static final Set f620a;
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
        EnumC0681wb enumC0681wb = EnumC0681wb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        EnumC0681wb enumC0681wb2 = EnumC0681wb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        EnumC0681wb enumC0681wb3 = EnumC0681wb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        EnumC0681wb enumC0681wb4 = EnumC0681wb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC0681wb enumC0681wb5 = EnumC0681wb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC0681wb enumC0681wb6 = EnumC0681wb.EVENT_TYPE_ANR;
        f620a = CollectionUtils.unmodifiableSetOf(5892, 5896, 5891, 5889, 5890, 5968);
        EnumC0681wb enumC0681wb7 = EnumC0681wb.EVENT_TYPE_UNDEFINED;
        EnumC0681wb enumC0681wb8 = EnumC0681wb.EVENT_TYPE_PURGE_BUFFER;
        EnumC0681wb enumC0681wb9 = EnumC0681wb.EVENT_TYPE_SEND_REFERRER;
        EnumC0681wb enumC0681wb10 = EnumC0681wb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        EnumC0681wb enumC0681wb11 = EnumC0681wb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        EnumC0681wb enumC0681wb12 = EnumC0681wb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        EnumC0681wb enumC0681wb13 = EnumC0681wb.EVENT_TYPE_SET_SESSION_EXTRA;
        b = EnumSet.of(enumC0681wb7, enumC0681wb8, enumC0681wb9, enumC0681wb10, enumC0681wb11, EnumC0681wb.EVENT_TYPE_ACTIVATION, enumC0681wb12, enumC0681wb5, enumC0681wb13);
        EnumC0681wb enumC0681wb14 = EnumC0681wb.EVENT_TYPE_UPDATE_FOREGROUND_TIME;
        EnumC0681wb enumC0681wb15 = EnumC0681wb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        c = EnumSet.of(enumC0681wb14, enumC0681wb4, enumC0681wb5, enumC0681wb12, enumC0681wb15);
        EnumC0681wb enumC0681wb16 = EnumC0681wb.EVENT_TYPE_REGULAR;
        d = EnumSet.of(enumC0681wb4, enumC0681wb5, enumC0681wb3, enumC0681wb, enumC0681wb2, enumC0681wb15, enumC0681wb12, enumC0681wb16, EnumC0681wb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, EnumC0681wb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, EnumC0681wb.EVENT_TYPE_SEND_REVENUE_EVENT, EnumC0681wb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, enumC0681wb8, EnumC0681wb.EVENT_TYPE_INIT, EnumC0681wb.EVENT_TYPE_SEND_USER_PROFILE, EnumC0681wb.EVENT_TYPE_SET_USER_PROFILE_ID, enumC0681wb9, enumC0681wb10, enumC0681wb11, EnumC0681wb.EVENT_TYPE_FIRST_ACTIVATION, EnumC0681wb.EVENT_TYPE_START, EnumC0681wb.EVENT_TYPE_APP_OPEN, EnumC0681wb.EVENT_TYPE_APP_UPDATE, enumC0681wb6);
        e = EnumSet.of(enumC0681wb16);
        f = EnumSet.of(enumC0681wb16);
        g = EnumSet.of(enumC0681wb12);
        h = EnumSet.of(EnumC0681wb.EVENT_TYPE_ALIVE, enumC0681wb8, enumC0681wb13, enumC0681wb5, enumC0681wb12);
        i = Arrays.asList(0, 6145, Integer.valueOf((int) FragmentTransaction.TRANSIT_FRAGMENT_OPEN), 8224);
        EnumC0681wb enumC0681wb17 = EnumC0681wb.EVENT_TYPE_UNDEFINED;
        j = Arrays.asList(12290);
    }
}
