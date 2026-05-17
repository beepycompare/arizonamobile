package io.appmetrica.analytics.impl;

import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.v5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0642v5 {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f1273a;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.REFERRER_API_GOOGLE, AdTrackingInfo.Provider.GOOGLE);
        hashMap.put("huawei", AdTrackingInfo.Provider.HMS);
        hashMap.put("yandex", AdTrackingInfo.Provider.YANDEX);
        f1273a = Collections.unmodifiableMap(hashMap);
    }
}
