package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.PreloadInfo;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Uf {

    /* renamed from: a  reason: collision with root package name */
    public final Qf f795a;

    public Uf(PreloadInfo preloadInfo, PublicLogger publicLogger, boolean z) {
        if (preloadInfo != null) {
            if (StringUtils.isNullOrEmpty(preloadInfo.getTrackingId())) {
                publicLogger.error("Required field \"PreloadInfo.trackingId\" is empty!\nThis preload info will be skipped.", new Object[0]);
            } else {
                this.f795a = new Qf(preloadInfo.getTrackingId(), new JSONObject(preloadInfo.getAdditionalParams()), true, z, EnumC0398l8.d);
            }
        }
    }
}
