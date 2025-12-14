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
/* loaded from: classes3.dex */
public final class x implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final m fromModel(RequestConfig requestConfig) {
        m mVar = new m();
        String type = requestConfig.getType();
        Charset charset = Charsets.UTF_8;
        mVar.f469a = type.getBytes(charset);
        l lVar = new l();
        lVar.f468a = w.f477a[requestConfig.getPreconditions().getNetworkType().ordinal()] != 1 ? 0 : 1;
        mVar.b = lVar;
        mVar.c = requestConfig.getUrl().getBytes(charset);
        Map<String, List<String>> headers = requestConfig.getHeaders();
        ArrayList arrayList = new ArrayList(headers.size());
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            List<String> value = entry.getValue();
            k kVar = new k();
            kVar.f467a = entry.getKey().getBytes(Charsets.UTF_8);
            int size = value.size();
            byte[][] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                bArr[i] = value.get(i).getBytes(Charsets.UTF_8);
            }
            kVar.b = bArr;
            arrayList.add(kVar);
        }
        Object[] array = arrayList.toArray(new k[0]);
        if (array != null) {
            mVar.d = (k[]) array;
            mVar.e = requestConfig.getResendIntervalForValidResponse();
            mVar.f = requestConfig.getResendIntervalForInvalidResponse();
            mVar.g = CollectionsKt.toIntArray(requestConfig.getValidResponseCodes());
            return mVar;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        if (r4 == null) goto L19;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final RequestConfig toModel(m mVar) {
        NetworkType networkType;
        byte[] bArr = mVar.f469a;
        Charset charset = Charsets.UTF_8;
        String str = new String(bArr, charset);
        l lVar = mVar.b;
        if (lVar != null) {
            if (lVar.f468a == 1) {
                networkType = NetworkType.CELL;
            } else {
                networkType = NetworkType.ANY;
            }
        }
        networkType = NetworkType.ANY;
        Preconditions preconditions = new Preconditions(networkType);
        String str2 = new String(mVar.c, charset);
        k[] kVarArr = mVar.d;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(kVarArr.length), 16));
        for (k kVar : kVarArr) {
            String str3 = new String(kVar.f467a, Charsets.UTF_8);
            byte[][] bArr2 = kVar.b;
            ArrayList arrayList = new ArrayList(bArr2.length);
            for (byte[] bArr3 : bArr2) {
                arrayList.add(new String(bArr3, Charsets.UTF_8));
            }
            Pair pair = TuplesKt.to(str3, arrayList);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return new RequestConfig(str, str2, preconditions, linkedHashMap, mVar.e, mVar.f, ArraysKt.toList(mVar.g));
    }
}
