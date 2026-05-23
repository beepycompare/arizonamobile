package com.arkivanov.decompose;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DeeplinkUtils.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/arkivanov/decompose/HandleDeepLinkDefaults;", "", "<init>", "()V", "shouldRestartInNewTask", "", "activity", "Landroid/app/Activity;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HandleDeepLinkDefaults {
    public static final HandleDeepLinkDefaults INSTANCE = new HandleDeepLinkDefaults();

    private HandleDeepLinkDefaults() {
    }

    public final boolean shouldRestartInNewTask(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return (activity.getIntent().getFlags() & 268435456) != 0 && (activity.getIntent().getFlags() & 32768) == 0;
    }
}
