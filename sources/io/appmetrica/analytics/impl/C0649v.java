package io.appmetrica.analytics.impl;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import org.json.JSONArray;
/* renamed from: io.appmetrica.analytics.impl.v  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0649v implements InterfaceC0701x {

    /* renamed from: a  reason: collision with root package name */
    public final String f1239a = "yandex";

    public final String a() {
        try {
            return new JSONArray((Collection) CollectionsKt.plus((Collection) CollectionsKt.listOf(this.f1239a), (Iterable) C0576s4.l().m().a())).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
