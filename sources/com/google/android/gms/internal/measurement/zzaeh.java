package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public class zzaeh extends IOException {
    private boolean zza;

    public zzaeh(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        this.zza = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzb() {
        return this.zza;
    }

    public zzaeh(String str) {
        super(str);
    }

    public zzaeh(String str, IOException iOException) {
        super("Unable to parse map entry.", iOException);
    }
}
