package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.idsync.internal.model.NetworkType;
import io.appmetrica.analytics.idsync.internal.model.Preconditions;
import io.appmetrica.analytics.idsync.internal.model.RequestConfig;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public final class C implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final k fromModel(RequestConfig requestConfig) {
        k kVar = new k();
        String type = requestConfig.getType();
        Charset charset = Charsets.UTF_8;
        kVar.f477a = type.getBytes(charset);
        j jVar = new j();
        jVar.f476a = B.f463a[requestConfig.getPreconditions().getNetworkType().ordinal()] != 1 ? 0 : 1;
        kVar.b = jVar;
        kVar.c = requestConfig.getUrl().getBytes(charset);
        Map<String, List<String>> headers = requestConfig.getHeaders();
        ArrayList arrayList = new ArrayList(headers.size());
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            List<String> value = entry.getValue();
            i iVar = new i();
            iVar.f475a = entry.getKey().getBytes(Charsets.UTF_8);
            int size = value.size();
            byte[][] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                bArr[i] = value.get(i).getBytes(Charsets.UTF_8);
            }
            iVar.b = bArr;
            arrayList.add(iVar);
        }
        Object[] array = arrayList.toArray(new i[0]);
        if (array != null) {
            kVar.d = (i[]) array;
            kVar.e = requestConfig.getResendIntervalForValidResponse();
            kVar.f = requestConfig.getResendIntervalForInvalidResponse();
            kVar.g = CollectionsKt.toIntArray(requestConfig.getValidResponseCodes());
            kVar.h = requestConfig.getReportEventEnabled();
            String reportUrl = requestConfig.getReportUrl();
            if (reportUrl == null) {
                reportUrl = "";
            }
            kVar.i = reportUrl;
            return kVar;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        if (r4 == null) goto L22;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final RequestConfig toModel(k kVar) {
        NetworkType networkType;
        byte[] bArr = kVar.f477a;
        Charset charset = Charsets.UTF_8;
        String str = new String(bArr, charset);
        j jVar = kVar.b;
        if (jVar != null) {
            if (jVar.f476a == 1) {
                networkType = NetworkType.CELL;
            } else {
                networkType = NetworkType.ANY;
            }
        }
        networkType = NetworkType.ANY;
        Preconditions preconditions = new Preconditions(networkType);
        String str2 = new String(kVar.c, charset);
        i[] iVarArr = kVar.d;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(iVarArr.length), 16));
        for (i iVar : iVarArr) {
            String str3 = new String(iVar.f475a, Charsets.UTF_8);
            byte[][] bArr2 = iVar.b;
            ArrayList arrayList = new ArrayList(bArr2.length);
            for (byte[] bArr3 : bArr2) {
                arrayList.add(new String(bArr3, Charsets.UTF_8));
            }
            Pair pair = TuplesKt.to(str3, arrayList);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        long j = kVar.e;
        long j2 = kVar.f;
        List<Integer> list = ArraysKt.toList(kVar.g);
        boolean z = kVar.h;
        String str4 = kVar.i;
        if (str4.length() <= 0) {
            str4 = null;
        }
        return new RequestConfig(str, str2, preconditions, linkedHashMap, j, j2, list, z, str4);
    }
}
