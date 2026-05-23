package com.skydoves.cloudy;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
/* compiled from: CloudyDefaults.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u00020\f¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/skydoves/cloudy/CloudyDefaults;", "", "<init>", "()V", "BACKGROUND_RADIUS", "", "PROGRESSIVE_FADE_END", "", "EDGES_FADE_DISTANCE", "CPP_BLUR_ENABLED", "", "DefaultScrimColor", "Landroidx/compose/ui/graphics/Color;", "getDefaultScrimColor-0d7_KjU", "()J", "J", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CloudyDefaults {
    public static final int $stable = 0;
    public static final int BACKGROUND_RADIUS = 20;
    public static final boolean CPP_BLUR_ENABLED = false;
    public static final float EDGES_FADE_DISTANCE = 0.2f;
    public static final float PROGRESSIVE_FADE_END = 0.5f;
    public static final CloudyDefaults INSTANCE = new CloudyDefaults();
    private static final long DefaultScrimColor = Color.m5347copywmQWz5c$default(Color.Companion.m5374getBlack0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null);

    private CloudyDefaults() {
    }

    /* renamed from: getDefaultScrimColor-0d7_KjU  reason: not valid java name */
    public final long m9801getDefaultScrimColor0d7_KjU() {
        return DefaultScrimColor;
    }
}
