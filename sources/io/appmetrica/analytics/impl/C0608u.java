package io.appmetrica.analytics.impl;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import org.json.JSONArray;
/* renamed from: io.appmetrica.analytics.impl.u  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0608u implements InterfaceC0658w {

    /* renamed from: a  reason: collision with root package name */
    public final String f1222a = "yandex";

    public final String a() {
        try {
            return new JSONArray((Collection) CollectionsKt.plus((Collection) CollectionsKt.listOf(this.f1222a), (Iterable) C0157c4.l().m().d)).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
