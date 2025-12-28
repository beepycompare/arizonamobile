package androidx.media3.common.util;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Looper;
import androidx.media3.common.util.WifiLockManager;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class WifiLockManager {
    private static final String TAG = "WifiLockManager";
    private static final int UNREACTIVE_WIFILOCK_HANDLER_RELEASE_DELAY_MS = 1000;
    private static final String WIFI_LOCK_TAG = "ExoPlayer:WifiLockManager";
    private boolean enabled;
    private final HandlerWrapper mainHandler;
    private boolean stayAwake;
    private final HandlerWrapper wifiLockHandler;
    private final WifiLockManagerInternal wifiLockManagerInternal;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldAcquireWifilock(boolean z, boolean z2) {
        return z && z2;
    }

    public WifiLockManager(Context context, Looper looper, Clock clock) {
        this.wifiLockManagerInternal = new WifiLockManagerInternal(context.getApplicationContext());
        this.wifiLockHandler = clock.createHandler(looper, null);
        this.mainHandler = clock.createHandler(Looper.getMainLooper(), null);
    }

    public void setEnabled(boolean z) {
        if (this.enabled == z) {
            return;
        }
        this.enabled = z;
        postUpdateWifiLock(z, this.stayAwake);
    }

    public void setStayAwake(boolean z) {
        if (this.stayAwake == z) {
            return;
        }
        this.stayAwake = z;
        if (this.enabled) {
            postUpdateWifiLock(true, z);
        }
    }

    private void postUpdateWifiLock(final boolean z, final boolean z2) {
        if (shouldAcquireWifilock(z, z2)) {
            this.wifiLockHandler.post(new Runnable() { // from class: androidx.media3.common.util.WifiLockManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    WifiLockManager.this.m8900xfd5ac0b8(z, z2);
                }
            });
            return;
        }
        final WifiLockManagerInternal wifiLockManagerInternal = this.wifiLockManagerInternal;
        Objects.requireNonNull(wifiLockManagerInternal);
        final Runnable runnable = new Runnable() { // from class: androidx.media3.common.util.WifiLockManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                WifiLockManager.WifiLockManagerInternal.this.forceReleaseWifiLock();
            }
        };
        this.mainHandler.postDelayed(runnable, 1000L);
        this.wifiLockHandler.post(new Runnable() { // from class: androidx.media3.common.util.WifiLockManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                WifiLockManager.this.m8901x329c45ba(runnable, z, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$postUpdateWifiLock$0$androidx-media3-common-util-WifiLockManager  reason: not valid java name */
    public /* synthetic */ void m8900xfd5ac0b8(boolean z, boolean z2) {
        this.wifiLockManagerInternal.updateWifiLock(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$postUpdateWifiLock$2$androidx-media3-common-util-WifiLockManager  reason: not valid java name */
    public /* synthetic */ void m8901x329c45ba(Runnable runnable, boolean z, boolean z2) {
        this.mainHandler.removeCallbacks(runnable);
        this.wifiLockManagerInternal.updateWifiLock(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class WifiLockManagerInternal {
        private final Context applicationContext;
        private WifiManager.WifiLock wifiLock;

        public WifiLockManagerInternal(Context context) {
            this.applicationContext = context;
        }

        public void updateWifiLock(boolean z, boolean z2) {
            if (z && this.wifiLock == null) {
                if (this.applicationContext.checkSelfPermission("android.permission.WAKE_LOCK") != 0) {
                    Log.w(WifiLockManager.TAG, "WAKE_LOCK permission not granted, can't acquire wake lock for playback");
                    return;
                }
                WifiManager wifiManager = (WifiManager) this.applicationContext.getApplicationContext().getSystemService("wifi");
                if (wifiManager == null) {
                    Log.w(WifiLockManager.TAG, "WifiManager is null, therefore not creating the WifiLock.");
                    return;
                }
                WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, WifiLockManager.WIFI_LOCK_TAG);
                this.wifiLock = createWifiLock;
                createWifiLock.setReferenceCounted(false);
            }
            if (this.wifiLock == null) {
                return;
            }
            if (WifiLockManager.shouldAcquireWifilock(z, z2)) {
                this.wifiLock.acquire();
            } else {
                this.wifiLock.release();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void forceReleaseWifiLock() {
            WifiManager.WifiLock wifiLock = this.wifiLock;
            if (wifiLock != null) {
                wifiLock.release();
            }
        }
    }
}
