package io.appmetrica.analytics.coreapi.internal.executors;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public interface IHandlerExecutor extends ICommonExecutor {
    Handler getHandler();

    Looper getLooper();
}
