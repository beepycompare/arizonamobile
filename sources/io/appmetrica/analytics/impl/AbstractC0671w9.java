package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.w9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0671w9 {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f1289a;
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
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        EnumC0142bb enumC0142bb2 = EnumC0142bb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        EnumC0142bb enumC0142bb3 = EnumC0142bb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        EnumC0142bb enumC0142bb4 = EnumC0142bb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC0142bb enumC0142bb5 = EnumC0142bb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC0142bb enumC0142bb6 = EnumC0142bb.EVENT_TYPE_ANR;
        f1289a = CollectionUtils.unmodifiableSetOf(5892, 5896, 5891, 5889, 5890, 5968);
        EnumC0142bb enumC0142bb7 = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        EnumC0142bb enumC0142bb8 = EnumC0142bb.EVENT_TYPE_PURGE_BUFFER;
        EnumC0142bb enumC0142bb9 = EnumC0142bb.EVENT_TYPE_SEND_REFERRER;
        EnumC0142bb enumC0142bb10 = EnumC0142bb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        EnumC0142bb enumC0142bb11 = EnumC0142bb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        EnumC0142bb enumC0142bb12 = EnumC0142bb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        EnumC0142bb enumC0142bb13 = EnumC0142bb.EVENT_TYPE_SET_SESSION_EXTRA;
        b = EnumSet.of(enumC0142bb7, enumC0142bb8, enumC0142bb9, enumC0142bb10, enumC0142bb11, EnumC0142bb.EVENT_TYPE_ACTIVATION, enumC0142bb12, enumC0142bb5, enumC0142bb13);
        EnumC0142bb enumC0142bb14 = EnumC0142bb.EVENT_TYPE_UPDATE_FOREGROUND_TIME;
        EnumC0142bb enumC0142bb15 = EnumC0142bb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        c = EnumSet.of(enumC0142bb14, enumC0142bb4, enumC0142bb5, enumC0142bb12, enumC0142bb15);
        EnumC0142bb enumC0142bb16 = EnumC0142bb.EVENT_TYPE_REGULAR;
        d = EnumSet.of(enumC0142bb4, enumC0142bb5, enumC0142bb3, enumC0142bb, enumC0142bb2, enumC0142bb15, enumC0142bb12, enumC0142bb16, EnumC0142bb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, EnumC0142bb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, EnumC0142bb.EVENT_TYPE_SEND_REVENUE_EVENT, EnumC0142bb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, enumC0142bb8, EnumC0142bb.EVENT_TYPE_INIT, EnumC0142bb.EVENT_TYPE_SEND_USER_PROFILE, EnumC0142bb.EVENT_TYPE_SET_USER_PROFILE_ID, enumC0142bb9, enumC0142bb10, enumC0142bb11, EnumC0142bb.EVENT_TYPE_FIRST_ACTIVATION, EnumC0142bb.EVENT_TYPE_START, EnumC0142bb.EVENT_TYPE_APP_OPEN, EnumC0142bb.EVENT_TYPE_APP_UPDATE, enumC0142bb6);
        e = EnumSet.of(enumC0142bb16);
        f = EnumSet.of(enumC0142bb16);
        g = EnumSet.of(enumC0142bb12);
        h = EnumSet.of(EnumC0142bb.EVENT_TYPE_ALIVE, enumC0142bb8, enumC0142bb13, enumC0142bb5, enumC0142bb12);
        i = Arrays.asList(0, 6145, Integer.valueOf((int) FragmentTransaction.TRANSIT_FRAGMENT_OPEN), 8224);
        EnumC0142bb enumC0142bb17 = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        j = Arrays.asList(12290);
    }
}
