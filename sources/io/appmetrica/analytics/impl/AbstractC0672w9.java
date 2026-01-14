package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.w9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0672w9 {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f1285a;
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
        EnumC0143bb enumC0143bb = EnumC0143bb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        EnumC0143bb enumC0143bb2 = EnumC0143bb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        EnumC0143bb enumC0143bb3 = EnumC0143bb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        EnumC0143bb enumC0143bb4 = EnumC0143bb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC0143bb enumC0143bb5 = EnumC0143bb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC0143bb enumC0143bb6 = EnumC0143bb.EVENT_TYPE_ANR;
        f1285a = CollectionUtils.unmodifiableSetOf(5892, 5896, 5891, 5889, 5890, 5968);
        EnumC0143bb enumC0143bb7 = EnumC0143bb.EVENT_TYPE_UNDEFINED;
        EnumC0143bb enumC0143bb8 = EnumC0143bb.EVENT_TYPE_PURGE_BUFFER;
        EnumC0143bb enumC0143bb9 = EnumC0143bb.EVENT_TYPE_SEND_REFERRER;
        EnumC0143bb enumC0143bb10 = EnumC0143bb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        EnumC0143bb enumC0143bb11 = EnumC0143bb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        EnumC0143bb enumC0143bb12 = EnumC0143bb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        EnumC0143bb enumC0143bb13 = EnumC0143bb.EVENT_TYPE_SET_SESSION_EXTRA;
        b = EnumSet.of(enumC0143bb7, enumC0143bb8, enumC0143bb9, enumC0143bb10, enumC0143bb11, EnumC0143bb.EVENT_TYPE_ACTIVATION, enumC0143bb12, enumC0143bb5, enumC0143bb13);
        EnumC0143bb enumC0143bb14 = EnumC0143bb.EVENT_TYPE_UPDATE_FOREGROUND_TIME;
        EnumC0143bb enumC0143bb15 = EnumC0143bb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        c = EnumSet.of(enumC0143bb14, enumC0143bb4, enumC0143bb5, enumC0143bb12, enumC0143bb15);
        EnumC0143bb enumC0143bb16 = EnumC0143bb.EVENT_TYPE_REGULAR;
        d = EnumSet.of(enumC0143bb4, enumC0143bb5, enumC0143bb3, enumC0143bb, enumC0143bb2, enumC0143bb15, enumC0143bb12, enumC0143bb16, EnumC0143bb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, EnumC0143bb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, EnumC0143bb.EVENT_TYPE_SEND_REVENUE_EVENT, EnumC0143bb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, enumC0143bb8, EnumC0143bb.EVENT_TYPE_INIT, EnumC0143bb.EVENT_TYPE_SEND_USER_PROFILE, EnumC0143bb.EVENT_TYPE_SET_USER_PROFILE_ID, enumC0143bb9, enumC0143bb10, enumC0143bb11, EnumC0143bb.EVENT_TYPE_FIRST_ACTIVATION, EnumC0143bb.EVENT_TYPE_START, EnumC0143bb.EVENT_TYPE_APP_OPEN, EnumC0143bb.EVENT_TYPE_APP_UPDATE, enumC0143bb6);
        e = EnumSet.of(enumC0143bb16);
        f = EnumSet.of(enumC0143bb16);
        g = EnumSet.of(enumC0143bb12);
        h = EnumSet.of(EnumC0143bb.EVENT_TYPE_ALIVE, enumC0143bb8, enumC0143bb13, enumC0143bb5, enumC0143bb12);
        i = Arrays.asList(0, 6145, Integer.valueOf((int) FragmentTransaction.TRANSIT_FRAGMENT_OPEN), 8224);
        EnumC0143bb enumC0143bb17 = EnumC0143bb.EVENT_TYPE_UNDEFINED;
        j = Arrays.asList(12290);
    }
}
