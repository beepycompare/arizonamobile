package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: HudDriftCounterData.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\u0000\u001a\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0000\"\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"toInitialStateOrNull", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftCounterState;", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftCounterData;", "merge", "update", "parseHudDriftCounterPayload", "payload", "", "formatHudDriftPoints", "points", "", "formatHudDriftElapsedTime", "totalSeconds", "", "MIN_COUNTDOWN_SECONDS", "MAX_COUNTDOWN_SECONDS", "SECONDS_PER_MINUTE", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudDriftCounterDataKt {
    private static final int MAX_COUNTDOWN_SECONDS = 10;
    private static final int MIN_COUNTDOWN_SECONDS = 1;
    private static final int SECONDS_PER_MINUTE = 60;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final HudDriftCounterState toInitialStateOrNull(HudDriftCounterData hudDriftCounterData) {
        int i;
        Long points;
        Intrinsics.checkNotNullParameter(hudDriftCounterData, "<this>");
        Integer countdownSeconds = hudDriftCounterData.getCountdownSeconds();
        if (countdownSeconds != null) {
            int intValue = countdownSeconds.intValue();
            if (1 > intValue || intValue >= 11) {
                countdownSeconds = null;
            }
            if (countdownSeconds != null) {
                i = countdownSeconds.intValue();
                int i2 = i;
                points = hudDriftCounterData.getPoints();
                if (points != null) {
                    if (points.longValue() < 0) {
                        points = null;
                    }
                    if (points != null) {
                        long longValue = points.longValue();
                        Integer elapsedSeconds = hudDriftCounterData.getElapsedSeconds();
                        if (elapsedSeconds != null) {
                            if (elapsedSeconds.intValue() < 0) {
                                elapsedSeconds = null;
                            }
                            if (elapsedSeconds != null) {
                                int intValue2 = elapsedSeconds.intValue();
                                Integer multiplier = hudDriftCounterData.getMultiplier();
                                if (multiplier != null) {
                                    if (multiplier.intValue() < 1) {
                                        multiplier = null;
                                    }
                                    if (multiplier != null) {
                                        int intValue3 = multiplier.intValue();
                                        Integer minimumSpeedKmh = hudDriftCounterData.getMinimumSpeedKmh();
                                        if (minimumSpeedKmh != null) {
                                            if (minimumSpeedKmh.intValue() < 0) {
                                                minimumSpeedKmh = null;
                                            }
                                            if (minimumSpeedKmh != null) {
                                                int intValue4 = minimumSpeedKmh.intValue();
                                                Integer currentSpeedKmh = hudDriftCounterData.getCurrentSpeedKmh();
                                                if (currentSpeedKmh != null) {
                                                    if (currentSpeedKmh.intValue() < 0) {
                                                        currentSpeedKmh = null;
                                                    }
                                                    if (currentSpeedKmh != null) {
                                                        return new HudDriftCounterState(i2, longValue, intValue2, intValue3, intValue4, currentSpeedKmh.intValue());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return null;
            }
        }
        if (hudDriftCounterData.getCountdownSeconds() == null) {
            i = 10;
            int i22 = i;
            points = hudDriftCounterData.getPoints();
            if (points != null) {
            }
        }
        return null;
    }

    public static final HudDriftCounterState merge(HudDriftCounterState hudDriftCounterState, HudDriftCounterData update) {
        int countdownSeconds;
        Intrinsics.checkNotNullParameter(hudDriftCounterState, "<this>");
        Intrinsics.checkNotNullParameter(update, "update");
        Integer countdownSeconds2 = update.getCountdownSeconds();
        if (countdownSeconds2 != null) {
            countdownSeconds = RangesKt.coerceIn(countdownSeconds2.intValue(), 1, 10);
        } else {
            countdownSeconds = hudDriftCounterState.getCountdownSeconds();
        }
        int i = countdownSeconds;
        Long points = update.getPoints();
        long coerceAtLeast = points != null ? RangesKt.coerceAtLeast(points.longValue(), 0L) : hudDriftCounterState.getPoints();
        Integer elapsedSeconds = update.getElapsedSeconds();
        int coerceAtLeast2 = elapsedSeconds != null ? RangesKt.coerceAtLeast(elapsedSeconds.intValue(), 0) : hudDriftCounterState.getElapsedSeconds();
        Integer multiplier = update.getMultiplier();
        int coerceAtLeast3 = multiplier != null ? RangesKt.coerceAtLeast(multiplier.intValue(), 1) : hudDriftCounterState.getMultiplier();
        Integer minimumSpeedKmh = update.getMinimumSpeedKmh();
        int coerceAtLeast4 = minimumSpeedKmh != null ? RangesKt.coerceAtLeast(minimumSpeedKmh.intValue(), 0) : hudDriftCounterState.getMinimumSpeedKmh();
        Integer currentSpeedKmh = update.getCurrentSpeedKmh();
        return hudDriftCounterState.copy(i, coerceAtLeast, coerceAtLeast2, coerceAtLeast3, coerceAtLeast4, currentSpeedKmh != null ? RangesKt.coerceAtLeast(currentSpeedKmh.intValue(), 0) : hudDriftCounterState.getCurrentSpeedKmh());
    }

    public static final HudDriftCounterData parseHudDriftCounterPayload(String payload) {
        Object m9919constructorimpl;
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (StringsKt.isBlank(payload)) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl((HudDriftCounterData) MapperKt.getGson().fromJson(payload, (Class<Object>) HudDriftCounterData.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m9925isFailureimpl(m9919constructorimpl) ? null : m9919constructorimpl;
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
}
