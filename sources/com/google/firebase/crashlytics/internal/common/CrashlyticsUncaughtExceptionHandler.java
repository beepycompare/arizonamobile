package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private final CrashListener crashListener;
    private final Thread.UncaughtExceptionHandler defaultHandler;
    private final AtomicBoolean isHandlingException = new AtomicBoolean(false);
    private final CrashlyticsNativeComponent nativeComponent;
    private final SettingsProvider settingsProvider;

    /* loaded from: classes4.dex */
    interface CrashListener {
        void onUncaughtException(SettingsProvider settingsProvider, Thread thread, Throwable th);
    }

    public CrashlyticsUncaughtExceptionHandler(CrashListener crashListener, SettingsProvider settingsProvider, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, CrashlyticsNativeComponent crashlyticsNativeComponent) {
        this.crashListener = crashListener;
        this.settingsProvider = settingsProvider;
        this.defaultHandler = uncaughtExceptionHandler;
        this.nativeComponent = crashlyticsNativeComponent;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this.isHandlingException.set(true);
        try {
            try {
                if (shouldRecordUncaughtException(thread, th)) {
                    this.crashListener.onUncaughtException(this.settingsProvider, thread, th);
                } else {
                    Logger.getLogger().d("Uncaught exception will not be recorded by Crashlytics.");
                }
                if (this.defaultHandler != null) {
                    Logger.getLogger().d("Completed exception processing. Invoking default exception handler.");
                    this.defaultHandler.uncaughtException(thread, th);
                } else {
                    Logger.getLogger().d("Completed exception processing, but no default exception handler.");
                    System.exit(1);
                }
                this.isHandlingException.set(false);
            } catch (Exception e) {
                Logger.getLogger().e("An error occurred in the uncaught exception handler", e);
                if (this.defaultHandler != null) {
                    Logger.getLogger().d("Completed exception processing. Invoking default exception handler.");
                    this.defaultHandler.uncaughtException(thread, th);
                } else {
                    Logger.getLogger().d("Completed exception processing, but no default exception handler.");
                    System.exit(1);
                }
                this.isHandlingException.set(false);
            }
        } catch (Throwable th2) {
            if (this.defaultHandler != null) {
                Logger.getLogger().d("Completed exception processing. Invoking default exception handler.");
                this.defaultHandler.uncaughtException(thread, th);
            } else {
                Logger.getLogger().d("Completed exception processing, but no default exception handler.");
                System.exit(1);
            }
            this.isHandlingException.set(false);
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isHandlingException() {
        return this.isHandlingException.get();
    }

    private boolean shouldRecordUncaughtException(Thread thread, Throwable th) {
        if (thread == null) {
            Logger.getLogger().e("Crashlytics will not record uncaught exception; null thread");
            return false;
        } else if (th == null) {
            Logger.getLogger().e("Crashlytics will not record uncaught exception; null throwable");
            return false;
        } else if (this.nativeComponent.hasCrashDataForCurrentSession()) {
            Logger.getLogger().d("Crashlytics will not record uncaught exception; native crash exists for session.");
            return false;
        } else {
            return true;
        }
    }
}
