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
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzdr extends zzeq {
    final /* synthetic */ Context zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzfb zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdr(zzfb zzfbVar, Context context, Bundle bundle) {
        super(zzfbVar, true);
        this.zza = context;
        this.zzb = bundle;
        Objects.requireNonNull(zzfbVar);
        this.zzc = zzfbVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041 A[Catch: Exception -> 0x0088, TryCatch #0 {Exception -> 0x0088, blocks: (B:3:0x0006, B:5:0x001e, B:6:0x0022, B:8:0x002a, B:13:0x0034, B:15:0x0041, B:17:0x004b, B:23:0x0065), top: B:28:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[Catch: Exception -> 0x0088, TryCatch #0 {Exception -> 0x0088, blocks: (B:3:0x0006, B:5:0x001e, B:6:0x0022, B:8:0x002a, B:13:0x0034, B:15:0x0041, B:17:0x004b, B:23:0x0065), top: B:28:0x0006 }] */
    @Override // com.google.android.gms.internal.measurement.zzeq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza() {
        boolean z;
        boolean z2;
        try {
            Context context = this.zza;
            Preconditions.checkNotNull(context);
            String zza = com.google.android.gms.measurement.internal.zzht.zza(context);
            Preconditions.checkNotNull(context);
            Resources resources = context.getResources();
            if (TextUtils.isEmpty(zza)) {
                zza = com.google.android.gms.measurement.internal.zzht.zza(context);
            }
            Boolean zzc = com.google.android.gms.measurement.internal.zzht.zzc("google_analytics_force_disable_updates", resources, zza);
            zzfb zzfbVar = this.zzc;
            if (zzc != null && zzc.booleanValue()) {
                z = false;
                zzfbVar.zzR(zzfbVar.zzc(context, z));
                if (zzfbVar.zzQ() == null) {
                    int localVersion = DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
                    int remoteVersion = DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
                    int max = Math.max(localVersion, remoteVersion);
                    if (!Boolean.TRUE.equals(zzc) && remoteVersion >= localVersion) {
                        z2 = false;
                        ((zzcr) Preconditions.checkNotNull(zzfbVar.zzQ())).initialize(ObjectWrapper.wrap(context), new zzdd(130000L, max, z2, this.zzb, com.google.android.gms.measurement.internal.zzht.zza(context)), this.zzh);
                        return;
                    }
                    z2 = true;
                    ((zzcr) Preconditions.checkNotNull(zzfbVar.zzQ())).initialize(ObjectWrapper.wrap(context), new zzdd(130000L, max, z2, this.zzb, com.google.android.gms.measurement.internal.zzht.zza(context)), this.zzh);
                    return;
                }
                Log.w(zzfbVar.zzO(), "Failed to connect to measurement client.");
                return;
            }
            z = true;
            zzfbVar.zzR(zzfbVar.zzc(context, z));
            if (zzfbVar.zzQ() == null) {
            }
        } catch (Exception e) {
            this.zzc.zzN(e, true, false);
        }
    }
}
