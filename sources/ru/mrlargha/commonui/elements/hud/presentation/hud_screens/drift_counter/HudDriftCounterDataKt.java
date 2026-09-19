package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.Strictness;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.StringReader;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
/* compiled from: HudDriftCounterData.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u001b\u0010\u0010\u001a\u0004\u0018\u00010\n*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u0004\u0018\u00010\r*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0014\u001a\u001b\u0010\u0015\u001a\u0004\u0018\u00010\r*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0014\u001a\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0018\u001a\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u0003*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002\"\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"parseHudDriftPointsPayload", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftPointsData;", "payload", "", "previous", "parseHudDriftMoneyPayload", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/ParsedHudDriftMoney;", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftMoneyData;", "formatHudDriftPoints", HudDriftCounterDataKt.KEY_POINTS, "", "formatHudDriftElapsedTime", "totalSeconds", "", "parseJsonObjectOrNull", "Lcom/google/gson/JsonObject;", "strictNonNegativeLong", "name", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Long;", "strictNonNegativeInt", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "strictPositiveInt", "strictBoolean", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "strictIntegerString", "jsonElementAdapter", "Lcom/google/gson/TypeAdapter;", "Lcom/google/gson/JsonElement;", "INTEGER_PATTERN", "Lkotlin/text/Regex;", "KEY_POINTS", "KEY_POINTS_SUM", "KEY_POINT_MULTIPLIER", "KEY_MONEY", "KEY_MONEY_MULTIPLIER", "KEY_TIMER", "KEY_SPEED_LIMIT", "DEFAULT_POINTS", "DEFAULT_POINT_MULTIPLIER", "DEFAULT_MONEY", "DEFAULT_MONEY_MULTIPLIER", "DEFAULT_TIMER", "DEFAULT_SPEED_LIMIT", "SECONDS_PER_MINUTE", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudDriftCounterDataKt {
    private static final long DEFAULT_MONEY = 0;
    private static final int DEFAULT_MONEY_MULTIPLIER = 1;
    private static final long DEFAULT_POINTS = 0;
    private static final int DEFAULT_POINT_MULTIPLIER = 1;
    private static final boolean DEFAULT_SPEED_LIMIT = false;
    private static final int DEFAULT_TIMER = 0;
    private static final Regex INTEGER_PATTERN;
    private static final String KEY_MONEY = "money";
    private static final String KEY_MONEY_MULTIPLIER = "money_multiplier";
    private static final String KEY_POINTS = "points";
    private static final String KEY_POINTS_SUM = "points_sum";
    private static final String KEY_POINT_MULTIPLIER = "point_multiplier";
    private static final String KEY_SPEED_LIMIT = "speed_limit";
    private static final String KEY_TIMER = "timer";
    private static final int SECONDS_PER_MINUTE = 60;
    private static final TypeAdapter<JsonElement> jsonElementAdapter;

    public static /* synthetic */ HudDriftPointsData parseHudDriftPointsPayload$default(String str, HudDriftPointsData hudDriftPointsData, int i, Object obj) {
        if ((i & 2) != 0) {
            hudDriftPointsData = null;
        }
        return parseHudDriftPointsPayload(str, hudDriftPointsData);
    }

    public static final HudDriftPointsData parseHudDriftPointsPayload(String payload, HudDriftPointsData hudDriftPointsData) {
        long points;
        Long pointsSum;
        int pointMultiplier;
        Intrinsics.checkNotNullParameter(payload, "payload");
        JsonObject parseJsonObjectOrNull = parseJsonObjectOrNull(payload);
        if (parseJsonObjectOrNull == null) {
            return null;
        }
        boolean has = parseJsonObjectOrNull.has(KEY_POINTS);
        boolean has2 = parseJsonObjectOrNull.has(KEY_POINTS_SUM);
        boolean has3 = parseJsonObjectOrNull.has(KEY_POINT_MULTIPLIER);
        if (has || has2 || has3) {
            if (has) {
                Long strictNonNegativeLong = strictNonNegativeLong(parseJsonObjectOrNull, KEY_POINTS);
                if (strictNonNegativeLong == null) {
                    return null;
                }
                points = strictNonNegativeLong.longValue();
            } else {
                points = hudDriftPointsData != null ? hudDriftPointsData.getPoints() : 0L;
            }
            if (has2) {
                Long strictNonNegativeLong2 = strictNonNegativeLong(parseJsonObjectOrNull, KEY_POINTS_SUM);
                if (strictNonNegativeLong2 == null) {
                    return null;
                }
                pointsSum = Long.valueOf(strictNonNegativeLong2.longValue());
            } else {
                pointsSum = hudDriftPointsData != null ? hudDriftPointsData.getPointsSum() : null;
            }
            if (has3) {
                Integer strictPositiveInt = strictPositiveInt(parseJsonObjectOrNull, KEY_POINT_MULTIPLIER);
                if (strictPositiveInt == null) {
                    return null;
                }
                pointMultiplier = strictPositiveInt.intValue();
            } else {
                pointMultiplier = hudDriftPointsData != null ? hudDriftPointsData.getPointMultiplier() : 1;
            }
            return new HudDriftPointsData(points, pointMultiplier, pointsSum);
        }
        return null;
    }

    public static /* synthetic */ ParsedHudDriftMoney parseHudDriftMoneyPayload$default(String str, HudDriftMoneyData hudDriftMoneyData, int i, Object obj) {
        if ((i & 2) != 0) {
            hudDriftMoneyData = null;
        }
        return parseHudDriftMoneyPayload(str, hudDriftMoneyData);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ParsedHudDriftMoney parseHudDriftMoneyPayload(String payload, HudDriftMoneyData hudDriftMoneyData) {
        long money;
        int moneyMultiplier;
        int i;
        int timer;
        Intrinsics.checkNotNullParameter(payload, "payload");
        JsonObject parseJsonObjectOrNull = parseJsonObjectOrNull(payload);
        if (parseJsonObjectOrNull == null) {
            return null;
        }
        boolean has = parseJsonObjectOrNull.has(KEY_MONEY);
        boolean has2 = parseJsonObjectOrNull.has(KEY_MONEY_MULTIPLIER);
        boolean has3 = parseJsonObjectOrNull.has(KEY_TIMER);
        boolean has4 = parseJsonObjectOrNull.has(KEY_SPEED_LIMIT);
        if (has || has2 || has3 || has4) {
            if (has) {
                Long strictNonNegativeLong = strictNonNegativeLong(parseJsonObjectOrNull, KEY_MONEY);
                if (strictNonNegativeLong == null) {
                    return null;
                }
                money = strictNonNegativeLong.longValue();
            } else {
                money = hudDriftMoneyData != null ? hudDriftMoneyData.getMoney() : 0L;
            }
            long j = money;
            if (has2) {
                Integer strictPositiveInt = strictPositiveInt(parseJsonObjectOrNull, KEY_MONEY_MULTIPLIER);
                if (strictPositiveInt == null) {
                    return null;
                }
                moneyMultiplier = strictPositiveInt.intValue();
            } else {
                moneyMultiplier = hudDriftMoneyData != null ? hudDriftMoneyData.getMoneyMultiplier() : 1;
            }
            int i2 = moneyMultiplier;
            boolean z = false;
            if (has3) {
                Integer strictNonNegativeInt = strictNonNegativeInt(parseJsonObjectOrNull, KEY_TIMER);
                if (strictNonNegativeInt == null) {
                    return null;
                }
                timer = strictNonNegativeInt.intValue();
            } else if (hudDriftMoneyData != null) {
                timer = hudDriftMoneyData.getTimer();
            } else {
                i = 0;
                if (!has4) {
                    Boolean strictBoolean = strictBoolean(parseJsonObjectOrNull, KEY_SPEED_LIMIT);
                    if (strictBoolean == null) {
                        return null;
                    }
                    z = strictBoolean.booleanValue();
                } else if (hudDriftMoneyData != null) {
                    z = hudDriftMoneyData.getSpeedLimit();
                }
                return new ParsedHudDriftMoney(new HudDriftMoneyData(j, i2, i, z), has3);
            }
            i = timer;
            if (!has4) {
            }
            return new ParsedHudDriftMoney(new HudDriftMoneyData(j, i2, i, z), has3);
        }
        return null;
    }

    public static final String formatHudDriftPoints(long j) {
        String format = NumberFormat.getIntegerInstance(Locale.ENGLISH).format(RangesKt.coerceAtLeast(j, 0L));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final String formatHudDriftElapsedTime(int i) {
        int coerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.ROOT, "%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(coerceAtLeast / 60), Integer.valueOf(coerceAtLeast % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private static final JsonObject parseJsonObjectOrNull(String str) {
        Object m9921constructorimpl;
        JsonObject asJsonObject;
        if (StringsKt.isBlank(str)) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            JsonReader jsonReader2 = jsonReader;
            jsonReader2.setStrictness(Strictness.STRICT);
            JsonElement read = jsonElementAdapter.read(jsonReader2);
            if (jsonReader2.peek() != JsonToken.END_DOCUMENT) {
                CloseableKt.closeFinally(jsonReader, null);
                asJsonObject = null;
            } else {
                if (!read.isJsonObject()) {
                    read = null;
                }
                asJsonObject = read != null ? read.getAsJsonObject() : null;
                CloseableKt.closeFinally(jsonReader, null);
            }
            m9921constructorimpl = Result.m9921constructorimpl(asJsonObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9921constructorimpl = Result.m9921constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m9927isFailureimpl(m9921constructorimpl) ? null : m9921constructorimpl;
    }

    private static final Long strictNonNegativeLong(JsonObject jsonObject, String str) {
        Long longOrNull;
        String strictIntegerString = strictIntegerString(jsonObject, str);
        if (strictIntegerString == null || (longOrNull = StringsKt.toLongOrNull(strictIntegerString)) == null || longOrNull.longValue() < 0) {
            return null;
        }
        return longOrNull;
    }

    private static final Integer strictNonNegativeInt(JsonObject jsonObject, String str) {
        Integer intOrNull;
        String strictIntegerString = strictIntegerString(jsonObject, str);
        if (strictIntegerString == null || (intOrNull = StringsKt.toIntOrNull(strictIntegerString)) == null || intOrNull.intValue() < 0) {
            return null;
        }
        return intOrNull;
    }

    private static final Integer strictPositiveInt(JsonObject jsonObject, String str) {
        Integer intOrNull;
        String strictIntegerString = strictIntegerString(jsonObject, str);
        if (strictIntegerString == null || (intOrNull = StringsKt.toIntOrNull(strictIntegerString)) == null || intOrNull.intValue() < 1) {
            return null;
        }
        return intOrNull;
    }

    private static final Boolean strictBoolean(JsonObject jsonObject, String str) {
        JsonElement jsonElement;
        if (jsonObject.has(str) && (jsonElement = jsonObject.get(str)) != null && jsonElement.isJsonPrimitive()) {
            JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (asJsonPrimitive.isBoolean()) {
                return Boolean.valueOf(asJsonPrimitive.getAsBoolean());
            }
            return null;
        }
        return null;
    }

    private static final String strictIntegerString(JsonObject jsonObject, String str) {
        JsonElement jsonElement;
        if (jsonObject.has(str) && (jsonElement = jsonObject.get(str)) != null && jsonElement.isJsonPrimitive()) {
            JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (asJsonPrimitive.isNumber()) {
                String asString = asJsonPrimitive.getAsString();
                Regex regex = INTEGER_PATTERN;
                Intrinsics.checkNotNull(asString);
                if (regex.matches(asString)) {
                    return asString;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    static {
        TypeAdapter<JsonElement> adapter = new Gson().getAdapter(JsonElement.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "getAdapter(...)");
        jsonElementAdapter = adapter;
        INTEGER_PATTERN = new Regex("^-?\\d+$");
    }
}
