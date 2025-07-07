package com.arkivanov.essenty.lifecycle;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LifecycleRegistryExt.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002¨\u0006\b"}, d2 = {"create", "", "Lcom/arkivanov/essenty/lifecycle/LifecycleRegistry;", TtmlNode.START, "resume", "pause", "stop", "destroy", "lifecycle_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LifecycleRegistryExtKt {
    public static final void create(LifecycleRegistry lifecycleRegistry) {
        Intrinsics.checkNotNullParameter(lifecycleRegistry, "<this>");
        if (lifecycleRegistry.getState() == Lifecycle.State.INITIALIZED) {
            lifecycleRegistry.onCreate();
        }
    }

    public static final void start(LifecycleRegistry lifecycleRegistry) {
        Intrinsics.checkNotNullParameter(lifecycleRegistry, "<this>");
        create(lifecycleRegistry);
        if (lifecycleRegistry.getState() == Lifecycle.State.CREATED) {
            lifecycleRegistry.onStart();
        }
    }

    public static final void resume(LifecycleRegistry lifecycleRegistry) {
        Intrinsics.checkNotNullParameter(lifecycleRegistry, "<this>");
        start(lifecycleRegistry);
        if (lifecycleRegistry.getState() == Lifecycle.State.STARTED) {
            lifecycleRegistry.onResume();
        }
    }

    public static final void pause(LifecycleRegistry lifecycleRegistry) {
        Intrinsics.checkNotNullParameter(lifecycleRegistry, "<this>");
        if (lifecycleRegistry.getState() == Lifecycle.State.RESUMED) {
            lifecycleRegistry.onPause();
        }
    }

    public static final void stop(LifecycleRegistry lifecycleRegistry) {
        Intrinsics.checkNotNullParameter(lifecycleRegistry, "<this>");
        pause(lifecycleRegistry);
        if (lifecycleRegistry.getState() == Lifecycle.State.STARTED) {
            lifecycleRegistry.onStop();
        }
    }

    public static final void destroy(LifecycleRegistry lifecycleRegistry) {
        Intrinsics.checkNotNullParameter(lifecycleRegistry, "<this>");
        stop(lifecycleRegistry);
        if (lifecycleRegistry.getState() == Lifecycle.State.CREATED) {
            lifecycleRegistry.onDestroy();
        }
    }
}
