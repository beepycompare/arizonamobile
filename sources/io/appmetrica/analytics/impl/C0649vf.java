package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.PreloadInfo;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.vf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0649vf {

    /* renamed from: a  reason: collision with root package name */
    public final C0549rf f1252a;

    public C0649vf(PreloadInfo preloadInfo, PublicLogger publicLogger, boolean z) {
        if (preloadInfo != null) {
            if (TextUtils.isEmpty(preloadInfo.getTrackingId())) {
                publicLogger.error("Required field \"PreloadInfo.trackingId\" is empty!\nThis preload info will be skipped.", new Object[0]);
            } else {
                this.f1252a = new C0549rf(preloadInfo.getTrackingId(), new JSONObject(preloadInfo.getAdditionalParams()), true, z, T7.c);
            }
        }
    }
}
