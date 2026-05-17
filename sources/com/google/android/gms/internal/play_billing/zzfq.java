package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzfq;
import com.google.android.gms.internal.play_billing.zzfu;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public class zzfq<MessageType extends zzfu<MessageType, BuilderType>, BuilderType extends zzfq<MessageType, BuilderType>> extends zzef<MessageType, BuilderType> {
    protected zzfu zza;
    private final zzfu zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzfq(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzF()) {
            this.zza = messagetype.zzs();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zzhi.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzef
    /* renamed from: zzg */
    public final zzfq zzf() {
        zzfq zzfqVar = (zzfq) this.zzb.zzd(5, null, null);
        zzfqVar.zza = zzk();
        return zzfqVar;
    }

    public final zzfq zzh(zzfu zzfuVar) {
        if (!this.zzb.equals(zzfuVar)) {
            if (!this.zza.zzF()) {
                zzn();
            }
            zza(this.zza, zzfuVar);
        }
        return this;
    }

    public final MessageType zzi() {
        MessageType zzk = zzk();
        if (zzk.zzo()) {
            return zzk;
        }
        throw new zzia(zzk);
    }

    @Override // com.google.android.gms.internal.play_billing.zzha
    /* renamed from: zzj */
    public MessageType zzk() {
        boolean zzF = this.zza.zzF();
        MessageType messagetype = (MessageType) this.zza;
        if (zzF) {
            messagetype.zzz();
            return (MessageType) this.zza;
        }
        return messagetype;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhc
    public final /* bridge */ /* synthetic */ zzhb zzl() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzm() {
        if (this.zza.zzF()) {
            return;
        }
        zzn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzn() {
        zzfu zzs = this.zzb.zzs();
        zza(zzs, this.zza);
        this.zza = zzs;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhc
    public final boolean zzo() {
        return zzfu.zzE(this.zza, false);
    }
}
