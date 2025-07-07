package io.appmetrica.analytics.impl;

import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public abstract class O5 {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f563a;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.REFERRER_API_GOOGLE, AdTrackingInfo.Provider.GOOGLE);
        hashMap.put("huawei", AdTrackingInfo.Provider.HMS);
        hashMap.put("yandex", AdTrackingInfo.Provider.YANDEX);
        f563a = Collections.unmodifiableMap(hashMap);
    }
}
