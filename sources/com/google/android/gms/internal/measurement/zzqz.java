package com.google.android.gms.internal.measurement;

import com.google.common.base.Function;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final /* synthetic */ class zzqz implements Function {
    static final /* synthetic */ zzqz zza = new zzqz();

    private /* synthetic */ zzqz() {
    }

    @Override // com.google.common.base.Function
    public final /* synthetic */ Object apply(Object obj) {
        zzmk zzmkVar = (zzmk) obj;
        if (zzmkVar.zza() == 29514) {
            zznn zzd = zzno.zzd();
            zznh zzo = zzni.zzo();
            zzo.zza(System.currentTimeMillis());
            zzd.zza(zzo);
            return (zzno) zzd.zzbd();
        }
        throw zzmkVar;
    }
}
