package io.appmetrica.analytics.network.impl;

import io.appmetrica.analytics.networkapi.Call;
import io.appmetrica.analytics.networkapi.Response;
/* loaded from: classes5.dex */
public final class a extends Call {
    @Override // io.appmetrica.analytics.networkapi.Call
    public final Response execute() {
        return new Response.Builder(new IllegalStateException("This is dummy call")).build();
    }
}
