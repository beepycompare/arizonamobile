package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzaca;
import com.google.android.gms.internal.measurement.zzacb;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzacb<MessageType extends zzacb<MessageType, BuilderType>, BuilderType extends zzaca<MessageType, BuilderType>> implements zzafc {
    protected transient int zza = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzcg(Iterable iterable, List list) {
        zzaca.zzaV(iterable, list);
    }

    @Override // com.google.android.gms.internal.measurement.zzafc
    public final zzacr zzcc() {
        try {
            int zzcq = zzcq();
            zzacr zzacrVar = zzacr.zza;
            byte[] bArr = new byte[zzcq];
            int i = zzada.zzb;
            zzacx zzacxVar = new zzacx(bArr, 0, zzcq);
            zzcH(zzacxVar);
            return zzaco.zza(zzacxVar, bArr);
        } catch (IOException e) {
            String name = this.getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final byte[] zzcd() {
        try {
            int zzcq = zzcq();
            byte[] bArr = new byte[zzcq];
            int i = zzada.zzb;
            zzacx zzacxVar = new zzacx(bArr, 0, zzcq);
            zzcH(zzacxVar);
            zzacxVar.zzH();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafc
    public final void zzce(OutputStream outputStream) throws IOException {
        int zzcq = zzcq();
        int i = zzada.zzb;
        if (zzcq > 4096) {
            zzcq = 4096;
        }
        zzacz zzaczVar = new zzacz(outputStream, zzcq);
        zzcH(zzaczVar);
        zzaczVar.zzx();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzcf(zzafp zzafpVar) {
        throw null;
    }
}
