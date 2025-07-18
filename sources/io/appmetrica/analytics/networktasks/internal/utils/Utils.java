package io.appmetrica.analytics.networktasks.internal.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lio/appmetrica/analytics/networktasks/internal/utils/Utils;", "", "", "code", "", "isBadRequest", "network-tasks_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class Utils {
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    @JvmStatic
    public static final boolean isBadRequest(int i) {
        return i == 400;
    }
}
