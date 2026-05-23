package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.data.JsonParser;
import io.appmetrica.analytics.coreutils.internal.parsing.RemoteConfigJsonUtils;
import io.appmetrica.analytics.idsync.internal.model.IdSyncConfig;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.idsync.impl.c  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0101c implements JsonParser {

    /* renamed from: a  reason: collision with root package name */
    public final C0103e f419a;
    public final String b = "id_sync";
    public final String c = "id_sync";
    public final String d = "launch_delay_seconds";
    public final String e = "requests";
    public final String f = "type";
    public final String g = "url";
    public final String h = "headers";
    public final String i = "resend_interval_for_valid_response";
    public final String j = "resend_interval_for_invalid_response";
    public final String k = "valid_response_codes";
    public final String l = "preconditions";
    public final String m = "network";
    public final String n = "cell";
    public final String o = "report_event_enabled";
    public final String p = "report_url";

    public C0101c(C0103e c0103e) {
        this.f419a = c0103e;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Parser
    /* renamed from: a */
    public final IdSyncConfig parse(JSONObject jSONObject) {
        k[] kVarArr;
        JSONArray jSONArray;
        i[] iVarArr;
        JSONArray jSONArray2;
        byte[][] bArr;
        int[] iArr;
        int[] iArr2;
        int i;
        JSONObject optJSONObject = jSONObject.optJSONObject(this.c);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        m mVar = new m();
        mVar.f429a = RemoteConfigJsonUtils.extractFeature(jSONObject, this.b, mVar.f429a);
        l lVar = new l();
        lVar.f428a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject, this.d, lVar.f428a);
        JSONArray optJSONArray = optJSONObject.optJSONArray(this.e);
        int i2 = 0;
        if (optJSONArray == null) {
            kVarArr = new k[0];
        } else {
            int length = optJSONArray.length();
            k[] kVarArr2 = new k[length];
            int i3 = 0;
            while (i3 < length) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                k kVar = new k();
                if (optJSONObject2 == null) {
                    jSONArray = optJSONArray;
                    i = i2;
                } else {
                    String optString = optJSONObject2.optString(this.f);
                    Charset charset = Charsets.UTF_8;
                    kVar.f427a = optString.getBytes(charset);
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject(this.l);
                    j jVar = new j();
                    if (optJSONObject3 != null && Intrinsics.areEqual(optJSONObject3.optString(this.m), this.n)) {
                        jVar.f426a = 1;
                    }
                    kVar.b = jVar;
                    kVar.c = optJSONObject2.optString(this.g).getBytes(charset);
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject(this.h);
                    if (optJSONObject4 == null) {
                        iVarArr = new i[i2];
                        jSONArray = optJSONArray;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        Iterator<String> keys = optJSONObject4.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            i iVar = new i();
                            iVar.f425a = next.getBytes(Charsets.UTF_8);
                            JSONArray optJSONArray2 = optJSONObject4.optJSONArray(next);
                            if (optJSONArray2 == null) {
                                bArr = new byte[i2];
                                jSONArray2 = optJSONArray;
                            } else {
                                int length2 = optJSONArray2.length();
                                byte[][] bArr2 = new byte[length2];
                                jSONArray2 = optJSONArray;
                                int i4 = 0;
                                while (i4 < length2) {
                                    byte[][] bArr3 = bArr2;
                                    int i5 = i4;
                                    bArr3[i5] = optJSONArray2.optString(i4).getBytes(Charsets.UTF_8);
                                    i4 = i5 + 1;
                                    bArr2 = bArr3;
                                }
                                bArr = bArr2;
                            }
                            iVar.b = bArr;
                            arrayList.add(iVar);
                            optJSONArray = jSONArray2;
                            i2 = 0;
                        }
                        jSONArray = optJSONArray;
                        iVarArr = (i[]) arrayList.toArray(new i[i2]);
                    }
                    kVar.d = iVarArr;
                    kVar.e = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject2, this.i, kVar.e);
                    kVar.f = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject2, this.j, kVar.f);
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray(this.k);
                    if (optJSONArray3 == null) {
                        iArr = new int[0];
                    } else {
                        int length3 = optJSONArray3.length();
                        int[] iArr3 = new int[length3];
                        for (int i6 = 0; i6 < length3; i6++) {
                            iArr3[i6] = optJSONArray3.optInt(i6);
                        }
                        iArr = iArr3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (int i7 : iArr) {
                        if (i7 != 0) {
                            arrayList2.add(Integer.valueOf(i7));
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        arrayList2 = null;
                    }
                    if (arrayList2 == null || (iArr2 = CollectionsKt.toIntArray(arrayList2)) == null) {
                        i = 0;
                        iArr2 = new int[]{200};
                    } else {
                        i = 0;
                    }
                    kVar.g = iArr2;
                    kVar.h = optJSONObject2.optBoolean(this.o, kVar.h);
                    kVar.i = optJSONObject2.optString(this.p);
                }
                kVarArr2[i3] = kVar;
                i3++;
                i2 = i;
                optJSONArray = jSONArray;
            }
            kVarArr = kVarArr2;
        }
        lVar.b = kVarArr;
        mVar.b = lVar;
        return this.f419a.toModel(mVar);
    }

    public final IdSyncConfig b(JSONObject jSONObject) {
        return (IdSyncConfig) JsonParser.DefaultImpls.parseOrNull(this, jSONObject);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Parser
    public final Object parseOrNull(JSONObject jSONObject) {
        return (IdSyncConfig) JsonParser.DefaultImpls.parseOrNull(this, jSONObject);
    }
}
