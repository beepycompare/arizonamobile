package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public abstract class T9 {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f659a;
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
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        EnumC0728yb enumC0728yb2 = EnumC0728yb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        EnumC0728yb enumC0728yb3 = EnumC0728yb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        EnumC0728yb enumC0728yb4 = EnumC0728yb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC0728yb enumC0728yb5 = EnumC0728yb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC0728yb enumC0728yb6 = EnumC0728yb.EVENT_TYPE_ANR;
        f659a = CollectionUtils.unmodifiableSetOf(5892, 5896, 5891, 5889, 5890, 5968);
        EnumC0728yb enumC0728yb7 = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        EnumC0728yb enumC0728yb8 = EnumC0728yb.EVENT_TYPE_PURGE_BUFFER;
        EnumC0728yb enumC0728yb9 = EnumC0728yb.EVENT_TYPE_SEND_REFERRER;
        EnumC0728yb enumC0728yb10 = EnumC0728yb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        EnumC0728yb enumC0728yb11 = EnumC0728yb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        EnumC0728yb enumC0728yb12 = EnumC0728yb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        EnumC0728yb enumC0728yb13 = EnumC0728yb.EVENT_TYPE_SET_SESSION_EXTRA;
        b = EnumSet.of(enumC0728yb7, enumC0728yb8, enumC0728yb9, enumC0728yb10, enumC0728yb11, EnumC0728yb.EVENT_TYPE_ACTIVATION, enumC0728yb12, enumC0728yb5, enumC0728yb13);
        EnumC0728yb enumC0728yb14 = EnumC0728yb.EVENT_TYPE_UPDATE_FOREGROUND_TIME;
        EnumC0728yb enumC0728yb15 = EnumC0728yb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        c = EnumSet.of(enumC0728yb14, enumC0728yb4, enumC0728yb5, enumC0728yb12, enumC0728yb15);
        EnumC0728yb enumC0728yb16 = EnumC0728yb.EVENT_TYPE_REGULAR;
        d = EnumSet.of(enumC0728yb4, enumC0728yb5, enumC0728yb3, enumC0728yb, enumC0728yb2, enumC0728yb15, enumC0728yb12, enumC0728yb16, EnumC0728yb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, EnumC0728yb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, EnumC0728yb.EVENT_TYPE_SEND_REVENUE_EVENT, EnumC0728yb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, enumC0728yb8, EnumC0728yb.EVENT_TYPE_INIT, EnumC0728yb.EVENT_TYPE_SEND_USER_PROFILE, EnumC0728yb.EVENT_TYPE_SET_USER_PROFILE_ID, enumC0728yb9, enumC0728yb10, enumC0728yb11, EnumC0728yb.EVENT_TYPE_FIRST_ACTIVATION, EnumC0728yb.EVENT_TYPE_START, EnumC0728yb.EVENT_TYPE_APP_OPEN, EnumC0728yb.EVENT_TYPE_APP_UPDATE, enumC0728yb6);
        e = EnumSet.of(enumC0728yb16);
        f = EnumSet.of(enumC0728yb16);
        g = EnumSet.of(enumC0728yb12);
        h = EnumSet.of(EnumC0728yb.EVENT_TYPE_ALIVE, enumC0728yb8, enumC0728yb13, enumC0728yb5, enumC0728yb12);
        i = Arrays.asList(0, 6145, Integer.valueOf((int) FragmentTransaction.TRANSIT_FRAGMENT_OPEN), 8224);
        EnumC0728yb enumC0728yb17 = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        j = Arrays.asList(12290);
    }
}
