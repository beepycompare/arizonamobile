package ru.mrlargha.feature.battlepassWinter2025;

import android.content.Context;
import android.view.LayoutInflater;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BattlePassUi.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/BattlePassUiFactory;", "", "<init>", "()V", "create", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassUi;", "inflater", "Landroid/view/LayoutInflater;", "context", "Landroid/content/Context;", "visualSkin", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassVisualSkin;", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BattlePassUiFactory {
    public static final BattlePassUiFactory INSTANCE = new BattlePassUiFactory();

    /* compiled from: BattlePassUi.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BattlePassVisualSkin.values().length];
            try {
                iArr[BattlePassVisualSkin.PURPLE_WAVES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BattlePassVisualSkin.PINK_CODEX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private BattlePassUiFactory() {
    }

    public final BattlePassUi create(LayoutInflater inflater, Context context, BattlePassVisualSkin visualSkin) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(visualSkin, "visualSkin");
        int i = WhenMappings.$EnumSwitchMapping$0[visualSkin.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return new PinkCodexBattlePassUi(inflater, context);
        }
        return new PurpleWavesBattlePassUi(inflater, context);
    }
}
