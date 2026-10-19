package io.appmetrica.analytics.impl;

import com.miami.game.core.firebase.notification.NotificationStatsStore;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class M7 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f665a;

    public M7() {
        HashMap hashMap = new HashMap();
        this.f665a = hashMap;
        hashMap.put(NotificationStatsStore.KEY_EVENTS, I5.f594a);
        hashMap.put("sessions", K5.f629a);
        hashMap.put("preferences", J5.f611a);
        hashMap.put("binary_data", H5.f577a);
    }
}
