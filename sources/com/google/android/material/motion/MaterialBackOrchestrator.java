package com.google.android.material.motion;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.BackEventCompat;
import java.util.Objects;
/* loaded from: classes4.dex */
public final class MaterialBackOrchestrator {
    private final BackCallbackDelegate backCallbackDelegate;
    private final MaterialBackHandler backHandler;
    private final View view;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface BackCallbackDelegate {
        void startListeningForBackCallbacks(MaterialBackHandler materialBackHandler, View view, boolean z);

        void stopListeningForBackCallbacks(View view);
    }

    public <T extends View & MaterialBackHandler> MaterialBackOrchestrator(T t) {
        this(t, t);
    }

    public MaterialBackOrchestrator(MaterialBackHandler materialBackHandler, View view) {
        this.backCallbackDelegate = createBackCallbackDelegate();
        this.backHandler = materialBackHandler;
        this.view = view;
    }

    public boolean shouldListenForBackCallbacks() {
        return this.backCallbackDelegate != null;
    }

    public void startListeningForBackCallbacksWithPriorityOverlay() {
        startListeningForBackCallbacks(true);
    }

    public void startListeningForBackCallbacks() {
        startListeningForBackCallbacks(false);
    }

    private void startListeningForBackCallbacks(boolean z) {
        BackCallbackDelegate backCallbackDelegate = this.backCallbackDelegate;
        if (backCallbackDelegate != null) {
            backCallbackDelegate.startListeningForBackCallbacks(this.backHandler, this.view, z);
        }
    }

    public void stopListeningForBackCallbacks() {
        BackCallbackDelegate backCallbackDelegate = this.backCallbackDelegate;
        if (backCallbackDelegate != null) {
            backCallbackDelegate.stopListeningForBackCallbacks(this.view);
        }
    }

    private static BackCallbackDelegate createBackCallbackDelegate() {
        if (Build.VERSION.SDK_INT >= 34) {
            return new Api34BackCallbackDelegate();
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return new Api33BackCallbackDelegate();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class Api34BackCallbackDelegate extends Api33BackCallbackDelegate {
        private Api34BackCallbackDelegate() {
            super();
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.Api33BackCallbackDelegate
        OnBackInvokedCallback createOnBackInvokedCallback(final MaterialBackHandler materialBackHandler) {
            return new OnBackAnimationCallback() { // from class: com.google.android.material.motion.MaterialBackOrchestrator.Api34BackCallbackDelegate.1
                public void onBackStarted(BackEvent backEvent) {
                    if (Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                        materialBackHandler.startBackProgress(new BackEventCompat(backEvent));
                    }
                }

                public void onBackProgressed(BackEvent backEvent) {
                    if (Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                        materialBackHandler.updateBackProgress(new BackEventCompat(backEvent));
                    }
                }

                public void onBackInvoked() {
                    materialBackHandler.handleBackInvoked();
                }

                public void onBackCancelled() {
                    if (Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                        materialBackHandler.cancelBackProgress();
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class Api33BackCallbackDelegate implements BackCallbackDelegate {
        private OnBackInvokedCallback onBackInvokedCallback;

        private Api33BackCallbackDelegate() {
        }

        boolean isListeningForBackCallbacks() {
            return this.onBackInvokedCallback != null;
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.BackCallbackDelegate
        public void startListeningForBackCallbacks(MaterialBackHandler materialBackHandler, View view, boolean z) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher;
            if (this.onBackInvokedCallback == null && (findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                OnBackInvokedCallback createOnBackInvokedCallback = createOnBackInvokedCallback(materialBackHandler);
                this.onBackInvokedCallback = createOnBackInvokedCallback;
                findOnBackInvokedDispatcher.registerOnBackInvokedCallback(z ? 1000000 : 0, createOnBackInvokedCallback);
            }
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.BackCallbackDelegate
        public void stopListeningForBackCallbacks(View view) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (findOnBackInvokedDispatcher == null) {
                return;
            }
            findOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.onBackInvokedCallback);
            this.onBackInvokedCallback = null;
        }

        OnBackInvokedCallback createOnBackInvokedCallback(final MaterialBackHandler materialBackHandler) {
            Objects.requireNonNull(materialBackHandler);
            return new OnBackInvokedCallback() { // from class: com.google.android.material.motion.MaterialBackOrchestrator$Api33BackCallbackDelegate$$ExternalSyntheticLambda0
                public final void onBackInvoked() {
                    MaterialBackHandler.this.handleBackInvoked();
                }
            };
        }
    }
}
