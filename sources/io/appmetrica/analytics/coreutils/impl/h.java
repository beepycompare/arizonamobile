package io.appmetrica.analytics.coreutils.impl;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes3.dex */
public final class h extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f376a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, Intent intent, int i) {
        super(0);
        this.f376a = context;
        this.b = intent;
        this.c = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.f376a.getPackageManager().resolveActivity(this.b, this.c);
    }
}
