package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.media3.exoplayer.Renderer;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.ads_identifier.zzf;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads-identifier@@18.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public class AdvertisingIdClient {
    private static final Object zzg = new Object();
    private static volatile AdvertisingIdClient zzh;
    BlockingServiceConnection zza;
    zzf zzb;
    boolean zzc;
    final Object zzd;
    zzb zze;
    final long zzf;
    private final Context zzi;

    /* compiled from: com.google.android.gms:play-services-ads-identifier@@18.3.0 */
    /* loaded from: classes4.dex */
    public static final class Info {
        private final String zza;
        private final boolean zzb;

        @Deprecated
        public Info(String str, boolean z) {
            this.zza = str;
            this.zzb = z;
        }

        public String getId() {
            return this.zza;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzb;
        }

        public String toString() {
            String str = this.zza;
            int length = String.valueOf(str).length();
            boolean z = this.zzb;
            StringBuilder sb = new StringBuilder(length + 2 + String.valueOf(z).length());
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000L, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        Context context2;
        AdvertisingIdClient advertisingIdClient;
        zzd zzdVar;
        Throwable th;
        int i;
        long j;
        int i2;
        Info zzf;
        long elapsedRealtime;
        AdvertisingIdClient advertisingIdClient2 = zzh;
        if (advertisingIdClient2 == null) {
            synchronized (zzg) {
                advertisingIdClient2 = zzh;
                if (advertisingIdClient2 == null) {
                    Log.d("AdvertisingIdClient", "Creating AdvertisingIdClient");
                    context2 = context;
                    advertisingIdClient2 = new AdvertisingIdClient(context2);
                    zzh = advertisingIdClient2;
                } else {
                    context2 = context;
                }
            }
        } else {
            context2 = context;
        }
        Log.d("AdvertisingIdClient", "AdvertisingIdClient already created.");
        zzd zza = zzd.zza(context2);
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        try {
            zzf = advertisingIdClient2.zzf(-1);
            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime2;
            advertisingIdClient = advertisingIdClient2;
        } catch (Throwable th2) {
            th = th2;
            advertisingIdClient = advertisingIdClient2;
        }
        try {
            advertisingIdClient.zzd(zzf, true, 0.0f, elapsedRealtime, "", null);
            try {
                try {
                    zza.zzb(35401, 0, elapsedRealtime2, SystemClock.elapsedRealtime(), (int) (SystemClock.elapsedRealtime() - elapsedRealtime2));
                    zzdVar = zza;
                    elapsedRealtime2 = elapsedRealtime2;
                    try {
                        StringBuilder sb = new StringBuilder(String.valueOf(elapsedRealtime).length() + 25);
                        sb.append("GetInfoInternal elapse ");
                        sb.append(elapsedRealtime);
                        sb.append("ms");
                        Log.i("AdvertisingIdClient", sb.toString());
                        return zzf;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        advertisingIdClient.zzd(null, true, 0.0f, -1L, "", th);
                        if (th instanceof IOException) {
                            i = 1;
                        } else if (th instanceof GooglePlayServicesNotAvailableException) {
                            i = 9;
                        } else if (th instanceof GooglePlayServicesRepairableException) {
                            i = 16;
                        } else if (!(th instanceof IllegalStateException)) {
                            j = elapsedRealtime2;
                            i2 = -1;
                            zzdVar.zzb(35401, i2, j, SystemClock.elapsedRealtime(), (int) (SystemClock.elapsedRealtime() - j));
                            throw th;
                        } else {
                            i = 8;
                        }
                        j = elapsedRealtime2;
                        i2 = i;
                        zzdVar.zzb(35401, i2, j, SystemClock.elapsedRealtime(), (int) (SystemClock.elapsedRealtime() - j));
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    zzdVar = zza;
                    elapsedRealtime2 = elapsedRealtime2;
                    th = th;
                    advertisingIdClient.zzd(null, true, 0.0f, -1L, "", th);
                    if (th instanceof IOException) {
                    }
                    j = elapsedRealtime2;
                    i2 = i;
                    zzdVar.zzb(35401, i2, j, SystemClock.elapsedRealtime(), (int) (SystemClock.elapsedRealtime() - j));
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                zzdVar = zza;
            }
        } catch (Throwable th6) {
            th = th6;
            zzdVar = zza;
            th = th;
            advertisingIdClient.zzd(null, true, 0.0f, -1L, "", th);
            if (th instanceof IOException) {
            }
            j = elapsedRealtime2;
            i2 = i;
            zzdVar.zzb(35401, i2, j, SystemClock.elapsedRealtime(), (int) (SystemClock.elapsedRealtime() - j));
            throw th;
        }
    }

    public static boolean getIsAdIdFakeForDebugLogging(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        boolean zze;
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, false, false);
        try {
            advertisingIdClient.zza(false);
            Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
            synchronized (advertisingIdClient) {
                advertisingIdClient.zze();
                Preconditions.checkNotNull(advertisingIdClient.zza);
                Preconditions.checkNotNull(advertisingIdClient.zzb);
                try {
                    zze = advertisingIdClient.zzb.zze();
                } catch (RemoteException e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception", e);
                }
            }
            advertisingIdClient.zzb();
            return zze;
        } finally {
            advertisingIdClient.zzc();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private final Info zzf(int i) throws IOException {
        Info info;
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            zze();
            Preconditions.checkNotNull(this.zza);
            Preconditions.checkNotNull(this.zzb);
            try {
                info = new Info(this.zzb.zzc(), this.zzb.zzd(true));
            } catch (RemoteException e) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                throw new IOException("Remote exception", e);
            }
        }
        zzb();
        return info;
    }

    protected final void finalize() throws Throwable {
        zzc();
        super.finalize();
    }

    public Info getInfo() throws IOException {
        return zzf(-1);
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zza(true);
    }

    protected final void zza(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        if (z) {
            zzb();
        }
        synchronized (this) {
            if (this.zzc) {
                return;
            }
            Context context = this.zzi;
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                if (isGooglePlayServicesAvailable != 0 && isGooglePlayServicesAvailable != 2) {
                    throw new IOException("Google Play services not available");
                }
                BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (ConnectionTracker.getInstance().bindService(context, intent, blockingServiceConnection, 1)) {
                    this.zza = blockingServiceConnection;
                    try {
                        this.zzb = com.google.android.gms.internal.ads_identifier.zze.zza(blockingServiceConnection.getServiceWithTimeout(Renderer.DEFAULT_DURATION_TO_PROGRESS_US, TimeUnit.MILLISECONDS));
                        this.zzc = true;
                        return;
                    } catch (InterruptedException unused) {
                        throw new IOException("Interrupted exception");
                    } catch (Throwable th) {
                        throw new IOException(th);
                    }
                }
                throw new IOException("Connection failure");
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new GooglePlayServicesNotAvailableException(9);
            }
        }
    }

    final void zzb() {
        synchronized (this.zzd) {
            zzb zzbVar = this.zze;
            if (zzbVar != null) {
                zzbVar.zza.countDown();
                try {
                    this.zze.join();
                } catch (InterruptedException unused) {
                }
            }
            long j = this.zzf;
            if (j > 0) {
                this.zze = new zzb(this, j);
            }
        }
    }

    public final void zzc() {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            Context context = this.zzi;
            if (context == null || this.zza == null) {
                return;
            }
            if (this.zzc) {
                ConnectionTracker.getInstance().unbindService(context, this.zza);
            }
            this.zzc = false;
            this.zzb = null;
            this.zza = null;
        }
    }

    final boolean zzd(Info info, boolean z, float f, long j, String str, Throwable th) {
        if (Math.random() <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            HashMap hashMap = new HashMap();
            hashMap.put("app_context", "1");
            if (info != null) {
                hashMap.put(CommonUrlParts.LIMIT_AD_TRACKING, true != info.isLimitAdTrackingEnabled() ? "0" : "1");
                String id = info.getId();
                if (id != null) {
                    hashMap.put("ad_id_size", Integer.toString(id.length()));
                }
            }
            if (th != null) {
                hashMap.put("error", th.getClass().getName());
            }
            hashMap.put("tag", "AdvertisingIdClient");
            hashMap.put("time_spent", Long.toString(j));
            new zza(this, hashMap).start();
            return true;
        }
        return false;
    }

    final synchronized void zze() throws IOException {
        if (!this.zzc) {
            try {
                Log.d("AdvertisingIdClient", "AdvertisingIdClient is not bounded. Starting to bind it...");
                zza(false);
                Log.d("AdvertisingIdClient", "AdvertisingIdClient is bounded");
                if (!this.zzc) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.");
                }
            } catch (Exception e) {
                throw new IOException("AdvertisingIdClient cannot reconnect.", e);
            }
        }
    }

    public AdvertisingIdClient(Context context, long j, boolean z, boolean z2) {
        this.zzd = new Object();
        Preconditions.checkNotNull(context);
        this.zzi = context.getApplicationContext();
        this.zzc = false;
        this.zzf = j;
    }
}
