package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes5.dex */
public abstract class D9 {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f438a;
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
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        EnumC0320ib enumC0320ib2 = EnumC0320ib.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        EnumC0320ib enumC0320ib3 = EnumC0320ib.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        EnumC0320ib enumC0320ib4 = EnumC0320ib.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC0320ib enumC0320ib5 = EnumC0320ib.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC0320ib enumC0320ib6 = EnumC0320ib.EVENT_TYPE_ANR;
        f438a = CollectionUtils.unmodifiableSetOf(5892, 5896, 5891, 5889, 5890, 5968);
        EnumC0320ib enumC0320ib7 = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        EnumC0320ib enumC0320ib8 = EnumC0320ib.EVENT_TYPE_PURGE_BUFFER;
        EnumC0320ib enumC0320ib9 = EnumC0320ib.EVENT_TYPE_SEND_REFERRER;
        EnumC0320ib enumC0320ib10 = EnumC0320ib.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        EnumC0320ib enumC0320ib11 = EnumC0320ib.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        EnumC0320ib enumC0320ib12 = EnumC0320ib.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        EnumC0320ib enumC0320ib13 = EnumC0320ib.EVENT_TYPE_SET_SESSION_EXTRA;
        b = EnumSet.of(enumC0320ib7, enumC0320ib8, enumC0320ib9, enumC0320ib10, enumC0320ib11, EnumC0320ib.EVENT_TYPE_ACTIVATION, enumC0320ib12, enumC0320ib5, enumC0320ib13);
        EnumC0320ib enumC0320ib14 = EnumC0320ib.EVENT_TYPE_UPDATE_FOREGROUND_TIME;
        EnumC0320ib enumC0320ib15 = EnumC0320ib.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        c = EnumSet.of(enumC0320ib14, enumC0320ib4, enumC0320ib5, enumC0320ib12, enumC0320ib15);
        EnumC0320ib enumC0320ib16 = EnumC0320ib.EVENT_TYPE_REGULAR;
        d = EnumSet.of(enumC0320ib4, enumC0320ib5, enumC0320ib3, enumC0320ib, enumC0320ib2, enumC0320ib15, enumC0320ib12, enumC0320ib16, EnumC0320ib.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, EnumC0320ib.EVENT_TYPE_SEND_ECOMMERCE_EVENT, EnumC0320ib.EVENT_TYPE_SEND_REVENUE_EVENT, EnumC0320ib.EVENT_TYPE_SEND_AD_REVENUE_EVENT, enumC0320ib8, EnumC0320ib.EVENT_TYPE_INIT, EnumC0320ib.EVENT_TYPE_SEND_USER_PROFILE, EnumC0320ib.EVENT_TYPE_SET_USER_PROFILE_ID, enumC0320ib9, enumC0320ib10, enumC0320ib11, EnumC0320ib.EVENT_TYPE_FIRST_ACTIVATION, EnumC0320ib.EVENT_TYPE_START, EnumC0320ib.EVENT_TYPE_APP_OPEN, EnumC0320ib.EVENT_TYPE_APP_UPDATE, enumC0320ib6);
        e = EnumSet.of(enumC0320ib16);
        f = EnumSet.of(enumC0320ib16);
        g = EnumSet.of(enumC0320ib12);
        h = EnumSet.of(EnumC0320ib.EVENT_TYPE_ALIVE, enumC0320ib8, enumC0320ib13, enumC0320ib5, enumC0320ib12);
        i = Arrays.asList(0, 6145, Integer.valueOf((int) FragmentTransaction.TRANSIT_FRAGMENT_OPEN), 8224);
        EnumC0320ib enumC0320ib17 = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        j = Arrays.asList(12290);
    }
}
