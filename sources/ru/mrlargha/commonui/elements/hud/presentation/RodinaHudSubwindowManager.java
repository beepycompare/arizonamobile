package ru.mrlargha.commonui.elements.hud.presentation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RodinaHudSubwindowManager.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001b\b\u0000\u0018\u00002\u00020\u0001Bk\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0005J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\b\u0010!\u001a\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020\u0005H\u0002J\b\u0010#\u001a\u00020\u0004H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/RodinaHudSubwindowManager;", "", "setWorkTimerVisible", "Lkotlin/Function1;", "", "", "setWorkCounterVisible", "setCaseTimerVisible", "setRouletteInfo", "", "setRouletteVisible", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "hudBannerVisible", "battlePassRewardsBannerVisible", "workTimerRequestedVisible", "workCounterRequestedVisible", "caseTimerRequestedVisible", "rouletteRequestedVisible", "rouletteInfoType", "setHudBannerVisible", "visible", "setBattlePassRewardsBannerVisible", "setWorkTimerRequestedVisible", "setWorkCounterRequestedVisible", "setCaseTimerRequestedVisible", "setRouletteInfoType", "type", "showRoulette", "hideRoulette", "applyBlockedSubwindows", "applyWorkTimer", "applyWorkCounter", "applyCaseTimer", "applyRoulette", "hasBlockingBanner", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RodinaHudSubwindowManager {
    private boolean battlePassRewardsBannerVisible;
    private boolean caseTimerRequestedVisible;
    private boolean hudBannerVisible;
    private int rouletteInfoType;
    private boolean rouletteRequestedVisible;
    private final Function1<Boolean, Unit> setCaseTimerVisible;
    private final Function1<Integer, Unit> setRouletteInfo;
    private final Function1<Boolean, Unit> setRouletteVisible;
    private final Function1<Boolean, Unit> setWorkCounterVisible;
    private final Function1<Boolean, Unit> setWorkTimerVisible;
    private boolean workCounterRequestedVisible;
    private boolean workTimerRequestedVisible;

    /* JADX WARN: Multi-variable type inference failed */
    public RodinaHudSubwindowManager(Function1<? super Boolean, Unit> setWorkTimerVisible, Function1<? super Boolean, Unit> setWorkCounterVisible, Function1<? super Boolean, Unit> setCaseTimerVisible, Function1<? super Integer, Unit> setRouletteInfo, Function1<? super Boolean, Unit> setRouletteVisible) {
        Intrinsics.checkNotNullParameter(setWorkTimerVisible, "setWorkTimerVisible");
        Intrinsics.checkNotNullParameter(setWorkCounterVisible, "setWorkCounterVisible");
        Intrinsics.checkNotNullParameter(setCaseTimerVisible, "setCaseTimerVisible");
        Intrinsics.checkNotNullParameter(setRouletteInfo, "setRouletteInfo");
        Intrinsics.checkNotNullParameter(setRouletteVisible, "setRouletteVisible");
        this.setWorkTimerVisible = setWorkTimerVisible;
        this.setWorkCounterVisible = setWorkCounterVisible;
        this.setCaseTimerVisible = setCaseTimerVisible;
        this.setRouletteInfo = setRouletteInfo;
        this.setRouletteVisible = setRouletteVisible;
    }

    public final void setHudBannerVisible(boolean z) {
        this.hudBannerVisible = z;
        applyBlockedSubwindows();
    }

    public final void setBattlePassRewardsBannerVisible(boolean z) {
        this.battlePassRewardsBannerVisible = z;
        applyBlockedSubwindows();
    }

    public final void setWorkTimerRequestedVisible(boolean z) {
        this.workTimerRequestedVisible = z;
        applyWorkTimer();
    }

    public final void setWorkCounterRequestedVisible(boolean z) {
        this.workCounterRequestedVisible = z;
        applyWorkCounter();
    }

    public final void setCaseTimerRequestedVisible(boolean z) {
        this.caseTimerRequestedVisible = z;
        applyCaseTimer();
        applyRoulette();
    }

    public final void setRouletteInfoType(int i) {
        this.rouletteInfoType = i;
        this.rouletteRequestedVisible = i != 0;
        applyRoulette();
    }

    public final void showRoulette() {
        this.rouletteRequestedVisible = true;
        applyRoulette();
    }

    public final void hideRoulette() {
        this.rouletteRequestedVisible = false;
        applyRoulette();
    }

    private final void applyBlockedSubwindows() {
        applyWorkTimer();
        applyWorkCounter();
        applyCaseTimer();
        applyRoulette();
    }

    private final void applyWorkTimer() {
        this.setWorkTimerVisible.invoke(Boolean.valueOf(this.workTimerRequestedVisible && !hasBlockingBanner()));
    }

    private final void applyWorkCounter() {
        this.setWorkCounterVisible.invoke(Boolean.valueOf(this.workCounterRequestedVisible && !hasBlockingBanner()));
    }

    private final void applyCaseTimer() {
        this.setCaseTimerVisible.invoke(Boolean.valueOf(this.caseTimerRequestedVisible && !hasBlockingBanner()));
    }

    private final void applyRoulette() {
        boolean z = true;
        boolean z2 = hasBlockingBanner() || this.caseTimerRequestedVisible;
        if (!this.rouletteRequestedVisible || z2) {
            z = false;
        }
        int i = this.rouletteInfoType;
        if (i == 0) {
            this.setRouletteVisible.invoke(Boolean.valueOf(z));
        } else {
            this.setRouletteInfo.invoke(Integer.valueOf(z ? i : 0));
        }
    }

    private final boolean hasBlockingBanner() {
        return this.hudBannerVisible || this.battlePassRewardsBannerVisible;
    }
}
