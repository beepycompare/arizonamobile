package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzdp extends zzeo {
    final /* synthetic */ Context zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzez zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdp(zzez zzezVar, Context context, Bundle bundle) {
        super(zzezVar, true);
        this.zza = context;
        this.zzb = bundle;
        Objects.requireNonNull(zzezVar);
        this.zzc = zzezVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0048 A[Catch: Exception -> 0x00b7, TryCatch #0 {Exception -> 0x00b7, blocks: (B:3:0x0006, B:5:0x0025, B:6:0x0029, B:8:0x0031, B:13:0x003b, B:15:0x0048, B:17:0x0052, B:23:0x006c, B:25:0x0086, B:27:0x00a1), top: B:32:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052 A[Catch: Exception -> 0x00b7, TryCatch #0 {Exception -> 0x00b7, blocks: (B:3:0x0006, B:5:0x0025, B:6:0x0029, B:8:0x0031, B:13:0x003b, B:15:0x0048, B:17:0x0052, B:23:0x006c, B:25:0x0086, B:27:0x00a1), top: B:32:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0086 A[Catch: Exception -> 0x00b7, TryCatch #0 {Exception -> 0x00b7, blocks: (B:3:0x0006, B:5:0x0025, B:6:0x0029, B:8:0x0031, B:13:0x003b, B:15:0x0048, B:17:0x0052, B:23:0x006c, B:25:0x0086, B:27:0x00a1), top: B:32:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1 A[Catch: Exception -> 0x00b7, TRY_LEAVE, TryCatch #0 {Exception -> 0x00b7, blocks: (B:3:0x0006, B:5:0x0025, B:6:0x0029, B:8:0x0031, B:13:0x003b, B:15:0x0048, B:17:0x0052, B:23:0x006c, B:25:0x0086, B:27:0x00a1), top: B:32:0x0006 }] */
    @Override // com.google.android.gms.internal.measurement.zzeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza() {
        boolean z;
        boolean z2;
        try {
            Context context = this.zza;
            Preconditions.checkNotNull(context);
            com.google.firebase.analytics.zzg.zza().zzb();
            String zza = com.google.android.gms.measurement.internal.zzhu.zza(context);
            Preconditions.checkNotNull(context);
            Resources resources = context.getResources();
            if (TextUtils.isEmpty(zza)) {
                zza = com.google.android.gms.measurement.internal.zzhu.zza(context);
            }
            Boolean zzc = com.google.android.gms.measurement.internal.zzhu.zzc("google_analytics_force_disable_updates", resources, zza);
            zzez zzezVar = this.zzc;
            if (zzc != null && zzc.booleanValue()) {
                z = false;
                zzezVar.zzT(zzezVar.zzc(context, z));
                if (zzezVar.zzS() == null) {
                    int localVersion = DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
                    int remoteVersion = DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
                    int max = Math.max(localVersion, remoteVersion);
                    if (!Boolean.TRUE.equals(zzc) && remoteVersion >= localVersion) {
                        z2 = false;
                        long j = max;
                        zzezVar.zzU(j);
                        zzdb zzdbVar = new zzdb(161000L, j, z2, this.zzb, com.google.android.gms.measurement.internal.zzhu.zza(context));
                        if (zzezVar.zzO()) {
                            ((zzcp) Preconditions.checkNotNull(zzezVar.zzS())).initialize(ObjectWrapper.wrap(context), zzdbVar, this.zzi);
                            return;
                        } else {
                            ((zzcp) Preconditions.checkNotNull(zzezVar.zzS())).initializeWithElapsedTime(ObjectWrapper.wrap(context), zzdbVar, this.zzi, this.zzj);
                            return;
                        }
                    }
                    z2 = true;
                    long j2 = max;
                    zzezVar.zzU(j2);
                    zzdb zzdbVar2 = new zzdb(161000L, j2, z2, this.zzb, com.google.android.gms.measurement.internal.zzhu.zza(context));
                    if (zzezVar.zzO()) {
                    }
                } else {
                    Log.w(zzezVar.zzQ(), "Failed to connect to measurement client.");
                    return;
                }
            }
            z = true;
            zzezVar.zzT(zzezVar.zzc(context, z));
            if (zzezVar.zzS() == null) {
            }
        } catch (Exception e) {
            this.zzc.zzN(e, true, false);
        }
    }
}
