package io.appmetrica.analytics.impl;

import android.app.Application;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lio/appmetrica/analytics/impl/Ff;", "Lio/appmetrica/analytics/impl/Df;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "analytics_binaryProdRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class Ff implements Df {
    @Override // io.appmetrica.analytics.impl.Df
    public String a() {
        return Application.getProcessName();
    }
}
