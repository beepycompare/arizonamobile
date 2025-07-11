package com.google.android.gms.measurement.internal;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzgh extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private final long zzh;
    private List zzi;
    private String zzj;
    private int zzk;
    private String zzl;
    private String zzm;
    private long zzn;
    private String zzo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgh(zzib zzibVar, long j, long j2) {
        super(zzibVar);
        this.zzn = 0L;
        this.zzo = null;
        this.zzg = j;
        this.zzh = j2;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(1:3)(6:58|59|(1:61)(2:76|(1:78))|62|63|(16:65|(1:67)(1:74)|68|69|5|(2:7|(2:9|(2:11|(2:13|(2:15|(2:17|(1:19)(1:51))(1:52))(1:53))(1:54))(1:55))(1:56))(1:57)|20|21|22|(1:24)(1:48)|25|(1:27)|29|(3:31|(1:33)(3:40|(3:43|(1:45)|41)|46)|(2:35|36)(2:38|39))|47|(0)(0)))|4|5|(0)(0)|20|21|22|(0)(0)|25|(0)|29|(0)|47|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0199, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x019a, code lost:
        r11.zzu.zzaV().zzb().zzc("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r1), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0187 A[Catch: IllegalStateException -> 0x0199, TRY_LEAVE, TryCatch #2 {IllegalStateException -> 0x0199, blocks: (B:49:0x016d, B:53:0x0183, B:55:0x0187), top: B:81:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0202  */
    @Override // com.google.android.gms.measurement.internal.zzg
    @EnsuresNonNull({RemoteConfigConstants.RequestFieldKey.APP_ID, "appStore", "appName", "gmpAppId", "gaAppId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void zzf() {
        String str;
        String str2;
        PackageInfo packageInfo;
        int zzC;
        List<String> zzs;
        String zza;
        zzib zzibVar = this.zzu;
        zzibVar.zzaV().zzk().zzc("sdkVersion bundled with app, dynamiteVersion", Long.valueOf(this.zzh), Long.valueOf(this.zzg));
        String packageName = zzibVar.zzaY().getPackageName();
        PackageManager packageManager = zzibVar.zzaY().getPackageManager();
        String str3 = "";
        int i = Integer.MIN_VALUE;
        String str4 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        String str5 = "unknown";
        if (packageManager == null) {
            zzibVar.zzaV().zzb().zzb("PackageManager is null, app identity information might be inaccurate. appId", zzgt.zzl(packageName));
        } else {
            try {
                str5 = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                this.zzu.zzaV().zzb().zzb("Error retrieving app installer package name. appId", zzgt.zzl(packageName));
            }
            if (str5 == null) {
                str5 = "manual_install";
            } else if ("com.android.vending".equals(str5)) {
                str5 = "";
            }
            try {
                packageInfo = packageManager.getPackageInfo(this.zzu.zzaY().getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused2) {
                str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                str2 = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                try {
                    str4 = packageInfo.versionName;
                    i = packageInfo.versionCode;
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = str4;
                    str4 = str2;
                    this.zzu.zzaV().zzb().zzc("Error retrieving package info. appId, appName", zzgt.zzl(packageName), str4);
                    str2 = str4;
                    str4 = str;
                    this.zza = packageName;
                    this.zzd = str5;
                    this.zzb = str4;
                    this.zzc = i;
                    this.zze = str2;
                    this.zzf = 0L;
                    zzib zzibVar2 = this.zzu;
                    zzC = zzibVar2.zzC();
                    if (zzC == 0) {
                    }
                    this.zzl = "";
                    zzib zzibVar3 = this.zzu;
                    zzibVar3.zzaU();
                    zza = zzls.zza(zzibVar3.zzaY(), "google_app_id", zzibVar2.zzq());
                    if (!TextUtils.isEmpty(zza)) {
                    }
                    this.zzl = str3;
                    if (zzC == 0) {
                    }
                    this.zzi = null;
                    zzib zzibVar4 = this.zzu;
                    zzibVar4.zzaU();
                    zzs = zzibVar4.zzc().zzs("analytics.safelisted_events");
                    if (zzs != null) {
                    }
                    this.zzi = zzs;
                    if (packageManager == null) {
                    }
                }
                this.zza = packageName;
                this.zzd = str5;
                this.zzb = str4;
                this.zzc = i;
                this.zze = str2;
                this.zzf = 0L;
                zzib zzibVar22 = this.zzu;
                zzC = zzibVar22.zzC();
                if (zzC == 0) {
                    this.zzu.zzaV().zzk().zza("App measurement collection enabled");
                } else if (zzC == 1) {
                    this.zzu.zzaV().zzi().zza("App measurement deactivated via the manifest");
                } else if (zzC == 3) {
                    this.zzu.zzaV().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                } else if (zzC == 4) {
                    this.zzu.zzaV().zzi().zza("App measurement disabled via the manifest");
                } else if (zzC == 6) {
                    this.zzu.zzaV().zzh().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                } else if (zzC == 7) {
                    this.zzu.zzaV().zzi().zza("App measurement disabled via the global data collection setting");
                } else if (zzC != 8) {
                    zzib zzibVar5 = this.zzu;
                    zzibVar5.zzaV().zzi().zza("App measurement disabled");
                    zzibVar5.zzaV().zzc().zza("Invalid scion state in identity");
                } else {
                    this.zzu.zzaV().zzi().zza("App measurement disabled due to denied storage consent");
                }
                this.zzl = "";
                zzib zzibVar32 = this.zzu;
                zzibVar32.zzaU();
                zza = zzls.zza(zzibVar32.zzaY(), "google_app_id", zzibVar22.zzq());
                if (!TextUtils.isEmpty(zza)) {
                    str3 = zza;
                }
                this.zzl = str3;
                if (zzC == 0) {
                    zzibVar32.zzaV().zzk().zzc("App measurement enabled for app package, google app id", this.zza, this.zzl);
                }
                this.zzi = null;
                zzib zzibVar42 = this.zzu;
                zzibVar42.zzaU();
                zzs = zzibVar42.zzc().zzs("analytics.safelisted_events");
                if (zzs != null) {
                    if (zzs.isEmpty()) {
                        zzibVar42.zzaV().zzh().zza("Safelisted event list is empty. Ignoring");
                    } else {
                        for (String str6 : zzs) {
                            if (!zzibVar42.zzk().zzk("safelisted event", str6)) {
                                break;
                            }
                        }
                    }
                    if (packageManager == null) {
                        this.zzk = InstantApps.isInstantApp(zzibVar42.zzaY()) ? 1 : 0;
                        return;
                    } else {
                        this.zzk = 0;
                        return;
                    }
                }
                this.zzi = zzs;
                if (packageManager == null) {
                }
            }
        }
        str2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        this.zza = packageName;
        this.zzd = str5;
        this.zzb = str4;
        this.zzc = i;
        this.zze = str2;
        this.zzf = 0L;
        zzib zzibVar222 = this.zzu;
        zzC = zzibVar222.zzC();
        if (zzC == 0) {
        }
        this.zzl = "";
        zzib zzibVar322 = this.zzu;
        zzibVar322.zzaU();
        zza = zzls.zza(zzibVar322.zzaY(), "google_app_id", zzibVar222.zzq());
        if (!TextUtils.isEmpty(zza)) {
        }
        this.zzl = str3;
        if (zzC == 0) {
        }
        this.zzi = null;
        zzib zzibVar422 = this.zzu;
        zzibVar422.zzaU();
        zzs = zzibVar422.zzc().zzs("analytics.safelisted_events");
        if (zzs != null) {
        }
        this.zzi = zzs;
        if (packageManager == null) {
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:46:0x0169
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    final com.google.android.gms.measurement.internal.zzr zzh(java.lang.String r50) {
        /*
            Method dump skipped, instructions count: 870
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgh.zzh(java.lang.String):com.google.android.gms.measurement.internal.zzr");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi() {
        String format;
        zzg();
        zzib zzibVar = this.zzu;
        if (!zzibVar.zzd().zzl().zzo(zzjj.ANALYTICS_STORAGE)) {
            zzibVar.zzaV().zzj().zza("Analytics Storage consent is not granted");
            format = null;
        } else {
            byte[] bArr = new byte[16];
            zzibVar.zzk().zzf().nextBytes(bArr);
            format = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        zzibVar.zzaV().zzj().zza(String.format("Resetting session stitching token to %s", format == null ? AbstractJsonLexerKt.NULL : "not null"));
        this.zzm = format;
        this.zzn = zzibVar.zzaZ().currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzj() {
        zzb();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzk() {
        zzg();
        zzb();
        Preconditions.checkNotNull(this.zzl);
        return this.zzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzl() {
        zzb();
        Preconditions.checkNotNull(this.zze);
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzm() {
        zzb();
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzn() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzo() {
        zzb();
        return this.zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List zzp() {
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzq(String str) {
        String str2 = this.zzo;
        boolean z = false;
        if (str2 != null && !str2.equals(str)) {
            z = true;
        }
        this.zzo = str;
        return z;
    }
}
