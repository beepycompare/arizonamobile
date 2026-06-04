package ru.mrlargha.commonui.elements.hud.presentation.hud_screens;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NativeProvider.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/NativeProvider;", "", "hudListener", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudListener;", "<init>", "(Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudListener;)V", "setNativeHudTimer2", "", "data", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/NativeHudTimer;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NativeProvider {
    private final HudListener hudListener;

    public NativeProvider(HudListener hudListener) {
        Intrinsics.checkNotNullParameter(hudListener, "hudListener");
        this.hudListener = hudListener;
    }

    public final void setNativeHudTimer2(NativeHudTimer nativeHudTimer) {
        int i;
        if (nativeHudTimer == null) {
            this.hudListener.hudSetTimer2(0, 0, 0);
            return;
        }
        String icon = nativeHudTimer.getIcon();
        switch (icon.hashCode()) {
            case -1062813327:
                if (icon.equals("muscle")) {
                    i = 1;
                    this.hudListener.hudSetTimer2(nativeHudTimer.getCurrentTime(), nativeHudTimer.getMaxTime(), i);
                    return;
                }
                this.hudListener.hudSetTimer2(0, 0, 0);
                return;
            case -903340183:
                if (icon.equals("shield")) {
                    i = 9;
                    this.hudListener.hudSetTimer2(nativeHudTimer.getCurrentTime(), nativeHudTimer.getMaxTime(), i);
                    return;
                }
                this.hudListener.hudSetTimer2(0, 0, 0);
                return;
            case 97038:
                if (icon.equals("axe")) {
                    i = 8;
                    this.hudListener.hudSetTimer2(nativeHudTimer.getCurrentTime(), nativeHudTimer.getMaxTime(), i);
                    return;
                }
                this.hudListener.hudSetTimer2(0, 0, 0);
                return;
            case 97920:
                if (icon.equals("bus")) {
                    i = 7;
                    this.hudListener.hudSetTimer2(nativeHudTimer.getCurrentTime(), nativeHudTimer.getMaxTime(), i);
                    return;
                }
                this.hudListener.hudSetTimer2(0, 0, 0);
                return;
            case 3143256:
                if (icon.equals("fish")) {
                    i = 13;
                    this.hudListener.hudSetTimer2(nativeHudTimer.getCurrentTime(), nativeHudTimer.getMaxTime(), i);
                    return;
                }
                this.hudListener.hudSetTimer2(0, 0, 0);
                return;
            case 3452170:
                if (icon.equals("pubg")) {
                    i = 3;
                    this.hudListener.hudSetTimer2(nativeHudTimer.getCurrentTime(), nativeHudTimer.getMaxTime(), i);
                    return;
                }
                this.hudListener.hudSetTimer2(0, 0, 0);
                return;
            case 92975308:
                if (icon.equals("anvil")) {
                    i = 2;
                    this.hudListener.hudSetTimer2(nativeHudTimer.getCurrentTime(), nativeHudTimer.getMaxTime(), i);
                    return;
                }
                this.hudListener.hudSetTimer2(0, 0, 0);
                return;
            case 104079552:
                if (icon.equals("money")) {
                    i = 6;
                    this.hudListener.hudSetTimer2(nativeHudTimer.getCurrentTime(), nativeHudTimer.getMaxTime(), i);
                    return;
                }
                this.hudListener.hudSetTimer2(0, 0, 0);
                return;
            case 106680966:
                if (icon.equals("pixel")) {
                    i = 10;
                    this.hudListener.hudSetTimer2(nativeHudTimer.getCurrentTime(), nativeHudTimer.getMaxTime(), i);
                    return;
                }
                this.hudListener.hudSetTimer2(0, 0, 0);
                return;
            case 109556488:
                if (icon.equals("smile")) {
                    i = 4;
                    this.hudListener.hudSetTimer2(nativeHudTimer.getCurrentTime(), nativeHudTimer.getMaxTime(), i);
                    return;
                }
                this.hudListener.hudSetTimer2(0, 0, 0);
                return;
            case 110640223:
                if (icon.equals("truck")) {
                    i = 5;
                    this.hudListener.hudSetTimer2(nativeHudTimer.getCurrentTime(), nativeHudTimer.getMaxTime(), i);
                    return;
                }
                this.hudListener.hudSetTimer2(0, 0, 0);
                return;
            case 274187994:
                if (icon.equals("road-repair")) {
                    i = 12;
                    this.hudListener.hudSetTimer2(nativeHudTimer.getCurrentTime(), nativeHudTimer.getMaxTime(), i);
                    return;
                }
                this.hudListener.hudSetTimer2(0, 0, 0);
                return;
            case 1550584101:
                if (icon.equals("deliver")) {
                    i = 11;
                    this.hudListener.hudSetTimer2(nativeHudTimer.getCurrentTime(), nativeHudTimer.getMaxTime(), i);
                    return;
                }
                this.hudListener.hudSetTimer2(0, 0, 0);
                return;
            default:
                this.hudListener.hudSetTimer2(0, 0, 0);
                return;
        }
    }
}
