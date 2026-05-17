package ru.rustore.sdk.appupdate;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
/* loaded from: classes6.dex */
public final class U extends Lambda implements Function0<C0804r> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1527a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U(Context context) {
        super(0);
        this.f1527a = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public final C0804r invoke() {
        i0 i0Var = new i0();
        return new C0804r(this.f1527a, new C0801o(new AppUpdateInfo.Factory(i0Var), i0Var));
    }
}
