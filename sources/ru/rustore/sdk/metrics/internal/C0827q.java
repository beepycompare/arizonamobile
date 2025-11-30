package ru.rustore.sdk.metrics.internal;

import java.net.URL;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
/* renamed from: ru.rustore.sdk.metrics.internal.q  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0827q extends Lambda implements Function0<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ URL f1517a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0827q(URL url, int i, String str) {
        super(0);
        this.f1517a = url;
        this.b = i;
        this.c = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return StringsKt.trimIndent("\n                    HTTP REQUEST\n                    URL: " + this.f1517a + "\n                    CODE: " + this.b + "\n                    BODY: " + this.c + "\n                ");
    }
}
