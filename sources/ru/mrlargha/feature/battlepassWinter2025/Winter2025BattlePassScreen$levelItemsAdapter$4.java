package ru.mrlargha.feature.battlepassWinter2025;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Winter2025BattlePass.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* synthetic */ class Winter2025BattlePassScreen$levelItemsAdapter$4 extends FunctionReferenceImpl implements Function3<View, Integer, Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public Winter2025BattlePassScreen$levelItemsAdapter$4(Object obj) {
        super(3, obj, Winter2025BattlePassScreen.class, "requestRewardDescription", "requestRewardDescription(Landroid/view/View;IZ)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Boolean bool) {
        invoke(view, num.intValue(), bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(View p0, int i, boolean z) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((Winter2025BattlePassScreen) this.receiver).requestRewardDescription(p0, i, z);
    }
}
