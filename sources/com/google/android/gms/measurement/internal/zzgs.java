package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
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
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzgs extends zzg {
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
    private String zzn;
    private long zzo;
    private String zzp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgs(zzio zzioVar, long j, long j2) {
        super(zzioVar);
        this.zzo = 0L;
        this.zzp = null;
        this.zzg = j;
        this.zzh = j2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(1:3)(6:79|80|(1:82)(2:97|(1:99))|83|84|(21:86|(1:88)(1:95)|89|90|5|(2:7|(15:11|12|(1:(2:15|(2:17|(2:19|(2:21|(2:23|(1:25)(1:71))(1:72))(1:73))(1:74))(1:75))(1:76))(1:77)|26|(1:28)|29|30|(1:32)(1:68)|33|(3:37|(1:39)(1:41)|40)|(3:43|(1:45)(1:48)|46)|49|(3:51|(1:53)(3:60|(3:63|(1:65)|61)|66)|(2:55|56)(2:58|59))|67|(0)(0)))|78|12|(0)(0)|26|(0)|29|30|(0)(0)|33|(4:35|37|(0)(0)|40)|(0)|49|(0)|67|(0)(0)))|4|5|(0)|78|12|(0)(0)|26|(0)|29|30|(0)(0)|33|(0)|(0)|49|(0)|67|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01fa, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01fb, code lost:
        r11.zzu.zzaW().zze().zzc("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r1), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b3 A[Catch: IllegalStateException -> 0x01fa, TryCatch #2 {IllegalStateException -> 0x01fa, blocks: (B:58:0x018f, B:62:0x01a5, B:64:0x01b3, B:66:0x01b9, B:70:0x01d3, B:69:0x01cf, B:72:0x01dd, B:74:0x01f1, B:76:0x01f6, B:75:0x01f4), top: B:102:0x018f }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01cf A[Catch: IllegalStateException -> 0x01fa, TryCatch #2 {IllegalStateException -> 0x01fa, blocks: (B:58:0x018f, B:62:0x01a5, B:64:0x01b3, B:66:0x01b9, B:70:0x01d3, B:69:0x01cf, B:72:0x01dd, B:74:0x01f1, B:76:0x01f6, B:75:0x01f4), top: B:102:0x018f }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01dd A[Catch: IllegalStateException -> 0x01fa, TryCatch #2 {IllegalStateException -> 0x01fa, blocks: (B:58:0x018f, B:62:0x01a5, B:64:0x01b3, B:66:0x01b9, B:70:0x01d3, B:69:0x01cf, B:72:0x01dd, B:74:0x01f1, B:76:0x01f6, B:75:0x01f4), top: B:102:0x018f }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0262  */
    @Override // com.google.android.gms.measurement.internal.zzg
    @EnsuresNonNull({RemoteConfigConstants.RequestFieldKey.APP_ID, "appStore", "appName", "gmpAppId", "gaAppId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void zzd() {
        String str;
        String str2;
        PackageInfo packageInfo;
        zzio zzioVar;
        Object[] objArr;
        zzio zzioVar2;
        int zza;
        List<String> zzt;
        String zzc;
        String zzA;
        zzio zzioVar3 = this.zzu;
        zzioVar3.zzaW().zzj().zzc("sdkVersion bundled with app, dynamiteVersion", Long.valueOf(this.zzh), Long.valueOf(this.zzg));
        String packageName = zzioVar3.zzaT().getPackageName();
        PackageManager packageManager = zzioVar3.zzaT().getPackageManager();
        int i = Integer.MIN_VALUE;
        String str3 = "";
        String str4 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        String str5 = "unknown";
        if (packageManager == null) {
            zzioVar3.zzaW().zze().zzb("PackageManager is null, app identity information might be inaccurate. appId", zzhe.zzn(packageName));
        } else {
            try {
                str5 = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                this.zzu.zzaW().zze().zzb("Error retrieving app installer package name. appId", zzhe.zzn(packageName));
            }
            if (str5 == null) {
                str5 = "manual_install";
            } else if ("com.android.vending".equals(str5)) {
                str5 = "";
            }
            try {
                packageInfo = packageManager.getPackageInfo(this.zzu.zzaT().getPackageName(), 0);
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
                    this.zzu.zzaW().zze().zzc("Error retrieving package info. appId, appName", zzhe.zzn(packageName), str4);
                    str2 = str4;
                    str4 = str;
                    this.zza = packageName;
                    this.zzd = str5;
                    this.zzb = str4;
                    this.zzc = i;
                    this.zze = str2;
                    this.zzf = 0L;
                    zzioVar = this.zzu;
                    if (!zzioVar.zzf().zzx(null, zzgi.zzbp)) {
                    }
                    objArr = null;
                    zzioVar2 = this.zzu;
                    zza = zzioVar2.zza();
                    if (zza != 0) {
                    }
                    this.zzl = "";
                    this.zzm = "";
                    zzioVar.zzaV();
                    if (objArr != null) {
                    }
                    zzc = zzmg.zzc(zzioVar.zzaT(), "google_app_id", zzioVar2.zzA());
                    if (TextUtils.isEmpty(zzc)) {
                    }
                    this.zzl = str3;
                    if (!zzioVar.zzf().zzx(null, zzgi.zzbp)) {
                    }
                    if (zza == 0) {
                    }
                    this.zzi = null;
                    zzio zzioVar4 = this.zzu;
                    zzioVar4.zzaV();
                    zzt = zzioVar4.zzf().zzt("analytics.safelisted_events");
                    if (zzt != null) {
                    }
                    this.zzi = zzt;
                    if (packageManager != null) {
                    }
                }
                this.zza = packageName;
                this.zzd = str5;
                this.zzb = str4;
                this.zzc = i;
                this.zze = str2;
                this.zzf = 0L;
                zzioVar = this.zzu;
                if (!zzioVar.zzf().zzx(null, zzgi.zzbp)) {
                    zzio zzioVar5 = this.zzu;
                    if (!TextUtils.isEmpty(zzioVar5.zzx()) && "am".equals(zzioVar5.zzy())) {
                        objArr = 1;
                        zzioVar2 = this.zzu;
                        zza = zzioVar2.zza();
                        if (zza != 0) {
                            zzioVar.zzaW().zzj().zza("App measurement collection enabled");
                        } else if (zza == 1) {
                            zzioVar.zzaW().zzi().zza("App measurement deactivated via the manifest");
                        } else if (zza == 3) {
                            zzioVar.zzaW().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                        } else if (zza == 4) {
                            zzioVar.zzaW().zzi().zza("App measurement disabled via the manifest");
                        } else if (zza == 6) {
                            zzioVar.zzaW().zzl().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                        } else if (zza == 7) {
                            zzioVar.zzaW().zzi().zza("App measurement disabled via the global data collection setting");
                        } else if (zza != 8) {
                            zzioVar.zzaW().zzi().zza("App measurement disabled");
                            zzioVar.zzaW().zzh().zza("Invalid scion state in identity");
                        } else {
                            zzioVar.zzaW().zzi().zza("App measurement disabled due to denied storage consent");
                        }
                        this.zzl = "";
                        this.zzm = "";
                        zzioVar.zzaV();
                        if (objArr != null) {
                            this.zzm = zzioVar2.zzx();
                        }
                        zzc = zzmg.zzc(zzioVar.zzaT(), "google_app_id", zzioVar2.zzA());
                        if (TextUtils.isEmpty(zzc)) {
                            str3 = zzc;
                        }
                        this.zzl = str3;
                        if (!zzioVar.zzf().zzx(null, zzgi.zzbp) && !TextUtils.isEmpty(zzc)) {
                            Context zzaT = zzioVar.zzaT();
                            zzA = zzioVar2.zzA();
                            Preconditions.checkNotNull(zzaT);
                            Resources resources = zzaT.getResources();
                            if (!TextUtils.isEmpty(zzA)) {
                                zzA = zzig.zza(zzaT);
                            }
                            this.zzm = zzig.zzb("admob_app_id", resources, zzA);
                        }
                        if (zza == 0) {
                            zzioVar.zzaW().zzj().zzc("App measurement enabled for app package, google app id", this.zza, TextUtils.isEmpty(this.zzl) ? this.zzm : this.zzl);
                        }
                        this.zzi = null;
                        zzio zzioVar42 = this.zzu;
                        zzioVar42.zzaV();
                        zzt = zzioVar42.zzf().zzt("analytics.safelisted_events");
                        if (zzt != null) {
                            if (zzt.isEmpty()) {
                                zzioVar42.zzaW().zzl().zza("Safelisted event list is empty. Ignoring");
                            } else {
                                for (String str6 : zzt) {
                                    if (!zzioVar42.zzw().zzag("safelisted event", str6)) {
                                        break;
                                    }
                                }
                            }
                            if (packageManager != null) {
                                this.zzk = InstantApps.isInstantApp(zzioVar42.zzaT()) ? 1 : 0;
                                return;
                            } else {
                                this.zzk = 0;
                                return;
                            }
                        }
                        this.zzi = zzt;
                        if (packageManager != null) {
                        }
                    }
                }
                objArr = null;
                zzioVar2 = this.zzu;
                zza = zzioVar2.zza();
                if (zza != 0) {
                }
                this.zzl = "";
                this.zzm = "";
                zzioVar.zzaV();
                if (objArr != null) {
                }
                zzc = zzmg.zzc(zzioVar.zzaT(), "google_app_id", zzioVar2.zzA());
                if (TextUtils.isEmpty(zzc)) {
                }
                this.zzl = str3;
                if (!zzioVar.zzf().zzx(null, zzgi.zzbp)) {
                    Context zzaT2 = zzioVar.zzaT();
                    zzA = zzioVar2.zzA();
                    Preconditions.checkNotNull(zzaT2);
                    Resources resources2 = zzaT2.getResources();
                    if (!TextUtils.isEmpty(zzA)) {
                    }
                    this.zzm = zzig.zzb("admob_app_id", resources2, zzA);
                }
                if (zza == 0) {
                }
                this.zzi = null;
                zzio zzioVar422 = this.zzu;
                zzioVar422.zzaV();
                zzt = zzioVar422.zzf().zzt("analytics.safelisted_events");
                if (zzt != null) {
                }
                this.zzi = zzt;
                if (packageManager != null) {
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
        zzioVar = this.zzu;
        if (!zzioVar.zzf().zzx(null, zzgi.zzbp)) {
        }
        objArr = null;
        zzioVar2 = this.zzu;
        zza = zzioVar2.zza();
        if (zza != 0) {
        }
        this.zzl = "";
        this.zzm = "";
        zzioVar.zzaV();
        if (objArr != null) {
        }
        zzc = zzmg.zzc(zzioVar.zzaT(), "google_app_id", zzioVar2.zzA());
        if (TextUtils.isEmpty(zzc)) {
        }
        this.zzl = str3;
        if (!zzioVar.zzf().zzx(null, zzgi.zzbp)) {
        }
        if (zza == 0) {
        }
        this.zzi = null;
        zzio zzioVar4222 = this.zzu;
        zzioVar4222.zzaV();
        zzt = zzioVar4222.zzf().zzt("analytics.safelisted_events");
        if (zzt != null) {
        }
        this.zzi = zzt;
        if (packageManager != null) {
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzf() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzh() {
        zza();
        return this.zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzi() {
        zza();
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzj() {
        return this.zzh;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:46:0x0169
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    final com.google.android.gms.measurement.internal.zzr zzk(java.lang.String r51) {
        /*
            Method dump skipped, instructions count: 920
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgs.zzk(java.lang.String):com.google.android.gms.measurement.internal.zzr");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzl() {
        zza();
        if (this.zzu.zzf().zzx(null, zzgi.zzbp)) {
            return null;
        }
        return this.zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzm() {
        zza();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzn() {
        zza();
        Preconditions.checkNotNull(this.zze);
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzo() {
        zzg();
        zza();
        Preconditions.checkNotNull(this.zzl);
        return this.zzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List zzp() {
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzq() {
        String format;
        zzg();
        zzio zzioVar = this.zzu;
        if (!zzioVar.zzm().zzh().zzr(zzjw.ANALYTICS_STORAGE)) {
            zzioVar.zzaW().zzd().zza("Analytics Storage consent is not granted");
            format = null;
        } else {
            byte[] bArr = new byte[16];
            zzioVar.zzw().zzJ().nextBytes(bArr);
            format = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        zzioVar.zzaW().zzd().zza(String.format("Resetting session stitching token to %s", format == null ? AbstractJsonLexerKt.NULL : "not null"));
        this.zzn = format;
        this.zzo = zzioVar.zzaU().currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzr(String str) {
        String str2 = this.zzp;
        boolean z = false;
        if (str2 != null && !str2.equals(str)) {
            z = true;
        }
        this.zzp = str;
        return z;
    }
}
