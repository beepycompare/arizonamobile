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
/* loaded from: classes5.dex */
public final class D3 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f507a;
    public final C0691wf b;
    public final String c;
    public final SafePackageManager d;

    public D3(Context context, C0691wf c0691wf, String str, SafePackageManager safePackageManager) {
        this.f507a = context;
        this.b = c0691wf;
        this.c = str;
        this.d = safePackageManager;
    }

    public final List a() {
        Signature[] signatureArr;
        String str;
        List<String> g = this.b.g();
        boolean isEmpty = g.isEmpty();
        ArrayList arrayList = g;
        if (isEmpty) {
            ArrayList arrayList2 = new ArrayList();
            try {
                boolean isApiAchieved = AndroidUtils.isApiAchieved(28);
                SafePackageManager safePackageManager = this.d;
                if (isApiAchieved) {
                    SigningInfo signingInfo = safePackageManager.getPackageInfo(this.f507a, this.c, 134217728).signingInfo;
                    if (signingInfo.hasMultipleSigners()) {
                        signatureArr = signingInfo.getApkContentsSigners();
                    } else {
                        signatureArr = signingInfo.getSigningCertificateHistory();
                    }
                } else {
                    signatureArr = safePackageManager.getPackageInfo(this.f507a, this.c, 64).signatures;
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
                this.b.a(arrayList2).f1281a.flushAsync();
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }
}
