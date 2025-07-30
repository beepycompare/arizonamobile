package io.appmetrica.analytics.impl;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import org.json.JSONArray;
/* renamed from: io.appmetrica.analytics.impl.t  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0593t implements InterfaceC0643v {

    /* renamed from: a  reason: collision with root package name */
    public final String f1059a = "yandex";

    public final String a() {
        try {
            return new JSONArray((Collection) CollectionsKt.plus((Collection) CollectionsKt.listOf(this.f1059a), (Iterable) C0698x4.l().m().d)).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
