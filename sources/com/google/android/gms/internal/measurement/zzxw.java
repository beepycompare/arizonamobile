package com.google.android.gms.internal.measurement;

import java.util.Map;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzxw extends zzyl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxw(String str, Class cls, boolean z) {
        super("tags", cls, false);
    }

    @Override // com.google.android.gms.internal.measurement.zzyl
    public final /* bridge */ /* synthetic */ void zzb(Object obj, zzyk zzykVar) {
        zzabe zzabeVar = (zzabe) obj;
        if (zzabeVar == null) {
            return;
        }
        for (Map.Entry entry : zzabeVar.zzb().entrySet()) {
            if (!((Set) entry.getValue()).isEmpty()) {
                for (Object obj2 : (Set) entry.getValue()) {
                    zzykVar.zza((String) entry.getKey(), obj2);
                }
            } else {
                zzykVar.zza((String) entry.getKey(), null);
            }
        }
    }
}
