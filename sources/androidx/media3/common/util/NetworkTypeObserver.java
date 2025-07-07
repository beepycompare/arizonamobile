package androidx.media3.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.media3.common.util.NetworkTypeObserver;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public final class NetworkTypeObserver {
    private static NetworkTypeObserver staticInstance;
    private final Executor backgroundExecutor;
    private boolean isInitialized;
    private final CopyOnWriteArrayList<ListenerHolder> listeners;
    private final Object lock;
    private int networkType;

    /* loaded from: classes2.dex */
    public interface Listener {
        void onNetworkTypeChanged(int i);
    }

    public static synchronized NetworkTypeObserver getInstance(Context context) {
        NetworkTypeObserver networkTypeObserver;
        synchronized (NetworkTypeObserver.class) {
            if (staticInstance == null) {
                staticInstance = new NetworkTypeObserver(context);
            }
            networkTypeObserver = staticInstance;
        }
        return networkTypeObserver;
    }

    public static synchronized void resetForTests() {
        synchronized (NetworkTypeObserver.class) {
            staticInstance = null;
        }
    }

    private NetworkTypeObserver(final Context context) {
        Executor executor = BackgroundExecutor.get();
        this.backgroundExecutor = executor;
        this.listeners = new CopyOnWriteArrayList<>();
        this.lock = new Object();
        this.networkType = 0;
        executor.execute(new Runnable() { // from class: androidx.media3.common.util.NetworkTypeObserver$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                NetworkTypeObserver.this.m7302lambda$new$0$androidxmedia3commonutilNetworkTypeObserver(context);
            }
        });
    }

    @Deprecated
    public void register(Listener listener) {
        final Handler handler = new Handler(Looper.getMainLooper());
        register(listener, new Executor() { // from class: androidx.media3.common.util.NetworkTypeObserver$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        });
    }

    public void register(Listener listener, Executor executor) {
        boolean z;
        removeClearedReferences();
        ListenerHolder listenerHolder = new ListenerHolder(listener, executor);
        synchronized (this.lock) {
            this.listeners.add(listenerHolder);
            z = this.isInitialized;
        }
        if (z) {
            listenerHolder.callOnNetworkTypeChanged();
        }
    }

    public int getNetworkType() {
        int i;
        synchronized (this.lock) {
            i = this.networkType;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: init */
    public void m7302lambda$new$0$androidxmedia3commonutilNetworkTypeObserver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new Receiver(), intentFilter);
    }

    private void removeClearedReferences() {
        Iterator<ListenerHolder> it = this.listeners.iterator();
        while (it.hasNext()) {
            ListenerHolder next = it.next();
            if (next.canBeRemoved()) {
                this.listeners.remove(next);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleConnectivityActionBroadcast(Context context) {
        int networkTypeFromConnectivityManager = getNetworkTypeFromConnectivityManager(context);
        if (Util.SDK_INT >= 31 && networkTypeFromConnectivityManager == 5) {
            Api31.disambiguate4gAnd5gNsa(context, this);
        } else {
            updateNetworkType(networkTypeFromConnectivityManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNetworkType(int i) {
        removeClearedReferences();
        synchronized (this.lock) {
            if (this.isInitialized && this.networkType == i) {
                return;
            }
            this.isInitialized = true;
            this.networkType = i;
            Iterator<ListenerHolder> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().callOnNetworkTypeChanged();
            }
        }
    }

    private static int getNetworkTypeFromConnectivityManager(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (type != 4 && type != 5) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return getMobileNetworkType(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i;
    }

    private static int getMobileNetworkType(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 16:
            case 19:
            default:
                return 6;
            case 18:
                return 2;
            case 20:
                return Util.SDK_INT >= 29 ? 9 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class Receiver extends BroadcastReceiver {
        private Receiver() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onReceive$0$androidx-media3-common-util-NetworkTypeObserver$Receiver  reason: not valid java name */
        public /* synthetic */ void m7304x90e623c9(Context context) {
            NetworkTypeObserver.this.handleConnectivityActionBroadcast(context);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, Intent intent) {
            NetworkTypeObserver.this.backgroundExecutor.execute(new Runnable() { // from class: androidx.media3.common.util.NetworkTypeObserver$Receiver$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    NetworkTypeObserver.Receiver.this.m7304x90e623c9(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Api31 {
        private Api31() {
        }

        public static void disambiguate4gAnd5gNsa(Context context, NetworkTypeObserver networkTypeObserver) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) Assertions.checkNotNull((TelephonyManager) context.getSystemService("phone"));
                DisplayInfoCallback displayInfoCallback = new DisplayInfoCallback(networkTypeObserver);
                telephonyManager.registerTelephonyCallback(networkTypeObserver.backgroundExecutor, displayInfoCallback);
                telephonyManager.unregisterTelephonyCallback(displayInfoCallback);
            } catch (RuntimeException unused) {
                networkTypeObserver.updateNetworkType(5);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class DisplayInfoCallback extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {
            private final NetworkTypeObserver instance;

            public DisplayInfoCallback(NetworkTypeObserver networkTypeObserver) {
                this.instance = networkTypeObserver;
            }

            @Override // android.telephony.TelephonyCallback.DisplayInfoListener
            public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                this.instance.updateNetworkType(overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5 ? 10 : 5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class ListenerHolder {
        private final Executor executor;
        private final WeakReference<Listener> listener;

        public ListenerHolder(Listener listener, Executor executor) {
            this.listener = new WeakReference<>(listener);
            this.executor = executor;
        }

        public boolean canBeRemoved() {
            return this.listener.get() == null;
        }

        public void callOnNetworkTypeChanged() {
            this.executor.execute(new Runnable() { // from class: androidx.media3.common.util.NetworkTypeObserver$ListenerHolder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    NetworkTypeObserver.ListenerHolder.this.m7303x7c19281b();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$callOnNetworkTypeChanged$0$androidx-media3-common-util-NetworkTypeObserver$ListenerHolder  reason: not valid java name */
        public /* synthetic */ void m7303x7c19281b() {
            Listener listener = this.listener.get();
            if (listener != null) {
                listener.onNetworkTypeChanged(NetworkTypeObserver.this.getNetworkType());
            }
        }
    }
}
