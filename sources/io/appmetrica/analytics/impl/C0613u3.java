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
/* renamed from: io.appmetrica.analytics.impl.u3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0613u3 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1143a;
    public final C0143bf b;
    public final String c;
    public final SafePackageManager d;

    public C0613u3(Context context, C0143bf c0143bf, String str, SafePackageManager safePackageManager) {
        this.f1143a = context;
        this.b = c0143bf;
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
                if (AndroidUtils.isApiAchieved(28)) {
                    SigningInfo signingInfo = this.d.getPackageInfo(this.f1143a, this.c, androidx.media3.common.C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo;
                    if (signingInfo.hasMultipleSigners()) {
                        signatureArr = signingInfo.getApkContentsSigners();
                    } else {
                        signatureArr = signingInfo.getSigningCertificateHistory();
                    }
                } else {
                    signatureArr = this.d.getPackageInfo(this.f1143a, this.c, 64).signatures;
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
