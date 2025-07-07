package io.appmetrica.analytics.coreutils.internal.toggle;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003¨\u0006\n"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/toggle/OuterStateToggle;", "Lio/appmetrica/analytics/coreutils/internal/toggle/SimpleThreadSafeToggle;", "initialState", "", "tag", "", "(ZLjava/lang/String;)V", "update", "", RemoteConfigConstants.ResponseFieldKey.STATE, "core-utils_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OuterStateToggle extends SimpleThreadSafeToggle {
    public OuterStateToggle(boolean z, String str) {
        super(z, str);
    }

    public final void update(boolean z) {
        super.updateState(z);
    }
}
