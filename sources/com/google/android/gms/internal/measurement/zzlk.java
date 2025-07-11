package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Locale;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzlk extends IOException {
    zzlk() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzlk(long j, long j2, int i, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(r2)), th);
        String format = String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i));
        String.valueOf(format);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlk(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
