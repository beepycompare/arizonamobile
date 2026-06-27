package io.appmetrica.analytics.impl;

import com.miami.game.core.firebase.notification.NotificationStatsStore;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class M7 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f660a;

    public M7() {
        HashMap hashMap = new HashMap();
        this.f660a = hashMap;
        hashMap.put(NotificationStatsStore.KEY_EVENTS, I5.f589a);
        hashMap.put("sessions", K5.f624a);
        hashMap.put("preferences", J5.f606a);
        hashMap.put("binary_data", H5.f572a);
    }
}
