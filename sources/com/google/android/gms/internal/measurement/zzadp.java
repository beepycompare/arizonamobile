package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzadp;
import com.google.android.gms.internal.measurement.zzadu;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public class zzadp<MessageType extends zzadu<MessageType, BuilderType>, BuilderType extends zzadp<MessageType, BuilderType>> extends zzaca<MessageType, BuilderType> {
    protected zzadu zza;
    private final zzadu zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzadp(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzch()) {
            this.zza = messagetype.zzck();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zzafl.zza().zzb(obj.getClass()).zzd(obj, obj2);
    }

    @Override // com.google.android.gms.internal.measurement.zzaca
    public final /* bridge */ /* synthetic */ zzaca zzaT(byte[] bArr, int i, int i2) throws zzaeh {
        int i3 = zzadf.zzb;
        int i4 = zzacf.zza;
        zzbf(bArr, 0, i2, zzadf.zza);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzaca
    public final /* bridge */ /* synthetic */ zzaca zzaU(byte[] bArr, int i, int i2, zzadf zzadfVar) throws zzaeh {
        zzbf(bArr, 0, i2, zzadfVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzaY() {
        if (this.zza.zzch()) {
            return;
        }
        zzaZ();
    }

    protected void zzaZ() {
        zzadu zzck = this.zzb.zzck();
        zza(zzck, this.zza);
        this.zza = zzck;
    }

    @Override // com.google.android.gms.internal.measurement.zzaca
    /* renamed from: zzbb */
    public final zzadp zzaS() {
        zzadp zzadpVar = (zzadp) this.zzb.zzg(5, null, null);
        zzadpVar.zza = zzbg();
        return zzadpVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzafb
    /* renamed from: zzbc */
    public MessageType zzbg() {
        boolean zzch = this.zza.zzch();
        MessageType messagetype = (MessageType) this.zza;
        if (zzch) {
            messagetype.zzcm();
            return (MessageType) this.zza;
        }
        return messagetype;
    }

    public final MessageType zzbd() {
        MessageType zzbg = zzbg();
        if (zzbg.zzcJ()) {
            return zzbg;
        }
        throw new zzafy(zzbg);
    }

    public final zzadp zzbe(zzadu zzaduVar) {
        if (!this.zzb.equals(zzaduVar)) {
            if (!this.zza.zzch()) {
                zzaZ();
            }
            zza(this.zza, zzaduVar);
        }
        return this;
    }

    public final zzadp zzbf(byte[] bArr, int i, int i2, zzadf zzadfVar) throws zzaeh {
        if (!this.zza.zzch()) {
            zzaZ();
        }
        try {
            zzafl.zza().zzb(this.zza.getClass()).zzj(this.zza, bArr, 0, i2, new zzacg(zzadfVar));
            return this;
        } catch (zzaeh e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafd
    public final boolean zzcJ() {
        boolean zzd;
        zzd = zzadu.zzd(this.zza, false);
        return zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzafd
    public final /* synthetic */ zzafc zzcK() {
        throw null;
    }
}
