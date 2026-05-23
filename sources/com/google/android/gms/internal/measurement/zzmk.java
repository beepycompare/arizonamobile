package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzmk extends RuntimeException {
    private final int zza;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzmk(int i, String str, Throwable th) {
        super(r5, th);
        String valueOf;
        if (str != null) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 2 + str.length());
            sb.append(i);
            sb.append(": ");
            sb.append(str);
            valueOf = sb.toString();
        } else {
            valueOf = String.valueOf(i);
        }
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }
}
