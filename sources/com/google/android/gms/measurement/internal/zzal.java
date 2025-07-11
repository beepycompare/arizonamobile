package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.messaging.ServiceStarter;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzal extends zzjd {
    private Boolean zza;
    private String zzb;
    private zzak zzc;
    private Boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzal(zzib zzibVar) {
        super(zzibVar);
        this.zzc = zzaj.zza;
    }

    public static final long zzF() {
        return ((Long) zzfx.zzd.zzb(null)).longValue();
    }

    public static final int zzG() {
        return Math.max(0, ((Integer) zzfx.zzi.zzb(null)).intValue());
    }

    public static final long zzH() {
        return ((Integer) zzfx.zzk.zzb(null)).intValue();
    }

    public static final long zzI() {
        return ((Long) zzfx.zzR.zzb(null)).longValue();
    }

    public static final long zzJ() {
        return ((Long) zzfx.zzM.zzb(null)).longValue();
    }

    private final String zzK(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e) {
            this.zzu.zzaV().zzb().zzb("Could not find SystemProperties class", e);
            return "";
        } catch (IllegalAccessException e2) {
            this.zzu.zzaV().zzb().zzb("Could not access SystemProperties.get()", e2);
            return "";
        } catch (NoSuchMethodException e3) {
            this.zzu.zzaV().zzb().zzb("Could not find SystemProperties.get() method", e3);
            return "";
        } catch (InvocationTargetException e4) {
            this.zzu.zzaV().zzb().zzb("SystemProperties.get() threw an exception", e4);
            return "";
        }
    }

    public final String zzA() {
        return zzK("debug.firebase.analytics.app", "");
    }

    public final String zzB() {
        return zzK("debug.deferred.deeplink", "");
    }

    public final boolean zzC(String str) {
        return "1".equals(this.zzc.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzD(String str) {
        return "1".equals(this.zzc.zza(str, "measurement.event_sampling_enabled"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzE() {
        if (this.zza == null) {
            Boolean zzr = zzr("app_measurement_lite");
            this.zza = zzr;
            if (zzr == null) {
                this.zza = false;
            }
        }
        return this.zza.booleanValue() || !this.zzu.zzp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzak zzakVar) {
        this.zzc = zzakVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzb() {
        this.zzu.zzaU();
        return "FA";
    }

    public final int zzc() {
        return this.zzu.zzk().zzag(201500000, true) ? 100 : 25;
    }

    public final int zzd(String str) {
        return zzn(str, zzfx.zzX, 25, 100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zze(String str, boolean z) {
        return z ? zzn(str, zzfx.zzah, 100, ServiceStarter.ERROR_UNKNOWN) : ServiceStarter.ERROR_UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzf(String str, boolean z) {
        return Math.max(zze(str, z), 256);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzh(String str) {
        return zzn(str, zzfx.zzW, ServiceStarter.ERROR_UNKNOWN, 2000);
    }

    public final long zzi() {
        this.zzu.zzaU();
        return 130000L;
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzj() {
        if (this.zzd == null) {
            synchronized (this) {
                if (this.zzd == null) {
                    zzib zzibVar = this.zzu;
                    ApplicationInfo applicationInfo = zzibVar.zzaY().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = false;
                        if (str != null && str.equals(myProcessName)) {
                            z = true;
                        }
                        this.zzd = Boolean.valueOf(z);
                    }
                    if (this.zzd == null) {
                        this.zzd = Boolean.TRUE;
                        zzibVar.zzaV().zzb().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzd.booleanValue();
    }

    public final String zzk(String str, zzfw zzfwVar) {
        if (TextUtils.isEmpty(str)) {
            return (String) zzfwVar.zzb(null);
        }
        return (String) zzfwVar.zzb(this.zzc.zza(str, zzfwVar.zza()));
    }

    public final long zzl(String str, zzfw zzfwVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Long) zzfwVar.zzb(null)).longValue();
        }
        String zza = this.zzc.zza(str, zzfwVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return ((Long) zzfwVar.zzb(null)).longValue();
        }
        try {
            return ((Long) zzfwVar.zzb(Long.valueOf(Long.parseLong(zza)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) zzfwVar.zzb(null)).longValue();
        }
    }

    public final int zzm(String str, zzfw zzfwVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Integer) zzfwVar.zzb(null)).intValue();
        }
        String zza = this.zzc.zza(str, zzfwVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return ((Integer) zzfwVar.zzb(null)).intValue();
        }
        try {
            return ((Integer) zzfwVar.zzb(Integer.valueOf(Integer.parseInt(zza)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) zzfwVar.zzb(null)).intValue();
        }
    }

    public final int zzn(String str, zzfw zzfwVar, int i, int i2) {
        return Math.max(Math.min(zzm(str, zzfwVar), i2), i);
    }

    public final double zzo(String str, zzfw zzfwVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Double) zzfwVar.zzb(null)).doubleValue();
        }
        String zza = this.zzc.zza(str, zzfwVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return ((Double) zzfwVar.zzb(null)).doubleValue();
        }
        try {
            return ((Double) zzfwVar.zzb(Double.valueOf(Double.parseDouble(zza)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) zzfwVar.zzb(null)).doubleValue();
        }
    }

    public final boolean zzp(String str, zzfw zzfwVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Boolean) zzfwVar.zzb(null)).booleanValue();
        }
        String zza = this.zzc.zza(str, zzfwVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return ((Boolean) zzfwVar.zzb(null)).booleanValue();
        }
        return ((Boolean) zzfwVar.zzb(Boolean.valueOf("1".equals(zza)))).booleanValue();
    }

    final Bundle zzq() {
        try {
            zzib zzibVar = this.zzu;
            if (zzibVar.zzaY().getPackageManager() != null) {
                ApplicationInfo applicationInfo = Wrappers.packageManager(zzibVar.zzaY()).getApplicationInfo(zzibVar.zzaY().getPackageName(), 128);
                if (applicationInfo == null) {
                    zzibVar.zzaV().zzb().zza("Failed to load metadata: ApplicationInfo is null");
                    return null;
                }
                return applicationInfo.metaData;
            }
            zzibVar.zzaV().zzb().zza("Failed to load metadata: PackageManager is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            this.zzu.zzaV().zzb().zzb("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean zzr(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzq = zzq();
        if (zzq == null) {
            this.zzu.zzaV().zzb().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (zzq.containsKey(str)) {
            return Boolean.valueOf(zzq.getBoolean(str));
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzs(String str) {
        Integer valueOf;
        Preconditions.checkNotEmpty("analytics.safelisted_events");
        Bundle zzq = zzq();
        if (zzq == null) {
            this.zzu.zzaV().zzb().zza("Failed to load metadata: Metadata bundle is null");
        } else if (zzq.containsKey("analytics.safelisted_events")) {
            valueOf = Integer.valueOf(zzq.getInt("analytics.safelisted_events"));
            if (valueOf != null) {
                try {
                    String[] stringArray = this.zzu.zzaY().getResources().getStringArray(valueOf.intValue());
                    if (stringArray == null) {
                        return null;
                    }
                    return Arrays.asList(stringArray);
                } catch (Resources.NotFoundException e) {
                    this.zzu.zzaV().zzb().zzb("Failed to load string array from metadata: resource not found", e);
                }
            }
            return null;
        }
        valueOf = null;
        if (valueOf != null) {
        }
        return null;
    }

    public final boolean zzt() {
        this.zzu.zzaU();
        Boolean zzr = zzr("firebase_analytics_collection_deactivated");
        return zzr != null && zzr.booleanValue();
    }

    public final boolean zzu() {
        Boolean zzr = zzr("google_analytics_adid_collection_enabled");
        return zzr == null || zzr.booleanValue();
    }

    public final boolean zzv() {
        Boolean zzr = zzr("google_analytics_automatic_screen_reporting_enabled");
        return zzr == null || zzr.booleanValue();
    }

    public final zzjh zzw(String str, boolean z) {
        Object obj;
        Preconditions.checkNotEmpty(str);
        zzib zzibVar = this.zzu;
        Bundle zzq = zzq();
        if (zzq == null) {
            zzibVar.zzaV().zzb().zza("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = zzq.get(str);
        }
        if (obj == null) {
            return zzjh.UNINITIALIZED;
        }
        if (Boolean.TRUE.equals(obj)) {
            return zzjh.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return zzjh.DENIED;
        }
        if (!z || !"eu_consent_policy".equals(obj)) {
            zzibVar.zzaV().zze().zzb("Invalid manifest metadata for", str);
            return zzjh.UNINITIALIZED;
        }
        return zzjh.POLICY;
    }

    public final boolean zzx() {
        Boolean zzr = zzr("google_analytics_sgtm_upload_enabled");
        if (zzr == null) {
            return false;
        }
        return zzr.booleanValue();
    }

    public final void zzy(String str) {
        this.zzb = str;
    }

    public final String zzz() {
        return this.zzb;
    }
}
