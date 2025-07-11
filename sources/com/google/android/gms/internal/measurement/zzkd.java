package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzkd extends zzkl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkd(zzkf zzkfVar, String str, Double d, boolean z) {
        super(zzkfVar, "measurement.test.double_flag", d, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    @Nullable
    final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String str = this.zzb;
        String obj2 = obj.toString();
        StringBuilder sb = new StringBuilder(str.length() + 27 + obj2.length());
        sb.append("Invalid double value for ");
        sb.append(str);
        sb.append(": ");
        sb.append(obj2);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
