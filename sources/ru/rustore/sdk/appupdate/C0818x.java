package ru.rustore.sdk.appupdate;

import android.content.Context;
import android.content.ServiceConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* renamed from: ru.rustore.sdk.appupdate.x  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0818x extends Lambda implements Function1<SingleEmitter<Unit>, ServiceConnection> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0812r f1398a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0818x(C0812r c0812r) {
        super(1);
        this.f1398a = c0812r;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(SingleEmitter<Unit> singleEmitter) {
        SingleEmitter<Unit> emitter = singleEmitter;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        Context context = this.f1398a.f1390a;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new h0(context, packageName, new C0816v(emitter), new C0817w(emitter));
    }
}
