package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public abstract class O9 {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f564a;
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
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        EnumC0636ub enumC0636ub2 = EnumC0636ub.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        EnumC0636ub enumC0636ub3 = EnumC0636ub.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        EnumC0636ub enumC0636ub4 = EnumC0636ub.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC0636ub enumC0636ub5 = EnumC0636ub.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC0636ub enumC0636ub6 = EnumC0636ub.EVENT_TYPE_ANR;
        f564a = CollectionUtils.unmodifiableSetOf(5892, 5896, 5891, 5889, 5890, 5968);
        EnumC0636ub enumC0636ub7 = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        EnumC0636ub enumC0636ub8 = EnumC0636ub.EVENT_TYPE_PURGE_BUFFER;
        EnumC0636ub enumC0636ub9 = EnumC0636ub.EVENT_TYPE_SEND_REFERRER;
        EnumC0636ub enumC0636ub10 = EnumC0636ub.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        EnumC0636ub enumC0636ub11 = EnumC0636ub.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        EnumC0636ub enumC0636ub12 = EnumC0636ub.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        EnumC0636ub enumC0636ub13 = EnumC0636ub.EVENT_TYPE_SET_SESSION_EXTRA;
        b = EnumSet.of(enumC0636ub7, enumC0636ub8, enumC0636ub9, enumC0636ub10, enumC0636ub11, EnumC0636ub.EVENT_TYPE_ACTIVATION, enumC0636ub12, enumC0636ub5, enumC0636ub13);
        EnumC0636ub enumC0636ub14 = EnumC0636ub.EVENT_TYPE_UPDATE_FOREGROUND_TIME;
        EnumC0636ub enumC0636ub15 = EnumC0636ub.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        c = EnumSet.of(enumC0636ub14, enumC0636ub4, enumC0636ub5, enumC0636ub12, enumC0636ub15);
        EnumC0636ub enumC0636ub16 = EnumC0636ub.EVENT_TYPE_REGULAR;
        d = EnumSet.of(enumC0636ub4, enumC0636ub5, enumC0636ub3, enumC0636ub, enumC0636ub2, enumC0636ub15, enumC0636ub12, enumC0636ub16, EnumC0636ub.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, EnumC0636ub.EVENT_TYPE_SEND_ECOMMERCE_EVENT, EnumC0636ub.EVENT_TYPE_SEND_REVENUE_EVENT, EnumC0636ub.EVENT_TYPE_SEND_AD_REVENUE_EVENT, enumC0636ub8, EnumC0636ub.EVENT_TYPE_INIT, EnumC0636ub.EVENT_TYPE_SEND_USER_PROFILE, EnumC0636ub.EVENT_TYPE_SET_USER_PROFILE_ID, enumC0636ub9, enumC0636ub10, enumC0636ub11, EnumC0636ub.EVENT_TYPE_FIRST_ACTIVATION, EnumC0636ub.EVENT_TYPE_START, EnumC0636ub.EVENT_TYPE_APP_OPEN, EnumC0636ub.EVENT_TYPE_APP_UPDATE, enumC0636ub6);
        e = EnumSet.of(enumC0636ub16);
        f = EnumSet.of(enumC0636ub16);
        g = EnumSet.of(enumC0636ub12);
        h = EnumSet.of(EnumC0636ub.EVENT_TYPE_ALIVE, enumC0636ub8, enumC0636ub13, enumC0636ub5, enumC0636ub12);
        i = Arrays.asList(0, 6145, Integer.valueOf((int) FragmentTransaction.TRANSIT_FRAGMENT_OPEN), 8224);
        EnumC0636ub enumC0636ub17 = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        j = Arrays.asList(12290);
    }
}
