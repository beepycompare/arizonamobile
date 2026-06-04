package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.text.TextUtils;
import coil3.util.UtilsKt;
import java.io.File;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzsc {
    public static final File zza(Uri uri) throws zzsi {
        if (!uri.getScheme().equals(UtilsKt.SCHEME_FILE)) {
            throw new zzsi("Scheme must be 'file'");
        }
        if (!TextUtils.isEmpty(uri.getQuery())) {
            throw new zzsi("Did not expect uri to have query");
        }
        if (TextUtils.isEmpty(uri.getAuthority())) {
            return new File(uri.getPath());
        }
        throw new zzsi("Did not expect uri to have authority");
    }
}
