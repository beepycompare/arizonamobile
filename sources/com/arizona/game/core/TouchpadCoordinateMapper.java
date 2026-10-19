package com.arizona.game.core;
/* loaded from: classes3.dex */
final class TouchpadCoordinateMapper {
    static final float TOP_DEAD_ZONE = 0.15f;

    private TouchpadCoordinateMapper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float x(float f, float f2) {
        return clamp(f / f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float y(float f, float f2) {
        return clamp(((f / f2) - TOP_DEAD_ZONE) / 0.85f);
    }

    private static float clamp(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }
}
