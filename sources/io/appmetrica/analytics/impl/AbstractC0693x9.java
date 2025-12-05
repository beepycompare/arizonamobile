package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.x9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0693x9 {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f1280a;
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
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        EnumC0164cb enumC0164cb2 = EnumC0164cb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        EnumC0164cb enumC0164cb3 = EnumC0164cb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        EnumC0164cb enumC0164cb4 = EnumC0164cb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC0164cb enumC0164cb5 = EnumC0164cb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC0164cb enumC0164cb6 = EnumC0164cb.EVENT_TYPE_ANR;
        f1280a = CollectionUtils.unmodifiableSetOf(5892, 5896, 5891, 5889, 5890, 5968);
        EnumC0164cb enumC0164cb7 = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        EnumC0164cb enumC0164cb8 = EnumC0164cb.EVENT_TYPE_PURGE_BUFFER;
        EnumC0164cb enumC0164cb9 = EnumC0164cb.EVENT_TYPE_SEND_REFERRER;
        EnumC0164cb enumC0164cb10 = EnumC0164cb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        EnumC0164cb enumC0164cb11 = EnumC0164cb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        EnumC0164cb enumC0164cb12 = EnumC0164cb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        EnumC0164cb enumC0164cb13 = EnumC0164cb.EVENT_TYPE_SET_SESSION_EXTRA;
        b = EnumSet.of(enumC0164cb7, enumC0164cb8, enumC0164cb9, enumC0164cb10, enumC0164cb11, EnumC0164cb.EVENT_TYPE_ACTIVATION, enumC0164cb12, enumC0164cb5, enumC0164cb13);
        EnumC0164cb enumC0164cb14 = EnumC0164cb.EVENT_TYPE_UPDATE_FOREGROUND_TIME;
        EnumC0164cb enumC0164cb15 = EnumC0164cb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        c = EnumSet.of(enumC0164cb14, enumC0164cb4, enumC0164cb5, enumC0164cb12, enumC0164cb15);
        EnumC0164cb enumC0164cb16 = EnumC0164cb.EVENT_TYPE_REGULAR;
        d = EnumSet.of(enumC0164cb4, enumC0164cb5, enumC0164cb3, enumC0164cb, enumC0164cb2, enumC0164cb15, enumC0164cb12, enumC0164cb16, EnumC0164cb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, EnumC0164cb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, EnumC0164cb.EVENT_TYPE_SEND_REVENUE_EVENT, EnumC0164cb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, enumC0164cb8, EnumC0164cb.EVENT_TYPE_INIT, EnumC0164cb.EVENT_TYPE_SEND_USER_PROFILE, EnumC0164cb.EVENT_TYPE_SET_USER_PROFILE_ID, enumC0164cb9, enumC0164cb10, enumC0164cb11, EnumC0164cb.EVENT_TYPE_FIRST_ACTIVATION, EnumC0164cb.EVENT_TYPE_START, EnumC0164cb.EVENT_TYPE_APP_OPEN, EnumC0164cb.EVENT_TYPE_APP_UPDATE, enumC0164cb6);
        e = EnumSet.of(enumC0164cb16);
        f = EnumSet.of(enumC0164cb16);
        g = EnumSet.of(enumC0164cb12);
        h = EnumSet.of(EnumC0164cb.EVENT_TYPE_ALIVE, enumC0164cb8, enumC0164cb13, enumC0164cb5, enumC0164cb12);
        i = Arrays.asList(0, 6145, Integer.valueOf((int) FragmentTransaction.TRANSIT_FRAGMENT_OPEN), 8224);
        EnumC0164cb enumC0164cb17 = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        j = Arrays.asList(12290);
    }
}
