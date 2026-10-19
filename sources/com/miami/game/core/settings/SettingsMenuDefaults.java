package com.miami.game.core.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;
/* compiled from: SettingsMenuDefaults.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\bJ\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020\b072\u0006\u0010=\u001a\u00020\bJ\u0016\u0010>\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010=\u001a\u00020\bJ,\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\b072\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u0011J\u0014\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020RH\u0007b\u0002\bSJ\u0014\u0010T\u001a\u00020U2\u0006\u0010Q\u001a\u00020RH\u0007b\u0002\bSJ\u0014\u0010V\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020RH\u0007b\u0002\bSJ\u0014\u0010W\u001a\u00020X2\u0006\u0010Q\u001a\u00020RH\u0007b\u0002\bSJ\f\u0010Y\u001a\u00020\b*\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\b07¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u000e\u0010D\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/miami/game/core/settings/SettingsMenuDefaults;", "", "<init>", "()V", "PREFS_NAME", "", "KEY_CHAT_FONT_SIZE", "DEFAULT_CHAT_FONT_SIZE", "", "KEY_CHAT_COUNTS", "DEFAULT_CHAT_COUNTS", "KEY_GAME_MODE", "DEFAULT_GAME_MODE", "KEY_KEYBOARD_TYPE", "DEFAULT_KEYBOARD_TYPE", "KEY_FULL_SCREEN", "DEFAULT_FULL_SCREEN", "", "KEY_SHOW_FPS", "DEFAULT_SHOW_FPS", "KEY_VICE_CITY_ENABLED", "DEFAULT_VICE_CITY_ENABLED", "KEY_TIME_IN_CHAT", "DEFAULT_TIME_IN_CHAT", "KEY_STEERING", "DEFAULT_STEERING", "KEY_BACK_VIEW", "DEFAULT_BACK_VIEW", "KEY_VOLUME_SURROUNDING", "DEFAULT_VOLUME_SURROUNDING", "KEY_VOICE_CHAT_VOLUME", "DEFAULT_VOICE_CHAT_VOLUME", "KEY_MIC_VOLUME", "DEFAULT_MIC_VOLUME", "KEY_VEHICLE_MUSIC_VOLUME", "DEFAULT_VEHICLE_MUSIC_VOLUME", "KEY_BOOM_BOX_MUSIC_SOUND", "DEFAULT_BOOM_BOX_MUSIC_SOUND", "KEY_MIC_ENABLED", "DEFAULT_MIC_ENABLED", "KEY_AMBIENT_SOUNDS", "DEFAULT_AMBIENT_SOUNDS", "KEY_VIDEO_EFFECTS", "DEFAULT_VIDEO_EFFECTS", "KEY_VIDEO_SHADOWS", "DEFAULT_VIDEO_SHADOWS", "KEY_VIDEO_VEHICLES", "DEFAULT_VIDEO_VEHICLES", "KEY_VIDEO_VSYNC", "DEFAULT_VIDEO_VSYNC", "KEY_VIDEO_MSAA", "DEFAULT_VIDEO_MSAA", "KEY_VIDEO_ANISOTROPY", "DEFAULT_VIDEO_ANISOTROPY", "VIDEO_ANISOTROPY_LEVELS", "", "getVIDEO_ANISOTROPY_LEVELS", "()Ljava/util/List;", "normalizeVideoAnisotropy", "value", "supportedVideoAnisotropyLevels", "maxSupported", "effectiveVideoAnisotropy", "videoAnisotropyToSave", "savedValue", "levels", "selectedIndex", "changed", "KEY_VIDEO_WATER_QUALITY", "DEFAULT_VIDEO_WATER_QUALITY", "KEY_VIDEO_FAR_CLIP", "DEFAULT_VIDEO_FAR_CLIP", "KEY_VIDEO_BRIGHTNESS", "DEFAULT_VIDEO_BRIGHTNESS", "KEY_VIDEO_MAX_FPS", "DEFAULT_VIDEO_MAX_FPS", "KEY_VIDEO_RENDER_SCALE", "DEFAULT_VIDEO_RENDER_SCALE", "KEY_CPU_MODE", "DEFAULT_CPU_MODE", "maxVideoFps", "context", "Landroid/content/Context;", "Lkotlin/jvm/JvmStatic;", "prefs", "Landroid/content/SharedPreferences;", "toJson", "reset", "", "toInt", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SettingsMenuDefaults {
    public static final boolean DEFAULT_AMBIENT_SOUNDS = true;
    public static final boolean DEFAULT_BACK_VIEW = true;
    public static final int DEFAULT_BOOM_BOX_MUSIC_SOUND = 100;
    public static final int DEFAULT_CHAT_COUNTS = 2;
    public static final int DEFAULT_CHAT_FONT_SIZE = 1;
    public static final int DEFAULT_CPU_MODE = 0;
    public static final boolean DEFAULT_FULL_SCREEN = true;
    public static final int DEFAULT_GAME_MODE = 0;
    public static final int DEFAULT_KEYBOARD_TYPE = 0;
    public static final boolean DEFAULT_MIC_ENABLED = true;
    public static final int DEFAULT_MIC_VOLUME = 100;
    public static final boolean DEFAULT_SHOW_FPS = false;
    public static final int DEFAULT_STEERING = 0;
    public static final boolean DEFAULT_TIME_IN_CHAT = false;
    public static final int DEFAULT_VEHICLE_MUSIC_VOLUME = 100;
    public static final boolean DEFAULT_VICE_CITY_ENABLED = false;
    public static final int DEFAULT_VIDEO_ANISOTROPY = 2;
    public static final int DEFAULT_VIDEO_BRIGHTNESS = 60;
    public static final int DEFAULT_VIDEO_EFFECTS = 1;
    public static final int DEFAULT_VIDEO_FAR_CLIP = 40;
    public static final int DEFAULT_VIDEO_MAX_FPS = 60;
    public static final int DEFAULT_VIDEO_MSAA = 1;
    public static final int DEFAULT_VIDEO_RENDER_SCALE = 85;
    public static final int DEFAULT_VIDEO_SHADOWS = 0;
    public static final int DEFAULT_VIDEO_VEHICLES = 2;
    public static final boolean DEFAULT_VIDEO_VSYNC = false;
    public static final int DEFAULT_VIDEO_WATER_QUALITY = 0;
    public static final int DEFAULT_VOICE_CHAT_VOLUME = 100;
    public static final int DEFAULT_VOLUME_SURROUNDING = 100;
    public static final String KEY_AMBIENT_SOUNDS = "ambientSounds";
    public static final String KEY_BACK_VIEW = "backView";
    public static final String KEY_BOOM_BOX_MUSIC_SOUND = "boomBoxMusicSound";
    public static final String KEY_CHAT_COUNTS = "chatCounts";
    public static final String KEY_CHAT_FONT_SIZE = "chatFontSize";
    public static final String KEY_CPU_MODE = "cpuMode";
    public static final String KEY_FULL_SCREEN = "fullScreen";
    public static final String KEY_GAME_MODE = "gameMode";
    public static final String KEY_KEYBOARD_TYPE = "keyboardType";
    public static final String KEY_MIC_ENABLED = "micEnabled";
    public static final String KEY_MIC_VOLUME = "micVolume";
    public static final String KEY_SHOW_FPS = "showFps";
    public static final String KEY_STEERING = "steering";
    public static final String KEY_TIME_IN_CHAT = "timeInChat";
    public static final String KEY_VEHICLE_MUSIC_VOLUME = "vehicleMusicVolume";
    public static final String KEY_VICE_CITY_ENABLED = "viceCityEnabled";
    public static final String KEY_VIDEO_ANISOTROPY = "videoAnisotropy";
    public static final String KEY_VIDEO_BRIGHTNESS = "videoBrightness";
    public static final String KEY_VIDEO_EFFECTS = "videoEffects";
    public static final String KEY_VIDEO_FAR_CLIP = "videoFarClip";
    public static final String KEY_VIDEO_MAX_FPS = "videoMaxFps";
    public static final String KEY_VIDEO_MSAA = "videoMsaa";
    public static final String KEY_VIDEO_RENDER_SCALE = "videoRenderScale";
    public static final String KEY_VIDEO_SHADOWS = "videoShadows";
    public static final String KEY_VIDEO_VEHICLES = "videoVehicles";
    public static final String KEY_VIDEO_VSYNC = "videoVSync";
    public static final String KEY_VIDEO_WATER_QUALITY = "videoWaterQuality";
    public static final String KEY_VOICE_CHAT_VOLUME = "voiceChatVolume";
    public static final String KEY_VOLUME_SURROUNDING = "volumeSurrounding";
    public static final String PREFS_NAME = "settingsMenu";
    public static final SettingsMenuDefaults INSTANCE = new SettingsMenuDefaults();
    private static final List<Integer> VIDEO_ANISOTROPY_LEVELS = CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 4, 8, 16});

    private final int toInt(boolean z) {
        return z ? 1 : 0;
    }

    private SettingsMenuDefaults() {
    }

    public final List<Integer> getVIDEO_ANISOTROPY_LEVELS() {
        return VIDEO_ANISOTROPY_LEVELS;
    }

    public final int normalizeVideoAnisotropy(int i) {
        Integer valueOf = Integer.valueOf(i);
        if (!VIDEO_ANISOTROPY_LEVELS.contains(Integer.valueOf(valueOf.intValue()))) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 2;
    }

    public final List<Integer> supportedVideoAnisotropyLevels(int i) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : VIDEO_ANISOTROPY_LEVELS) {
            if (((Number) obj).intValue() <= RangesKt.coerceAtLeast(i, 1)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final int effectiveVideoAnisotropy(int i, int i2) {
        List<Integer> supportedVideoAnisotropyLevels = supportedVideoAnisotropyLevels(i2);
        ListIterator<Integer> listIterator = supportedVideoAnisotropyLevels.listIterator(supportedVideoAnisotropyLevels.size());
        while (listIterator.hasPrevious()) {
            Integer previous = listIterator.previous();
            if (previous.intValue() <= INSTANCE.normalizeVideoAnisotropy(i)) {
                return previous.intValue();
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    public final int videoAnisotropyToSave(int i, List<Integer> levels, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(levels, "levels");
        return z ? levels.get(RangesKt.coerceIn(i2, (ClosedRange<Integer>) CollectionsKt.getIndices(levels))).intValue() : normalizeVideoAnisotropy(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int maxVideoFps(Context context) {
        Display defaultDisplay;
        Display.Mode[] supportedModes;
        Float valueOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Float f = null;
        if (Build.VERSION.SDK_INT >= 30) {
            defaultDisplay = context.getDisplay();
        } else {
            Object systemService = context.getSystemService("window");
            WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
            defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        }
        if (defaultDisplay != null && (supportedModes = defaultDisplay.getSupportedModes()) != null) {
            if (supportedModes.length == 0) {
                valueOf = null;
            } else {
                float refreshRate = supportedModes[0].getRefreshRate();
                int lastIndex = ArraysKt.getLastIndex(supportedModes);
                int i = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        refreshRate = Math.max(refreshRate, supportedModes[i].getRefreshRate());
                        if (i == lastIndex) {
                            break;
                        }
                        i++;
                    }
                }
                valueOf = Float.valueOf(refreshRate);
            }
            if (valueOf != null) {
                f = valueOf;
                if (f == null) {
                    return RangesKt.coerceAtLeast(MathKt.roundToInt(f.floatValue()), 60);
                }
                return 60;
            }
        }
        if (defaultDisplay != null) {
            f = Float.valueOf(defaultDisplay.getRefreshRate());
        }
        if (f == null) {
        }
    }

    @JvmStatic
    public static final SharedPreferences prefs(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    @JvmStatic
    public static final String toJson(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences prefs = prefs(context);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_CHAT_FONT_SIZE, prefs.getInt(KEY_CHAT_FONT_SIZE, 1));
        jSONObject.put(KEY_CHAT_COUNTS, prefs.getInt(KEY_CHAT_COUNTS, 2));
        jSONObject.put(KEY_GAME_MODE, prefs.getInt(KEY_GAME_MODE, 0));
        jSONObject.put(KEY_KEYBOARD_TYPE, prefs.getInt(KEY_KEYBOARD_TYPE, 0));
        SettingsMenuDefaults settingsMenuDefaults = INSTANCE;
        jSONObject.put(KEY_FULL_SCREEN, settingsMenuDefaults.toInt(prefs.getBoolean(KEY_FULL_SCREEN, true)));
        jSONObject.put(KEY_SHOW_FPS, settingsMenuDefaults.toInt(prefs.getBoolean(KEY_SHOW_FPS, false)));
        jSONObject.put(KEY_TIME_IN_CHAT, settingsMenuDefaults.toInt(prefs.getBoolean(KEY_TIME_IN_CHAT, false)));
        jSONObject.put(KEY_STEERING, prefs.getInt(KEY_STEERING, 0));
        jSONObject.put(KEY_BACK_VIEW, settingsMenuDefaults.toInt(prefs.getBoolean(KEY_BACK_VIEW, true)));
        jSONObject.put(KEY_VOLUME_SURROUNDING, prefs.getInt(KEY_VOLUME_SURROUNDING, 100));
        jSONObject.put(KEY_VOICE_CHAT_VOLUME, prefs.getInt(KEY_VOICE_CHAT_VOLUME, 100));
        jSONObject.put(KEY_MIC_VOLUME, prefs.getInt(KEY_MIC_VOLUME, 100));
        jSONObject.put(KEY_VEHICLE_MUSIC_VOLUME, prefs.getInt(KEY_VEHICLE_MUSIC_VOLUME, 100));
        jSONObject.put(KEY_BOOM_BOX_MUSIC_SOUND, prefs.getInt(KEY_BOOM_BOX_MUSIC_SOUND, 100));
        jSONObject.put(KEY_MIC_ENABLED, settingsMenuDefaults.toInt(prefs.getBoolean(KEY_MIC_ENABLED, true)));
        jSONObject.put(KEY_AMBIENT_SOUNDS, settingsMenuDefaults.toInt(prefs.getBoolean(KEY_AMBIENT_SOUNDS, true)));
        jSONObject.put(KEY_VIDEO_EFFECTS, prefs.getInt(KEY_VIDEO_EFFECTS, 1));
        jSONObject.put(KEY_VIDEO_SHADOWS, prefs.getInt(KEY_VIDEO_SHADOWS, 0));
        jSONObject.put(KEY_VIDEO_VEHICLES, prefs.getInt(KEY_VIDEO_VEHICLES, 2));
        jSONObject.put(KEY_VIDEO_VSYNC, settingsMenuDefaults.toInt(prefs.getBoolean(KEY_VIDEO_VSYNC, false)));
        jSONObject.put(KEY_VIDEO_MSAA, prefs.getInt(KEY_VIDEO_MSAA, 1));
        jSONObject.put(KEY_VIDEO_ANISOTROPY, settingsMenuDefaults.normalizeVideoAnisotropy(prefs.getInt(KEY_VIDEO_ANISOTROPY, 2)));
        jSONObject.put(KEY_VIDEO_WATER_QUALITY, prefs.getInt(KEY_VIDEO_WATER_QUALITY, 0));
        jSONObject.put(KEY_VIDEO_FAR_CLIP, prefs.getInt(KEY_VIDEO_FAR_CLIP, 40));
        jSONObject.put(KEY_VIDEO_BRIGHTNESS, RangesKt.coerceIn(prefs.getInt(KEY_VIDEO_BRIGHTNESS, 60), 25, 100));
        jSONObject.put(KEY_VIDEO_MAX_FPS, prefs.getInt(KEY_VIDEO_MAX_FPS, 60));
        jSONObject.put(KEY_VIDEO_RENDER_SCALE, prefs.getInt(KEY_VIDEO_RENDER_SCALE, 85));
        jSONObject.put(KEY_CPU_MODE, prefs.getInt(KEY_CPU_MODE, 0));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        return jSONObject2;
    }

    @JvmStatic
    public static final void reset(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        prefs(context).edit().putInt(KEY_CHAT_FONT_SIZE, 1).putInt(KEY_CHAT_COUNTS, 2).putInt(KEY_GAME_MODE, 0).putInt(KEY_KEYBOARD_TYPE, 0).putBoolean(KEY_FULL_SCREEN, true).putBoolean(KEY_SHOW_FPS, false).putBoolean(KEY_TIME_IN_CHAT, false).putInt(KEY_STEERING, 0).putBoolean(KEY_BACK_VIEW, true).putInt(KEY_VOLUME_SURROUNDING, 100).putInt(KEY_VOICE_CHAT_VOLUME, 100).putInt(KEY_MIC_VOLUME, 100).putInt(KEY_VEHICLE_MUSIC_VOLUME, 100).putInt(KEY_BOOM_BOX_MUSIC_SOUND, 100).putBoolean(KEY_MIC_ENABLED, true).putBoolean(KEY_AMBIENT_SOUNDS, true).putInt(KEY_VIDEO_EFFECTS, 1).putInt(KEY_VIDEO_SHADOWS, 0).putInt(KEY_VIDEO_VEHICLES, 2).putBoolean(KEY_VIDEO_VSYNC, false).putInt(KEY_VIDEO_MSAA, 1).putInt(KEY_VIDEO_ANISOTROPY, 2).putInt(KEY_VIDEO_WATER_QUALITY, 0).putInt(KEY_VIDEO_FAR_CLIP, 40).putInt(KEY_VIDEO_BRIGHTNESS, 60).putInt(KEY_VIDEO_MAX_FPS, 60).putInt(KEY_VIDEO_RENDER_SCALE, 85).putInt(KEY_CPU_MODE, 0).apply();
    }
}
