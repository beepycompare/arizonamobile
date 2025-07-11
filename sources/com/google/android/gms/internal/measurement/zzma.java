package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzma;
import com.google.android.gms.internal.measurement.zzme;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public class zzma<MessageType extends zzme<MessageType, BuilderType>, BuilderType extends zzma<MessageType, BuilderType>> extends zzkq<MessageType, BuilderType> {
    protected zzme zza;
    private final zzme zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzma(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzcf()) {
            this.zza = messagetype.zzch();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zznt.zza().zzb(obj.getClass()).zzd(obj, obj2);
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    public final /* bridge */ /* synthetic */ zzkq zzaS(byte[] bArr, int i, int i2) throws zzmq {
        int i3 = zzlq.zzb;
        int i4 = zznt.zza;
        zzbe(bArr, 0, i2, zzlq.zza);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    public final /* bridge */ /* synthetic */ zzkq zzaT(byte[] bArr, int i, int i2, zzlq zzlqVar) throws zzmq {
        zzbe(bArr, 0, i2, zzlqVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzaX() {
        if (this.zza.zzcf()) {
            return;
        }
        zzaY();
    }

    protected void zzaY() {
        zzme zzch = this.zzb.zzch();
        zza(zzch, this.zza);
        this.zza = zzch;
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    /* renamed from: zzba */
    public final zzma zzaR() {
        zzma zzmaVar = (zzma) this.zzb.zzl(5, null, null);
        zzmaVar.zza = zzbf();
        return zzmaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zznk
    /* renamed from: zzbb */
    public MessageType zzbf() {
        if (this.zza.zzcf()) {
            this.zza.zzcj();
            return (MessageType) this.zza;
        }
        return (MessageType) this.zza;
    }

    public final MessageType zzbc() {
        MessageType zzbf = zzbf();
        if (zzbf.zzcD()) {
            return zzbf;
        }
        throw new zzog(zzbf);
    }

    public final zzma zzbd(zzme zzmeVar) {
        if (!this.zzb.equals(zzmeVar)) {
            if (!this.zza.zzcf()) {
                zzaY();
            }
            zza(this.zza, zzmeVar);
        }
        return this;
    }

    public final zzma zzbe(byte[] bArr, int i, int i2, zzlq zzlqVar) throws zzmq {
        if (!this.zza.zzcf()) {
            zzaY();
        }
        try {
            zznt.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, 0, i2, new zzkv(zzlqVar));
            return this;
        } catch (zzmq e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznm
    public final boolean zzcD() {
        return zzme.zzcx(this.zza, false);
    }

    @Override // com.google.android.gms.internal.measurement.zznm
    public final /* bridge */ /* synthetic */ zznl zzcE() {
        throw null;
    }
}
