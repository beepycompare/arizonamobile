package io.appmetrica.analytics.networkokhttp.impl;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes5.dex */
public final class b extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Response f1379a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Response response) {
        super(0);
        this.f1379a = response;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ResponseBody body = this.f1379a.body();
        if (body != null) {
            return body.byteStream();
        }
        return null;
    }
}
