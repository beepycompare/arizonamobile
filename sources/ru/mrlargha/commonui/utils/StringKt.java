package ru.mrlargha.commonui.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.DateCalculationsKt;
/* compiled from: String.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u0002H\u0004\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0002*\u00020\u0001H\u0086\b¢\u0006\u0002\u0010\u0005\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0001\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0007\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0007\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0011¨\u0006\u0012"}, d2 = {"toStringJson", "", "", "fromStringJson", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)Ljava/lang/Object;", "getEmojiByUnicode", "", "emojiWithTextLength", "emojiToUnicodeFormat", "unicodeFormatToEmoji", "openLink", "", "context", "Landroid/content/Context;", "formatSecondsToHhMmSs", "thousandsCut", "", "CommonUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StringKt {
    public static final String toStringJson(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        String json = GsonStore.INSTANCE.getGson().toJson(obj);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public static final /* synthetic */ <T> T fromStringJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Gson gson = GsonStore.INSTANCE.getGson();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T t = (T) gson.fromJson(str, (Class<Object>) Object.class);
        Intrinsics.checkNotNullExpressionValue(t, "fromJson(...)");
        return t;
    }

    public static final String getEmojiByUnicode(int i) {
        char[] chars = Character.toChars(i);
        Intrinsics.checkNotNullExpressionValue(chars, "toChars(...)");
        return new String(chars);
    }

    public static final int emojiWithTextLength(String str) {
        int i;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            if (Character.isHighSurrogate(str.charAt(i2)) && (i = i2 + 1) < str.length() && Character.isLowSurrogate(str.charAt(i))) {
                i3 += 8;
                i2 = i;
            } else {
                i3++;
            }
            i2++;
        }
        return i3;
    }

    public static final String emojiToUnicodeFormat(String str) {
        int i;
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (Character.isHighSurrogate(charAt) && (i = i2 + 1) < str.length() && Character.isLowSurrogate(str.charAt(i))) {
                String num = Integer.toString(Character.toCodePoint(charAt, str.charAt(i)), CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                sb.append(":u" + num + StringUtils.PROCESS_POSTFIX_DELIMITER);
                Integer.valueOf(i2);
                i2 = i;
            } else {
                sb.append(charAt);
            }
            i2++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final String unicodeFormatToEmoji(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex(":u([0-9a-fA-F]{4,6}):").replace(str, new Function1() { // from class: ru.mrlargha.commonui.utils.StringKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence unicodeFormatToEmoji$lambda$0;
                unicodeFormatToEmoji$lambda$0 = StringKt.unicodeFormatToEmoji$lambda$0((MatchResult) obj);
                return unicodeFormatToEmoji$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence unicodeFormatToEmoji$lambda$0(MatchResult matchResult) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        try {
            char[] chars = Character.toChars(Integer.parseInt(matchResult.getGroupValues().get(1), CharsKt.checkRadix(16)));
            Intrinsics.checkNotNullExpressionValue(chars, "toChars(...)");
            return new String(chars);
        } catch (Exception unused) {
            return matchResult.getValue();
        }
    }

    public static final void openLink(String str, Context context) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ActivityNotFoundException e) {
            Log.w("CommonUi", "unable to open link: " + str, e);
        }
    }

    public static final String formatSecondsToHhMmSs(int i) {
        String padStart = StringsKt.padStart(String.valueOf(i / DateCalculationsKt.SECONDS_PER_HOUR), 2, '0');
        String padStart2 = StringsKt.padStart(String.valueOf((i / 60) % 60), 2, '0');
        return padStart + StringUtils.PROCESS_POSTFIX_DELIMITER + padStart2 + StringUtils.PROCESS_POSTFIX_DELIMITER + StringsKt.padStart(String.valueOf(i % 60), 2, '0');
    }

    public static final String thousandsCut(int i) {
        return thousandsCut(i);
    }

    public static final String thousandsCut(double d) {
        String str;
        String valueOf;
        if (d >= 1000000.0d) {
            d /= 1000000;
            str = "M";
        } else if (d < 1000.0d) {
            str = "";
        } else {
            d /= 1000;
            str = "K";
        }
        double d2 = 10;
        double floor = Math.floor(d * d2) / d2;
        if (String.valueOf(floor).charAt(valueOf.length() - 1) == '0') {
            return ((int) floor) + str;
        }
        return floor + str;
    }
}
