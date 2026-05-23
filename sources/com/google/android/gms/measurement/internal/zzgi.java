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
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzgi extends zzg {
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
    private final String zzk;
    private int zzl;
    private String zzm;
    private String zzn;
    private long zzo;
    private String zzp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgi(zzic zzicVar, long j, long j2, String str) {
        super(zzicVar);
        this.zzo = 0L;
        this.zzp = null;
        this.zzg = j;
        this.zzh = j2;
        this.zzk = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:1|(1:3)(6:62|63|(1:65)(2:80|(1:82))|66|67|(18:69|(1:71)(1:78)|72|73|5|(2:7|(2:9|(2:11|(2:13|(2:15|(2:17|(1:19)(1:55))(1:56))(1:57))(1:58))(1:59))(1:60))(1:61)|20|21|22|(1:24)(1:52)|25|(1:27)(1:51)|28|(1:30)|32|(3:34|(1:36)(3:43|(3:46|(1:48)|44)|49)|(2:38|39)(2:41|42))|50|(0)(0)))|4|5|(0)(0)|20|21|22|(0)(0)|25|(0)(0)|28|(0)|32|(0)|50|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01a2, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01a3, code lost:
        r11.zzu.zzaW().zzb().zzc("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r1), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0176 A[Catch: IllegalStateException -> 0x01a2, TryCatch #1 {IllegalStateException -> 0x01a2, blocks: (B:49:0x016d, B:53:0x0184, B:57:0x018c, B:59:0x0190, B:52:0x0176), top: B:83:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0190 A[Catch: IllegalStateException -> 0x01a2, TRY_LEAVE, TryCatch #1 {IllegalStateException -> 0x01a2, blocks: (B:49:0x016d, B:53:0x0184, B:57:0x018c, B:59:0x0190, B:52:0x0176), top: B:83:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020b  */
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
        String str3;
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzk().zzc("sdkVersion bundled with app, dynamiteVersion", Long.valueOf(this.zzh), Long.valueOf(this.zzg));
        String packageName = zzicVar.zzaZ().getPackageName();
        PackageManager packageManager = zzicVar.zzaZ().getPackageManager();
        String str4 = "";
        int i = Integer.MIN_VALUE;
        String str5 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        String str6 = "unknown";
        if (packageManager == null) {
            zzicVar.zzaW().zzb().zzb("PackageManager is null, app identity information might be inaccurate. appId", zzgu.zzl(packageName));
        } else {
            try {
                str6 = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                this.zzu.zzaW().zzb().zzb("Error retrieving app installer package name. appId", zzgu.zzl(packageName));
            }
            if (str6 == null) {
                str6 = "manual_install";
            } else if ("com.android.vending".equals(str6)) {
                str6 = "";
            }
            try {
                packageInfo = packageManager.getPackageInfo(this.zzu.zzaZ().getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused2) {
                str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                str2 = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                try {
                    str5 = packageInfo.versionName;
                    i = packageInfo.versionCode;
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = str5;
                    str5 = str2;
                    this.zzu.zzaW().zzb().zzc("Error retrieving package info. appId, appName", zzgu.zzl(packageName), str5);
                    str2 = str5;
                    str5 = str;
                    this.zza = packageName;
                    this.zzd = str6;
                    this.zzb = str5;
                    this.zzc = i;
                    this.zze = str2;
                    this.zzf = 0L;
                    zzic zzicVar2 = this.zzu;
                    zzC = zzicVar2.zzC();
                    if (zzC == 0) {
                    }
                    this.zzm = "";
                    zzic zzicVar3 = this.zzu;
                    zzicVar3.zzaV();
                    str3 = this.zzk;
                    if (TextUtils.isEmpty(str3)) {
                    }
                    if (!TextUtils.isEmpty(str3)) {
                    }
                    this.zzm = str4;
                    if (zzC == 0) {
                    }
                    this.zzi = null;
                    zzic zzicVar4 = this.zzu;
                    zzicVar4.zzaV();
                    zzs = zzicVar4.zzc().zzs("analytics.safelisted_events");
                    if (zzs != null) {
                    }
                    this.zzi = zzs;
                    if (packageManager == null) {
                    }
                }
                this.zza = packageName;
                this.zzd = str6;
                this.zzb = str5;
                this.zzc = i;
                this.zze = str2;
                this.zzf = 0L;
                zzic zzicVar22 = this.zzu;
                zzC = zzicVar22.zzC();
                if (zzC == 0) {
                    this.zzu.zzaW().zzk().zza("App measurement collection enabled");
                } else if (zzC == 1) {
                    this.zzu.zzaW().zzi().zza("App measurement deactivated via the manifest");
                } else if (zzC == 3) {
                    this.zzu.zzaW().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                } else if (zzC == 4) {
                    this.zzu.zzaW().zzi().zza("App measurement disabled via the manifest");
                } else if (zzC == 6) {
                    this.zzu.zzaW().zzh().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                } else if (zzC == 7) {
                    this.zzu.zzaW().zzi().zza("App measurement disabled via the global data collection setting");
                } else if (zzC != 8) {
                    zzic zzicVar5 = this.zzu;
                    zzicVar5.zzaW().zzi().zza("App measurement disabled");
                    zzicVar5.zzaW().zzc().zza("Invalid scion state in identity");
                } else {
                    this.zzu.zzaW().zzi().zza("App measurement disabled due to denied storage consent");
                }
                this.zzm = "";
                zzic zzicVar32 = this.zzu;
                zzicVar32.zzaV();
                str3 = this.zzk;
                if (TextUtils.isEmpty(str3)) {
                    str3 = zzlt.zza(zzicVar32.zzaZ(), "google_app_id", zzicVar22.zzq());
                }
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                this.zzm = str4;
                if (zzC == 0) {
                    zzicVar32.zzaW().zzk().zzc("App measurement enabled for app package, google app id", this.zza, this.zzm);
                }
                this.zzi = null;
                zzic zzicVar42 = this.zzu;
                zzicVar42.zzaV();
                zzs = zzicVar42.zzc().zzs("analytics.safelisted_events");
                if (zzs != null) {
                    if (zzs.isEmpty()) {
                        zzicVar42.zzaW().zzh().zza("Safelisted event list is empty. Ignoring");
                    } else {
                        for (String str7 : zzs) {
                            if (!zzicVar42.zzk().zzl("safelisted event", str7)) {
                                break;
                            }
                        }
                    }
                    if (packageManager == null) {
                        this.zzl = InstantApps.isInstantApp(zzicVar42.zzaZ()) ? 1 : 0;
                        return;
                    } else {
                        this.zzl = 0;
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
        this.zzd = str6;
        this.zzb = str5;
        this.zzc = i;
        this.zze = str2;
        this.zzf = 0L;
        zzic zzicVar222 = this.zzu;
        zzC = zzicVar222.zzC();
        if (zzC == 0) {
        }
        this.zzm = "";
        zzic zzicVar322 = this.zzu;
        zzicVar322.zzaV();
        str3 = this.zzk;
        if (TextUtils.isEmpty(str3)) {
        }
        if (!TextUtils.isEmpty(str3)) {
        }
        this.zzm = str4;
        if (zzC == 0) {
        }
        this.zzi = null;
        zzic zzicVar422 = this.zzu;
        zzicVar422.zzaV();
        zzs = zzicVar422.zzc().zzs("analytics.safelisted_events");
        if (zzs != null) {
        }
        this.zzi = zzs;
        if (packageManager == null) {
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:46:0x016e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    final com.google.android.gms.measurement.internal.zzr zzh(java.lang.String r52) {
        /*
            Method dump skipped, instructions count: 912
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgi.zzh(java.lang.String):com.google.android.gms.measurement.internal.zzr");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi() {
        String format;
        zzg();
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzd().zzl().zzo(zzjk.ANALYTICS_STORAGE)) {
            zzicVar.zzaW().zzj().zza("Analytics Storage consent is not granted");
            format = null;
        } else {
            byte[] bArr = new byte[16];
            zzicVar.zzk().zzf().nextBytes(bArr);
            format = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        zzicVar.zzaW().zzj().zza(String.format("Resetting session stitching token to %s", format == null ? AbstractJsonLexerKt.NULL : "not null"));
        this.zzn = format;
        this.zzo = zzicVar.zzba().currentTimeMillis();
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
        Preconditions.checkNotNull(this.zzm);
        return this.zzm;
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
        return this.zzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List zzp() {
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzq(String str) {
        String str2 = this.zzp;
        boolean z = false;
        if (str2 != null && !str2.equals(str)) {
            z = true;
        }
        this.zzp = str;
        return z;
    }
}
