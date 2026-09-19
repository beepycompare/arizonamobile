package ru.rustore.sdk.appupdate;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.reactive.single.Single;
/* renamed from: ru.rustore.sdk.appupdate.y  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0802y extends Lambda implements Function1<Unit, Single<Unit>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0795r f1505a;
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0802y(C0795r c0795r, int i) {
        super(1);
        this.f1505a = c0795r;
        this.b = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Single<Unit> invoke(Unit unit) {
        Unit it = unit;
        Intrinsics.checkNotNullParameter(it, "it");
        C0795r c0795r = this.f1505a;
        int i = this.b;
        c0795r.getClass();
        return Single.Companion.create(new D(c0795r, i));
    }
}
