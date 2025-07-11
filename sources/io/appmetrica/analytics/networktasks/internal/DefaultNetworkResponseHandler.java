package io.appmetrica.analytics.networktasks.internal;

import io.appmetrica.analytics.networktasks.internal.DefaultResponseParser;
/* loaded from: classes4.dex */
public class DefaultNetworkResponseHandler implements NetworkResponseHandler<DefaultResponseParser.Response> {

    /* renamed from: a  reason: collision with root package name */
    private final DefaultResponseParser f1235a;

    public DefaultNetworkResponseHandler() {
        this(new DefaultResponseParser());
    }

    DefaultNetworkResponseHandler(DefaultResponseParser defaultResponseParser) {
        this.f1235a = defaultResponseParser;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler
    public DefaultResponseParser.Response handle(ResponseDataHolder responseDataHolder) {
        if (200 == responseDataHolder.getResponseCode()) {
            return this.f1235a.parse(responseDataHolder.getResponseData());
        }
        return null;
    }
}
