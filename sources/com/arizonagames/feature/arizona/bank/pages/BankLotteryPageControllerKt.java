package com.arizonagames.feature.arizona.bank.pages;

import android.graphics.Color;
import android.net.Uri;
import com.arizonagames.feature.arizona.bank.R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: BankLotteryPageController.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002\u001a\u0017\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\f\u001a\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002\"\u000e\u0010\r\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"bindBankLotteryRewardGlow", "", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "colorValue", "", "bankLotteryPlaceBadgeColor", "", "position", "fallbackRewardIcon", "title", "parseColorOrNull", "value", "(Ljava/lang/String;)Ljava/lang/Integer;", "DEFAULT_REWARD_GLOW_COLOR", "REWARD_GLOW_ALPHA", "LOTTERY_TASK_PLATFORM_TOKEN_REGEX", "Lkotlin/text/Regex;", "resolveStreamPlatform", "Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryStreamPlatform;", "url", "matchesDomain", "", "domain", "bank"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankLotteryPageControllerKt {
    private static final int DEFAULT_REWARD_GLOW_COLOR = Color.parseColor("#7C6AFF");
    private static final Regex LOTTERY_TASK_PLATFORM_TOKEN_REGEX = new Regex(":(?:telegram|tg|vk):", RegexOption.IGNORE_CASE);
    private static final int REWARD_GLOW_ALPHA = 160;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindBankLotteryRewardGlow(CustomCardView customCardView, String str) {
        Integer parseColorOrNull = parseColorOrNull(str);
        int intValue = parseColorOrNull != null ? parseColorOrNull.intValue() : DEFAULT_REWARD_GLOW_COLOR;
        CustomCardView.setBackground$default(customCardView, Color.argb((int) REWARD_GLOW_ALPHA, Color.red(intValue), Color.green(intValue), Color.blue(intValue)), Color.argb(0, Color.red(intValue), Color.green(intValue), Color.blue(intValue)), null, CustomCardView.GradientType.RADIAL, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int bankLotteryPlaceBadgeColor(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return Color.parseColor("#30C9FF");
                }
                return Color.parseColor("#50587B");
            }
            return Color.parseColor("#C93EFF");
        }
        return Color.parseColor("#FFB300");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int fallbackRewardIcon(String str) {
        String str2 = str;
        if (StringsKt.contains((CharSequence) str2, (CharSequence) "phone", true) || StringsKt.contains((CharSequence) str2, (CharSequence) "телефон", true)) {
            return R.drawable.bank_other_phone_asset;
        }
        return R.drawable.bank_list_placeholder_icon;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer parseColorOrNull(String str) {
        Object m9919constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl(Integer.valueOf(Color.parseColor(str)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9925isFailureimpl(m9919constructorimpl)) {
            m9919constructorimpl = null;
        }
        return (Integer) m9919constructorimpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BankLotteryStreamPlatform resolveStreamPlatform(String str) {
        String str2;
        String obj = StringsKt.trim((CharSequence) str).toString();
        if (StringsKt.isBlank(obj)) {
            return null;
        }
        String host = Uri.parse(obj).getHost();
        if (host == null) {
            host = Uri.parse("https://" + obj).getHost();
        }
        if (host != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            str2 = host.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(str2, "toLowerCase(...)");
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (matchesDomain(str2, "youtube.com") || matchesDomain(str2, "youtu.be")) {
            return BankLotteryStreamPlatform.YOUTUBE;
        }
        if (matchesDomain(str2, "vk.com") || matchesDomain(str2, "vkvideo.ru")) {
            return BankLotteryStreamPlatform.VK;
        }
        if (matchesDomain(str2, "twitch.tv")) {
            return BankLotteryStreamPlatform.TWITCH;
        }
        return null;
    }

    private static final boolean matchesDomain(String str, String str2) {
        return Intrinsics.areEqual(str, str2) || StringsKt.endsWith$default(str, new StringBuilder(".").append(str2).toString(), false, 2, (Object) null);
    }
}
