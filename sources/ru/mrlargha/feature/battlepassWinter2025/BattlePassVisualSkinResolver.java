package ru.mrlargha.feature.battlepassWinter2025;

import kotlin.Metadata;
/* compiled from: BattlePassVisualSkin.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/BattlePassVisualSkinResolver;", "", "<init>", "()V", "resolve", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassVisualSkin;", "isArizona", "", "isBrazil", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BattlePassVisualSkinResolver {
    public static final BattlePassVisualSkinResolver INSTANCE = new BattlePassVisualSkinResolver();

    private BattlePassVisualSkinResolver() {
    }

    public final BattlePassVisualSkin resolve(boolean z, boolean z2) {
        if (!z && !z2) {
            return BattlePassVisualSkin.PINK_CODEX;
        }
        return BattlePassVisualSkin.PURPLE_WAVES;
    }
}
