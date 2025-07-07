package io.appmetrica.analytics.networktasks.impl;

import android.net.Uri;
import com.adjust.sdk.Constants;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f1226a;

    public c(String str) {
        this.f1226a = a(str);
    }

    public static String a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Uri parse = Uri.parse(str);
        return Intrinsics.areEqual("http", parse.getScheme()) ? parse.buildUpon().scheme(Constants.SCHEME).build().toString() : str;
    }
}
