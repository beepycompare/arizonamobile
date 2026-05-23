package com.google.android.gms.internal.measurement;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzze {
    public static /* synthetic */ boolean zza(int i, zzyc zzycVar, StringBuilder sb) {
        if (i - 1 == 0 && zzycVar != zzyc.zza) {
            sb.append(zzycVar.zza());
            sb.append('.');
            sb.append(zzycVar.zzb());
            sb.append(AbstractJsonLexerKt.COLON);
            sb.append(zzycVar.zzc());
            return true;
        }
        return false;
    }
}
