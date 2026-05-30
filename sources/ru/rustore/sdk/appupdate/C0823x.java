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
public final class C0823x extends Lambda implements Function1<SingleEmitter<Unit>, ServiceConnection> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0817r f1547a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0823x(C0817r c0817r) {
        super(1);
        this.f1547a = c0817r;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(SingleEmitter<Unit> singleEmitter) {
        SingleEmitter<Unit> emitter = singleEmitter;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        Context context = this.f1547a.f1539a;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new h0(context, packageName, new C0821v(emitter), new C0822w(emitter));
    }
}
