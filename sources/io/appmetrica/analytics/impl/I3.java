package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class I3 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f470a;
    public final Cif b;
    public final String c;
    public final SafePackageManager d;

    public I3(Context context, Cif cif, String str, SafePackageManager safePackageManager) {
        this.f470a = context;
        this.b = cif;
        this.c = str;
        this.d = safePackageManager;
    }

    public final List a() {
        Signature[] signatureArr;
        String str;
        List<String> f = this.b.f();
        boolean isEmpty = f.isEmpty();
        ArrayList arrayList = f;
        if (isEmpty) {
            ArrayList arrayList2 = new ArrayList();
            try {
                if (AndroidUtils.isApiAchieved(28)) {
                    SigningInfo signingInfo = this.d.getPackageInfo(this.f470a, this.c, androidx.media3.common.C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo;
                    if (signingInfo.hasMultipleSigners()) {
                        signatureArr = signingInfo.getApkContentsSigners();
                    } else {
                        signatureArr = signingInfo.getSigningCertificateHistory();
                    }
                } else {
                    signatureArr = this.d.getPackageInfo(this.f470a, this.c, 64).signatures;
                }
                if (signatureArr != null) {
                    for (Signature signature : signatureArr) {
                        try {
                            str = StringUtils.formatSha1(MessageDigest.getInstance("SHA1").digest(signature.toByteArray()));
                        } catch (Throwable unused) {
                            str = null;
                        }
                        if (str != null) {
                            arrayList2.add(str);
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
            Collections.sort(arrayList2);
            boolean isEmpty2 = arrayList2.isEmpty();
            arrayList = arrayList2;
            if (!isEmpty2) {
                this.b.a(arrayList2).b();
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }
}
