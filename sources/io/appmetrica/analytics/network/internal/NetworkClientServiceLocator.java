package io.appmetrica.analytics.network.internal;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* loaded from: classes5.dex */
public class NetworkClientServiceLocator {
    private static volatile NetworkClientServiceLocator b;

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f1368a;

    NetworkClientServiceLocator(Bundle bundle) {
        this.f1368a = bundle;
    }

    public static NetworkClientServiceLocator getInstance() {
        return b;
    }

    public static void init(Context context) {
        init(context, new SafePackageManager());
    }

    public Bundle getApplicationMetaData() {
        return this.f1368a;
    }

    public static void init(Context context, SafePackageManager safePackageManager) {
        if (b == null) {
            synchronized (NetworkClientServiceLocator.class) {
                if (b == null) {
                    b = new NetworkClientServiceLocator(safePackageManager.getApplicationMetaData(context));
                }
            }
        }
    }
}
