package com.google.android.gms.internal.measurement;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzpe {
    private final ConcurrentMap zza = new ConcurrentHashMap();

    private zzpe() {
    }

    private final void zzd(zzlk zzlkVar, zzon zzonVar) {
        zzql.zza(zzlkVar.zzc(), new zzqk() { // from class: com.google.android.gms.internal.measurement.zzoz
            @Override // com.google.android.gms.internal.measurement.zzqk
            public final /* synthetic */ void zza(String str) {
                zzpe.this.zza(str);
            }
        }, new zzqj(this) { // from class: com.google.android.gms.internal.measurement.zzpa
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        zzoo zzooVar = (zzoo) this.zza.get(str);
        if (zzooVar != null) {
            zzooVar.zzc(zzpc.zza);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzb(Collection collection) {
        boolean z = false;
        if (collection != null) {
            if (collection.isEmpty()) {
                return false;
            }
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                zzoo zzooVar = (zzoo) this.zza.get((String) it.next());
                if (zzooVar != null) {
                    z |= zzooVar.zzb();
                }
            }
        }
        return z;
    }

    public final zzoo zzc(final zzlk zzlkVar, final zzon zzonVar, String str) {
        final zzpd zzpdVar = new zzpd(null);
        zzoo zzooVar = (zzoo) this.zza.computeIfAbsent(zzonVar.zza(zzlkVar.zzc()), new Function(zzonVar, "", zzpdVar) { // from class: com.google.android.gms.internal.measurement.zzpb
            private final /* synthetic */ zzon zzb;
            private final /* synthetic */ zzpd zzc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzc = zzpdVar;
            }

            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                String str2 = (String) obj;
                zzoo zzooVar2 = new zzoo(new zzpg(zzlk.this, this.zzb, "", null), null);
                this.zzc.zzb(true);
                return zzooVar2;
            }
        });
        if (zzpdVar.zza()) {
            zzd(zzlkVar, zzonVar);
        }
        return zzooVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpe(byte[] bArr) {
    }
}
