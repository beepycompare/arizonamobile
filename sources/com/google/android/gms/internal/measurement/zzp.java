package com.google.android.gms.internal.measurement;

import androidx.core.app.NotificationCompat;
import java.util.List;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
final class zzp extends zzai {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzp(zzt zztVar, String str) {
        super(NotificationCompat.GROUP_KEY_SILENT);
        Objects.requireNonNull(zztVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzao zza(zzg zzgVar, List list) {
        return this;
    }
}
