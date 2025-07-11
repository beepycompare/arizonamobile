package ru.mrlargha.arizonaui.ghetto.data;

import androidx.compose.material3.MenuKt;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.ts.TsExtractor;
import io.appmetrica.analytics.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: territoryOrder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"territoryOrder", "", "", "getTerritoryOrder", "()Ljava/util/List;", "ArizonaUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TerritoryOrderKt {
    private static final List<Integer> territoryOrder = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf((int) MenuKt.InTransitionDuration), 121, 122, 123, 124, 125, Integer.valueOf((int) WebSocketProtocol.PAYLOAD_SHORT), 127, 128, Integer.valueOf((int) TsExtractor.TS_STREAM_TYPE_AC3), 110, 111, 112, 113, 114, Integer.valueOf((int) BuildConfig.API_LEVEL), Integer.valueOf((int) AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID), 117, 118, 119, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Integer.valueOf((int) TsExtractor.TS_STREAM_TYPE_HDMV_DTS), 1, 2, 3, 4, 5, 6, 7, 8, 9});

    public static final List<Integer> getTerritoryOrder() {
        return territoryOrder;
    }
}
