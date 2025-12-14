package ru.rustore.sdk.appupdate;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
/* loaded from: classes6.dex */
public final class U extends Lambda implements Function0<C0801r> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1513a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U(Context context) {
        super(0);
        this.f1513a = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public final C0801r invoke() {
        i0 i0Var = new i0();
        return new C0801r(this.f1513a, new C0798o(new AppUpdateInfo.Factory(i0Var), i0Var));
    }
}
