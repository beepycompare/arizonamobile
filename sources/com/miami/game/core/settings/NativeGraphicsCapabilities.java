package com.miami.game.core.settings;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;
/* compiled from: NativeGraphicsCapabilities.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0082 J\u0006\u0010\u0006\u001a\u00020\u0005Ê\u0001\u0002\b\b¨\u0006\u0007"}, d2 = {"Lcom/miami/game/core/settings/NativeGraphicsCapabilities;", "", "<init>", "()V", "nativeMaxTextureAnisotropy", "", "maxTextureAnisotropy", "settings", "Landroidx/annotation/Keep;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NativeGraphicsCapabilities {
    public static final NativeGraphicsCapabilities INSTANCE = new NativeGraphicsCapabilities();

    private final native int nativeMaxTextureAnisotropy();

    private NativeGraphicsCapabilities() {
    }

    public final int maxTextureAnisotropy() {
        try {
            return RangesKt.coerceAtLeast(nativeMaxTextureAnisotropy(), 0);
        } catch (UnsatisfiedLinkError unused) {
            return 0;
        }
    }
}
