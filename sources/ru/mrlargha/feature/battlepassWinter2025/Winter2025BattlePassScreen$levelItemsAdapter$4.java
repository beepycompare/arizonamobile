package ru.mrlargha.feature.battlepassWinter2025;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Winter2025BattlePass.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* synthetic */ class Winter2025BattlePassScreen$levelItemsAdapter$4 extends FunctionReferenceImpl implements Function2<View, String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public Winter2025BattlePassScreen$levelItemsAdapter$4(Object obj) {
        super(2, obj, Winter2025BattlePassScreen.class, "requestPremiumRewardDescription", "requestPremiumRewardDescription(Landroid/view/View;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, String str) {
        invoke2(view, str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((Winter2025BattlePassScreen) this.receiver).requestPremiumRewardDescription(p0, p1);
    }
}
