package com.adjust.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class SystemLifecycle implements Application.ActivityLifecycleCallbacks {
    private static volatile SystemLifecycle instance;
    private Application application = null;
    private volatile SystemLifecycleCallback callback;
    private final SystemLifecycleCache callbackCache;
    public final CopyOnWriteArrayList<String> logMessageList;

    /* loaded from: classes3.dex */
    public static class SystemLifecycleCache implements SystemLifecycleCallback {
        public volatile Boolean foregroundOrElseBackgroundCache = null;

        @Override // com.adjust.sdk.SystemLifecycle.SystemLifecycleCallback
        public void onActivityLifecycle(boolean z) {
            this.foregroundOrElseBackgroundCache = Boolean.valueOf(z);
        }
    }

    /* loaded from: classes3.dex */
    public interface SystemLifecycleCallback {
        void onActivityLifecycle(boolean z);
    }

    public SystemLifecycle() {
        SystemLifecycleCache systemLifecycleCache = new SystemLifecycleCache();
        this.callbackCache = systemLifecycleCache;
        this.callback = systemLifecycleCache;
        this.logMessageList = new CopyOnWriteArrayList<>();
    }

    public static SystemLifecycle getSingletonInstance() {
        SystemLifecycle systemLifecycle;
        SystemLifecycle systemLifecycle2 = instance;
        if (systemLifecycle2 == null) {
            synchronized (SystemLifecycle.class) {
                systemLifecycle = instance;
                if (systemLifecycle == null) {
                    systemLifecycle = new SystemLifecycle();
                    instance = systemLifecycle;
                }
            }
            return systemLifecycle;
        }
        return systemLifecycle2;
    }

    public Boolean foregroundOrElseBackgroundCached() {
        return this.callbackCache.foregroundOrElseBackgroundCache;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.callback.onActivityLifecycle(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.callback.onActivityLifecycle(true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public void overwriteCallback(SystemLifecycleCallback systemLifecycleCallback) {
        this.callback = systemLifecycleCallback;
    }

    public synchronized void registerActivityLifecycleCallbacks(Context context) {
        if (this.application != null) {
            this.logMessageList.add("Cannot register activity lifecycle callbacks more than once");
        } else if (context == null) {
            this.logMessageList.add("Cannot register activity lifecycle callbacks without context");
        } else {
            Context applicationContext = context.getApplicationContext();
            if (!(applicationContext instanceof Application)) {
                this.logMessageList.add("Cannot register activity lifecycle callbacks without application context as Application");
                return;
            }
            this.logMessageList.add("Registering activity lifecycle callbacks");
            Application application = (Application) applicationContext;
            this.application = application;
            application.registerActivityLifecycleCallbacks(this);
        }
    }
}
