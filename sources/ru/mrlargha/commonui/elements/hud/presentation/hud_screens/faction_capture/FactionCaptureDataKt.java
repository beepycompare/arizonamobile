package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.faction_capture;

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
/* compiled from: FactionCaptureData.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\u0000\u001a\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"toInitialStateOrNull", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/faction_capture/FactionCaptureState;", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/faction_capture/FactionCaptureData;", "merge", "update", "parseFactionCapturePayload", "payload", "", "formatFactionCaptureTime", "totalSeconds", "", "SECONDS_PER_MINUTE", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FactionCaptureDataKt {
    private static final int SECONDS_PER_MINUTE = 60;

    public static final FactionCaptureState toInitialStateOrNull(FactionCaptureData factionCaptureData) {
        String rightFaction;
        Integer leftScore;
        Intrinsics.checkNotNullParameter(factionCaptureData, "<this>");
        String leftFaction = factionCaptureData.getLeftFaction();
        if (leftFaction != null && (rightFaction = factionCaptureData.getRightFaction()) != null && (leftScore = factionCaptureData.getLeftScore()) != null) {
            int intValue = leftScore.intValue();
            Integer rightScore = factionCaptureData.getRightScore();
            if (rightScore != null) {
                int intValue2 = rightScore.intValue();
                Integer remainingSeconds = factionCaptureData.getRemainingSeconds();
                if (remainingSeconds != null) {
                    int intValue3 = remainingSeconds.intValue();
                    String status = factionCaptureData.getStatus();
                    if (status == null) {
                        return null;
                    }
                    return new FactionCaptureState(leftFaction, rightFaction, intValue, intValue2, intValue3, status);
                }
            }
        }
        return null;
    }

    public static final FactionCaptureState merge(FactionCaptureState factionCaptureState, FactionCaptureData update) {
        Intrinsics.checkNotNullParameter(factionCaptureState, "<this>");
        Intrinsics.checkNotNullParameter(update, "update");
        String leftFaction = update.getLeftFaction();
        if (leftFaction == null) {
            leftFaction = factionCaptureState.getLeftFaction();
        }
        String str = leftFaction;
        String rightFaction = update.getRightFaction();
        if (rightFaction == null) {
            rightFaction = factionCaptureState.getRightFaction();
        }
        String str2 = rightFaction;
        Integer leftScore = update.getLeftScore();
        int intValue = leftScore != null ? leftScore.intValue() : factionCaptureState.getLeftScore();
        Integer rightScore = update.getRightScore();
        int intValue2 = rightScore != null ? rightScore.intValue() : factionCaptureState.getRightScore();
        Integer remainingSeconds = update.getRemainingSeconds();
        int intValue3 = remainingSeconds != null ? remainingSeconds.intValue() : factionCaptureState.getRemainingSeconds();
        String status = update.getStatus();
        if (status == null) {
            status = factionCaptureState.getStatus();
        }
        return factionCaptureState.copy(str, str2, intValue, intValue2, intValue3, status);
    }

    public static final FactionCaptureData parseFactionCapturePayload(String payload) {
        Object m9919constructorimpl;
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (StringsKt.isBlank(payload)) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl((FactionCaptureData) MapperKt.getGson().fromJson(payload, (Class<Object>) FactionCaptureData.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m9925isFailureimpl(m9919constructorimpl) ? null : m9919constructorimpl;
    }

    public static final String formatFactionCaptureTime(int i) {
        int coerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.ROOT, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(coerceAtLeast / 60), Integer.valueOf(coerceAtLeast % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
