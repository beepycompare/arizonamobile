package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.common.base.Supplier;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
final class zzjn extends zzkg {
    private final Context zza;
    @Nullable
    private final Supplier zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjn(Context context, @Nullable Supplier supplier) {
        this.zza = context;
        this.zzb = supplier;
    }

    public final boolean equals(Object obj) {
        Supplier supplier;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzkg) {
            zzkg zzkgVar = (zzkg) obj;
            if (this.zza.equals(zzkgVar.zza()) && ((supplier = this.zzb) != null ? supplier.equals(zzkgVar.zzb()) : zzkgVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zza.hashCode() ^ 1000003;
        Supplier supplier = this.zzb;
        return (hashCode * 1000003) ^ (supplier == null ? 0 : supplier.hashCode());
    }

    public final String toString() {
        String obj = this.zza.toString();
        int length = obj.length();
        String valueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(length + 45 + String.valueOf(valueOf).length() + 1);
        sb.append("FlagsContext{context=");
        sb.append(obj);
        sb.append(", hermeticFileOverrides=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Context zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkg
    @Nullable
    public final Supplier zzb() {
        return this.zzb;
    }
}
