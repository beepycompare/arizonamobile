package io.appmetrica.analytics.network.impl;

import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class b extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HttpsURLConnection f1219a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(HttpsURLConnection httpsURLConnection) {
        super(0);
        this.f1219a = httpsURLConnection;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.f1219a.getErrorStream();
    }
}
