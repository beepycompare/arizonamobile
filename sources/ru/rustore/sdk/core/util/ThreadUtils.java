package ru.rustore.sdk.core.util;

import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ThreadUtils.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lru/rustore/sdk/core/util/ThreadUtils;", "", "()V", "checkNonMainThread", "", "sdk-public-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ThreadUtils {
    public static final ThreadUtils INSTANCE = new ThreadUtils();

    private ThreadUtils() {
    }

    public final void checkNonMainThread() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            throw new IllegalStateException("Expected to be called not on main thread".toString());
        }
    }
}
