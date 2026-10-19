package io.appmetrica.analytics.impl;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import org.json.JSONArray;
/* renamed from: io.appmetrica.analytics.impl.v  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0642v implements InterfaceC0694x {

    /* renamed from: a  reason: collision with root package name */
    public final String f1244a = "yandex";

    public final String a() {
        try {
            return new JSONArray((Collection) CollectionsKt.plus((Collection) CollectionsKt.listOf(this.f1244a), (Iterable) C0569s4.l().m().a())).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
