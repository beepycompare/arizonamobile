package ru.rustore.sdk.appupdate;

import android.content.Context;
import android.content.ServiceConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* renamed from: ru.rustore.sdk.appupdate.x  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0807x extends Lambda implements Function1<SingleEmitter<Unit>, ServiceConnection> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0801r f1546a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0807x(C0801r c0801r) {
        super(1);
        this.f1546a = c0801r;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(SingleEmitter<Unit> singleEmitter) {
        SingleEmitter<Unit> emitter = singleEmitter;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        Context context = this.f1546a.f1538a;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new h0(context, packageName, new C0805v(emitter), new C0806w(emitter));
    }
}
