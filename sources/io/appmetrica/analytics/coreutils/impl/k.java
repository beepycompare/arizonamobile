package io.appmetrica.analytics.coreutils.impl;

import android.content.ComponentName;
import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class k extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f263a;
    public final /* synthetic */ ComponentName b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context, ComponentName componentName, int i, int i2) {
        super(0);
        this.f263a = context;
        this.b = componentName;
        this.c = i;
        this.d = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f263a.getPackageManager().setComponentEnabledSetting(this.b, this.c, this.d);
        return Unit.INSTANCE;
    }
}
