package com.google.android.material.color.utilities;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* loaded from: classes4.dex */
public class SchemeRainbow extends DynamicScheme {
    public SchemeRainbow(Hct hct, boolean z, double d) {
        super(hct, Variant.RAINBOW, z, d, TonalPalette.fromHueAndChroma(hct.getHue(), 48.0d), TonalPalette.fromHueAndChroma(hct.getHue(), 16.0d), TonalPalette.fromHueAndChroma(MathUtils.sanitizeDegreesDouble(hct.getHue() + 60.0d), 24.0d), TonalPalette.fromHueAndChroma(hct.getHue(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), TonalPalette.fromHueAndChroma(hct.getHue(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
    }
}
