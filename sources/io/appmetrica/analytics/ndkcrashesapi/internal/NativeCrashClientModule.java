package io.appmetrica.analytics.ndkcrashesapi.internal;

import android.content.Context;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lio/appmetrica/analytics/ndkcrashesapi/internal/NativeCrashClientModule;", "", "()V", "initHandling", "", "context", "Landroid/content/Context;", "config", "Lio/appmetrica/analytics/ndkcrashesapi/internal/NativeCrashClientConfig;", "updateAppMetricaMetadata", TtmlNode.TAG_METADATA, "", "ndkcrashes-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class NativeCrashClientModule {
    public abstract void initHandling(Context context, NativeCrashClientConfig nativeCrashClientConfig);

    public abstract void updateAppMetricaMetadata(String str);
}
