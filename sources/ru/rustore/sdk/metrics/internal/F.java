package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes6.dex */
public final class F extends Lambda implements Function0<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1416a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(String str) {
        super(0);
        this.f1416a = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return "Delete id's from storage " + this.f1416a;
    }
}
