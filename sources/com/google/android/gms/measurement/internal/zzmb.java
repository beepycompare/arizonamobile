package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzmb extends zzg {
    protected zzlu zza;
    private volatile zzlu zzb;
    private volatile zzlu zzc;
    private final Map zzd;
    private com.google.android.gms.internal.measurement.zzdf zze;
    private volatile boolean zzf;
    private volatile zzlu zzg;
    private zzlu zzh;
    private boolean zzi;
    private final Object zzj;

    public zzmb(zzic zzicVar) {
        super(zzicVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    private final void zzA(zzlu zzluVar, boolean z, long j) {
        zzic zzicVar = this.zzu;
        zzic zzicVar2 = this.zzu;
        zzicVar2.zzw().zzc(zzicVar.zzaZ().elapsedRealtime());
        if (!zzicVar2.zzh().zzb.zzd(zzluVar != null && zzluVar.zzd, z, j) || zzluVar == null) {
            return;
        }
        zzluVar.zzd = false;
    }

    private final zzlu zzB(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        Preconditions.checkNotNull(zzdfVar);
        Integer valueOf = Integer.valueOf(zzdfVar.zza);
        Map map = this.zzd;
        zzlu zzluVar = (zzlu) map.get(valueOf);
        if (zzluVar == null) {
            zzlu zzluVar2 = new zzlu(null, zzi(zzdfVar.zzb, "Activity"), this.zzu.zzk().zzd());
            map.put(valueOf, zzluVar2);
            zzluVar = zzluVar2;
        }
        return this.zzg != null ? this.zzg : zzluVar;
    }

    private final void zzy(String str, zzlu zzluVar, boolean z) {
        zzlu zzluVar2;
        zzlu zzluVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzluVar.zzb == null) {
            zzluVar2 = new zzlu(zzluVar.zza, str != null ? zzi(str, "Activity") : null, zzluVar.zzc, zzluVar.zze, zzluVar.zzf);
        } else {
            zzluVar2 = zzluVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzluVar2;
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzj(new zzlw(this, zzluVar2, zzluVar3, zzicVar.zzaZ().elapsedRealtime(), z));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzz(zzlu zzluVar, zzlu zzluVar2, long j, boolean z, Bundle bundle) {
        boolean z2;
        long j2;
        zzg();
        boolean z3 = false;
        if (zzluVar2 != null) {
            if (zzluVar2.zzc == zzluVar.zzc && Objects.equals(zzluVar2.zzb, zzluVar.zzb) && Objects.equals(zzluVar2.zza, zzluVar.zza)) {
                z2 = false;
                if (z && this.zza != null) {
                    z3 = true;
                }
                if (z2) {
                    Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
                    zzpp.zzav(zzluVar, bundle2, true);
                    if (zzluVar2 != null) {
                        String str = zzluVar2.zza;
                        if (str != null) {
                            bundle2.putString("_pn", str);
                        }
                        String str2 = zzluVar2.zzb;
                        if (str2 != null) {
                            bundle2.putString("_pc", str2);
                        }
                        bundle2.putLong("_pi", zzluVar2.zzc);
                    }
                    if (z3) {
                        zzoa zzoaVar = this.zzu.zzh().zzb;
                        long j3 = j - zzoaVar.zzb;
                        zzoaVar.zzb = j;
                        if (j3 > 0) {
                            this.zzu.zzk().zzak(bundle2, j3);
                        }
                    }
                    zzic zzicVar = this.zzu;
                    if (!zzicVar.zzc().zzv()) {
                        bundle2.putLong("_mst", 1L);
                    }
                    boolean z4 = zzluVar.zze;
                    String str3 = true != z4 ? "auto" : "app";
                    long currentTimeMillis = zzicVar.zzaZ().currentTimeMillis();
                    if (z4) {
                        long j4 = zzluVar.zzf;
                        if (j4 != 0) {
                            j2 = j4;
                            this.zzu.zzj().zzG(str3, "_vs", j2, bundle2);
                        }
                    }
                    j2 = currentTimeMillis;
                    this.zzu.zzj().zzG(str3, "_vs", j2, bundle2);
                }
                if (z3) {
                    zzA(this.zza, true, j);
                }
                this.zza = zzluVar;
                if (zzluVar.zze) {
                    this.zzh = zzluVar;
                }
                this.zzu.zzt().zzG(zzluVar);
            }
        }
        z2 = true;
        if (z) {
            z3 = true;
        }
        if (z2) {
        }
        if (z3) {
        }
        this.zza = zzluVar;
        if (zzluVar.zze) {
        }
        this.zzu.zzt().zzG(zzluVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return false;
    }

    public final zzlu zzh(boolean z) {
        zzb();
        zzg();
        zzlu zzluVar = this.zza;
        return (z && zzluVar == null) ? this.zzh : zzluVar;
    }

    final String zzi(String str, String str2) {
        String str3;
        if (str == null) {
            return "Activity";
        }
        String[] split = str.split("\\.");
        int length = split.length;
        if (length > 0) {
            str3 = split[length - 1];
        } else {
            str3 = "";
        }
        zzic zzicVar = this.zzu;
        return str3.length() > zzicVar.zzc().zze(null, false) ? str3.substring(0, zzicVar.zzc().zze(null, false)) : str3;
    }

    public final void zzj(Bundle bundle, long j) {
        synchronized (this.zzj) {
            if (!this.zzi) {
                this.zzu.zzaV().zzh().zza("Cannot log screen view event when the app is in the background.");
                return;
            }
            String string = bundle.getString(FirebaseAnalytics.Param.SCREEN_NAME);
            if (string == null || (string.length() > 0 && string.length() <= this.zzu.zzc().zze(null, false))) {
                String string2 = bundle.getString(FirebaseAnalytics.Param.SCREEN_CLASS);
                if (string2 == null || (string2.length() > 0 && string2.length() <= this.zzu.zzc().zze(null, false))) {
                    if (string2 == null) {
                        com.google.android.gms.internal.measurement.zzdf zzdfVar = this.zze;
                        if (zzdfVar != null) {
                            string2 = zzi(zzdfVar.zzb, "Activity");
                        } else {
                            string2 = "Activity";
                        }
                    }
                    zzlu zzluVar = this.zzb;
                    if (this.zzf && zzluVar != null) {
                        this.zzf = false;
                        boolean equals = Objects.equals(zzluVar.zzb, string2);
                        boolean equals2 = Objects.equals(zzluVar.zza, string);
                        if (equals && equals2) {
                            this.zzu.zzaV().zzh().zza("Ignoring call to log screen view event with duplicate parameters.");
                            return;
                        }
                    }
                    zzic zzicVar = this.zzu;
                    zzicVar.zzaV().zzk().zzc("Logging screen view with name, class", string == null ? AbstractJsonLexerKt.NULL : string, string2 == null ? AbstractJsonLexerKt.NULL : string2);
                    zzlu zzluVar2 = this.zzb == null ? this.zzc : this.zzb;
                    zzlu zzluVar3 = new zzlu(string, string2, zzicVar.zzk().zzd(), true, j);
                    this.zzb = zzluVar3;
                    this.zzc = zzluVar2;
                    this.zzg = zzluVar3;
                    zzicVar.zzaW().zzj(new zzlv(this, bundle, zzluVar3, zzluVar2, zzicVar.zzaZ().elapsedRealtime()));
                    return;
                }
                this.zzu.zzaV().zzh().zzb("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                return;
            }
            this.zzu.zzaV().zzh().zzb("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
        }
    }

    @Deprecated
    public final void zzk(com.google.android.gms.internal.measurement.zzdf zzdfVar, String str, String str2) {
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzc().zzv()) {
            zzicVar.zzaV().zzh().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzlu zzluVar = this.zzb;
        if (zzluVar == null) {
            zzicVar.zzaV().zzh().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        Map map = this.zzd;
        Integer valueOf = Integer.valueOf(zzdfVar.zza);
        if (map.get(valueOf) == null) {
            zzicVar.zzaV().zzh().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zzi(zzdfVar.zzb, "Activity");
        }
        String str3 = zzluVar.zzb;
        String str4 = zzluVar.zza;
        boolean equals = Objects.equals(str3, str2);
        boolean equals2 = Objects.equals(str4, str);
        if (!equals || !equals2) {
            if (str == null || (str.length() > 0 && str.length() <= zzicVar.zzc().zze(null, false))) {
                if (str2 == null || (str2.length() > 0 && str2.length() <= zzicVar.zzc().zze(null, false))) {
                    zzicVar.zzaV().zzk().zzc("Setting current screen to name, class", str == null ? AbstractJsonLexerKt.NULL : str, str2);
                    zzlu zzluVar2 = new zzlu(str, str2, zzicVar.zzk().zzd());
                    map.put(valueOf, zzluVar2);
                    zzy(zzdfVar.zzb, zzluVar2, true);
                    return;
                }
                zzicVar.zzaV().zzh().zzb("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
                return;
            }
            zzicVar.zzaV().zzh().zzb("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        zzicVar.zzaV().zzh().zza("setCurrentScreen cannot be called with the same class and name");
    }

    public final zzlu zzl() {
        return this.zzb;
    }

    public final void zzm(com.google.android.gms.internal.measurement.zzdf zzdfVar, Bundle bundle) {
        Bundle bundle2;
        if (!this.zzu.zzc().zzv() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(Integer.valueOf(zzdfVar.zza), new zzlu(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void zzn(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        Object obj = this.zzj;
        synchronized (obj) {
            this.zzi = true;
            if (!Objects.equals(zzdfVar, this.zze)) {
                synchronized (obj) {
                    this.zze = zzdfVar;
                    this.zzf = false;
                    zzic zzicVar = this.zzu;
                    if (zzicVar.zzc().zzv()) {
                        this.zzg = null;
                        zzicVar.zzaW().zzj(new zzma(this));
                    }
                }
            }
        }
        zzic zzicVar2 = this.zzu;
        if (!zzicVar2.zzc().zzv()) {
            this.zzb = this.zzg;
            zzicVar2.zzaW().zzj(new zzlx(this));
            return;
        }
        zzy(zzdfVar.zzb, zzB(zzdfVar), false);
        zzd zzw = this.zzu.zzw();
        zzic zzicVar3 = zzw.zzu;
        zzicVar3.zzaW().zzj(new zzc(zzw, zzicVar3.zzaZ().elapsedRealtime()));
    }

    public final void zzp(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        zzic zzicVar = this.zzu;
        long elapsedRealtime = zzicVar.zzaZ().elapsedRealtime();
        if (!zzicVar.zzc().zzv()) {
            this.zzb = null;
            zzicVar.zzaW().zzj(new zzly(this, elapsedRealtime));
            return;
        }
        zzlu zzB = zzB(zzdfVar);
        this.zzc = this.zzb;
        this.zzb = null;
        zzicVar.zzaW().zzj(new zzlz(this, zzB, elapsedRealtime));
    }

    public final void zzq(com.google.android.gms.internal.measurement.zzdf zzdfVar, Bundle bundle) {
        zzlu zzluVar;
        if (!this.zzu.zzc().zzv() || bundle == null || (zzluVar = (zzlu) this.zzd.get(Integer.valueOf(zzdfVar.zza))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzluVar.zzc);
        bundle2.putString("name", zzluVar.zza);
        bundle2.putString("referrer_name", zzluVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    public final void zzs(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        synchronized (this.zzj) {
            if (Objects.equals(this.zze, zzdfVar)) {
                this.zze = null;
            }
        }
        if (this.zzu.zzc().zzv()) {
            this.zzd.remove(Integer.valueOf(zzdfVar.zza));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzt(Bundle bundle, zzlu zzluVar, zzlu zzluVar2, long j) {
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        zzz(zzluVar, zzluVar2, j, true, this.zzu.zzk().zzF(null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, null, false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzu(zzlu zzluVar, zzlu zzluVar2, long j, boolean z, Bundle bundle) {
        zzz(zzluVar, zzluVar2, j, z, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzv(zzlu zzluVar, boolean z, long j) {
        zzA(zzluVar, false, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzlu zzw() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzx(zzlu zzluVar) {
        this.zzh = null;
    }
}
