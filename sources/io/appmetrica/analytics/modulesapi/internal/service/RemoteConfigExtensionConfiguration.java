package io.appmetrica.analytics.modulesapi.internal.service;

import androidx.exifinterface.media.ExifInterface;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreapi.internal.data.JsonParser;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tH&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH&J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\rH&J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H&¨\u0006\u0011"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigExtensionConfiguration;", ExifInterface.LATITUDE_SOUTH, "", "()V", "getBlocks", "", "", "", "getFeatures", "", "getJsonParser", "Lio/appmetrica/analytics/coreapi/internal/data/JsonParser;", "getProtobufConverter", "Lio/appmetrica/analytics/coreapi/internal/data/Converter;", "", "getRemoteConfigUpdateListener", "Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigUpdateListener;", "modules-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class RemoteConfigExtensionConfiguration<S> {
    public abstract Map<String, Integer> getBlocks();

    public abstract List<String> getFeatures();

    public abstract JsonParser<S> getJsonParser();

    public abstract Converter<S, byte[]> getProtobufConverter();

    public abstract RemoteConfigUpdateListener<S> getRemoteConfigUpdateListener();
}
