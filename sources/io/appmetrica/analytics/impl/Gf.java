package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.PreloadInfo;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Gf {

    /* renamed from: a  reason: collision with root package name */
    public final Cf f445a;

    public Gf(PreloadInfo preloadInfo, PublicLogger publicLogger, boolean z) {
        if (preloadInfo != null) {
            if (TextUtils.isEmpty(preloadInfo.getTrackingId())) {
                publicLogger.error("Required field \"PreloadInfo.trackingId\" is empty!\nThis preload info will be skipped.", new Object[0]);
            } else {
                this.f445a = new Cf(preloadInfo.getTrackingId(), new JSONObject(preloadInfo.getAdditionalParams()), true, z, EnumC0327i8.c);
            }
        }
    }
}
