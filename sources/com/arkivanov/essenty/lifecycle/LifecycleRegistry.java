package com.arkivanov.essenty.lifecycle;

import com.arkivanov.essenty.lifecycle.Lifecycle;
import kotlin.Metadata;
/* compiled from: LifecycleRegistry.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/arkivanov/essenty/lifecycle/LifecycleRegistry;", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "Lcom/arkivanov/essenty/lifecycle/Lifecycle$Callbacks;", "lifecycle_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LifecycleRegistry extends Lifecycle, Lifecycle.Callbacks {

    /* compiled from: LifecycleRegistry.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static void onCreate(LifecycleRegistry lifecycleRegistry) {
            Lifecycle.Callbacks.DefaultImpls.onCreate(lifecycleRegistry);
        }

        public static void onDestroy(LifecycleRegistry lifecycleRegistry) {
            Lifecycle.Callbacks.DefaultImpls.onDestroy(lifecycleRegistry);
        }

        public static void onPause(LifecycleRegistry lifecycleRegistry) {
            Lifecycle.Callbacks.DefaultImpls.onPause(lifecycleRegistry);
        }

        public static void onResume(LifecycleRegistry lifecycleRegistry) {
            Lifecycle.Callbacks.DefaultImpls.onResume(lifecycleRegistry);
        }

        public static void onStart(LifecycleRegistry lifecycleRegistry) {
            Lifecycle.Callbacks.DefaultImpls.onStart(lifecycleRegistry);
        }

        public static void onStop(LifecycleRegistry lifecycleRegistry) {
            Lifecycle.Callbacks.DefaultImpls.onStop(lifecycleRegistry);
        }
    }
}
