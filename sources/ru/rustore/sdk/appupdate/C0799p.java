package ru.rustore.sdk.appupdate;

import android.content.ServiceConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.core.util.ContextExtKt;
/* renamed from: ru.rustore.sdk.appupdate.p  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0799p extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0801r f1550a;
    public final /* synthetic */ ServiceConnection b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0799p(C0801r c0801r, ServiceConnection serviceConnection) {
        super(0);
        this.f1550a = c0801r;
        this.b = serviceConnection;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        ContextExtKt.unbindServiceSafely(this.f1550a.f1552a, this.b);
        return Unit.INSTANCE;
    }
}
