package ru.mrlargha.feature.battlepassWinter2025;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BattlePassRouletteController.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* synthetic */ class BattlePassRouletteController$priseAdapter$1 extends FunctionReferenceImpl implements Function4<Float, Float, String, Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BattlePassRouletteController$priseAdapter$1(Object obj) {
        super(4, obj, BattlePassRouletteController.class, "showPriseName", "showPriseName(FFLjava/lang/String;I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Float f, Float f2, String str, Integer num) {
        invoke(f.floatValue(), f2.floatValue(), str, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f, float f2, String p2, int i) {
        Intrinsics.checkNotNullParameter(p2, "p2");
        ((BattlePassRouletteController) this.receiver).showPriseName(f, f2, p2, i);
    }
}
