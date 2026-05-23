package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes5.dex */
public abstract class Q9 {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f727a;
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
        Db db = Db.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        Db db2 = Db.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        Db db3 = Db.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        Db db4 = Db.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        Db db5 = Db.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        Db db6 = Db.EVENT_TYPE_ANR;
        f727a = CollectionUtils.unmodifiableSetOf(5892, 5896, 5891, 5889, 5890, 5968);
        Db db7 = Db.EVENT_TYPE_UNDEFINED;
        Db db8 = Db.EVENT_TYPE_PURGE_BUFFER;
        Db db9 = Db.EVENT_TYPE_SEND_REFERRER;
        Db db10 = Db.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        Db db11 = Db.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        Db db12 = Db.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        Db db13 = Db.EVENT_TYPE_SET_SESSION_EXTRA;
        b = EnumSet.of(db7, db8, db9, db10, db11, Db.EVENT_TYPE_ACTIVATION, db12, db5, db13);
        Db db14 = Db.EVENT_TYPE_UPDATE_FOREGROUND_TIME;
        Db db15 = Db.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        c = EnumSet.of(db14, db4, db5, db12, db15);
        Db db16 = Db.EVENT_TYPE_REGULAR;
        d = EnumSet.of(db4, db5, db3, db, db2, db15, db12, db16, Db.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, Db.EVENT_TYPE_SEND_ECOMMERCE_EVENT, Db.EVENT_TYPE_SEND_REVENUE_EVENT, Db.EVENT_TYPE_SEND_AD_REVENUE_EVENT, db8, Db.EVENT_TYPE_INIT, Db.EVENT_TYPE_SEND_USER_PROFILE, Db.EVENT_TYPE_SET_USER_PROFILE_ID, db9, db10, db11, Db.EVENT_TYPE_FIRST_ACTIVATION, Db.EVENT_TYPE_START, Db.EVENT_TYPE_APP_OPEN, Db.EVENT_TYPE_APP_UPDATE, db6);
        e = EnumSet.of(db16);
        f = EnumSet.of(db16);
        g = EnumSet.of(db12);
        h = EnumSet.of(Db.EVENT_TYPE_ALIVE, db8, db13, db5, db12);
        i = Arrays.asList(0, 6145, Integer.valueOf((int) FragmentTransaction.TRANSIT_FRAGMENT_OPEN), 8224);
        Db db17 = Db.EVENT_TYPE_UNDEFINED;
        j = Arrays.asList(12290);
    }
}
