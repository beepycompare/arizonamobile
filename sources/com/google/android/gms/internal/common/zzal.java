package com.google.android.gms.internal.common;

import org.jspecify.annotations.NullMarked;
/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
@NullMarked
/* loaded from: classes3.dex */
public final class zzal {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] zza(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (objArr[i2] == null) {
                throw new NullPointerException("at index " + i2);
            }
        }
        return objArr;
    }
}
