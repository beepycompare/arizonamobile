package io.appmetrica.analytics.impl;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import org.json.JSONArray;
/* renamed from: io.appmetrica.analytics.impl.t  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0595t implements InterfaceC0645v {

    /* renamed from: a  reason: collision with root package name */
    public final String f1086a = "yandex";

    public final String a() {
        try {
            return new JSONArray((Collection) CollectionsKt.plus((Collection) CollectionsKt.listOf(this.f1086a), (Iterable) A4.l().m().d)).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
