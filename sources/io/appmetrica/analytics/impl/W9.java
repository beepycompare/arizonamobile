package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public abstract class W9 {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f725a;
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
        Bb bb = Bb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        Bb bb2 = Bb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        Bb bb3 = Bb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        Bb bb4 = Bb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        Bb bb5 = Bb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        Bb bb6 = Bb.EVENT_TYPE_ANR;
        f725a = CollectionUtils.unmodifiableSetOf(5892, 5896, 5891, 5889, 5890, 5968);
        Bb bb7 = Bb.EVENT_TYPE_UNDEFINED;
        Bb bb8 = Bb.EVENT_TYPE_PURGE_BUFFER;
        Bb bb9 = Bb.EVENT_TYPE_SEND_REFERRER;
        Bb bb10 = Bb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        Bb bb11 = Bb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        Bb bb12 = Bb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        Bb bb13 = Bb.EVENT_TYPE_SET_SESSION_EXTRA;
        b = EnumSet.of(bb7, bb8, bb9, bb10, bb11, Bb.EVENT_TYPE_ACTIVATION, bb12, bb5, bb13);
        Bb bb14 = Bb.EVENT_TYPE_UPDATE_FOREGROUND_TIME;
        Bb bb15 = Bb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        c = EnumSet.of(bb14, bb4, bb5, bb12, bb15);
        Bb bb16 = Bb.EVENT_TYPE_REGULAR;
        d = EnumSet.of(bb4, bb5, bb3, bb, bb2, bb15, bb12, bb16, Bb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, Bb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, Bb.EVENT_TYPE_SEND_REVENUE_EVENT, Bb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, bb8, Bb.EVENT_TYPE_INIT, Bb.EVENT_TYPE_SEND_USER_PROFILE, Bb.EVENT_TYPE_SET_USER_PROFILE_ID, bb9, bb10, bb11, Bb.EVENT_TYPE_FIRST_ACTIVATION, Bb.EVENT_TYPE_START, Bb.EVENT_TYPE_APP_OPEN, Bb.EVENT_TYPE_APP_UPDATE, bb6);
        e = EnumSet.of(bb16);
        f = EnumSet.of(bb16);
        g = EnumSet.of(bb12);
        h = EnumSet.of(Bb.EVENT_TYPE_ALIVE, bb8, bb13, bb5, bb12);
        i = Arrays.asList(0, 6145, Integer.valueOf((int) FragmentTransaction.TRANSIT_FRAGMENT_OPEN), 8224);
        Bb bb17 = Bb.EVENT_TYPE_UNDEFINED;
        j = Arrays.asList(12290);
    }
}
