package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
import java.util.Set;
import kotlin.collections.SetsKt;
/* loaded from: classes5.dex */
public abstract class Eo {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f533a;

    static {
        Db db = Db.EVENT_TYPE_UNDEFINED;
        f533a = SetsKt.setOf((Object[]) new Integer[]{42, 8224, 6145, 0, 40977, 41000, Integer.valueOf((int) FragmentTransaction.TRANSIT_FRAGMENT_OPEN), 40976});
    }

    public static final Set a() {
        return f533a;
    }
}
