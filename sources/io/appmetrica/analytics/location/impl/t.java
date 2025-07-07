package io.appmetrica.analytics.location.impl;

import android.location.Location;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.locationapi.internal.LocationFilter;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public LocationFilter f1194a;
    public Location d;
    public long e;
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    public final TimePassedChecker b = new TimePassedChecker();

    public t(LocationFilter locationFilter) {
        this.f1194a = locationFilter;
    }
}
