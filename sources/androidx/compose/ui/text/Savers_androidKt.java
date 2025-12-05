package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.EmojiSupportMatch;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextMotion;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Savers.android.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\n\" \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0010\"\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0014\"\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0018\"\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "", "Landroidx/compose/ui/text/PlatformParagraphStyle$Companion;", "getSaver", "(Landroidx/compose/ui/text/PlatformParagraphStyle$Companion;)Landroidx/compose/runtime/saveable/Saver;", "PlatformParagraphStyleSaver", "Landroidx/compose/ui/text/EmojiSupportMatch;", "Landroidx/compose/ui/text/EmojiSupportMatch$Companion;", "(Landroidx/compose/ui/text/EmojiSupportMatch$Companion;)Landroidx/compose/runtime/saveable/Saver;", "emojiSupportMatchSaver", "getEmojiSupportMatchSaver", "()Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/LineBreak;", "Landroidx/compose/ui/text/style/LineBreak$Companion;", "(Landroidx/compose/ui/text/style/LineBreak$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LineBreakSaver", "Landroidx/compose/ui/text/style/TextMotion;", "Landroidx/compose/ui/text/style/TextMotion$Companion;", "(Landroidx/compose/ui/text/style/TextMotion$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextMotionSaver", "Landroidx/compose/ui/text/style/TextMotion$Linearity;", "Landroidx/compose/ui/text/style/TextMotion$Linearity$Companion;", "(Landroidx/compose/ui/text/style/TextMotion$Linearity$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextMotionLinearitySaver", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Savers_androidKt {
    private static final Saver<PlatformParagraphStyle, Object> PlatformParagraphStyleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.Savers_androidKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object PlatformParagraphStyleSaver$lambda$0;
            PlatformParagraphStyleSaver$lambda$0 = Savers_androidKt.PlatformParagraphStyleSaver$lambda$0((SaverScope) obj, (PlatformParagraphStyle) obj2);
            return PlatformParagraphStyleSaver$lambda$0;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.Savers_androidKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            PlatformParagraphStyle PlatformParagraphStyleSaver$lambda$1;
            PlatformParagraphStyleSaver$lambda$1 = Savers_androidKt.PlatformParagraphStyleSaver$lambda$1(obj);
            return PlatformParagraphStyleSaver$lambda$1;
        }
    });
    private static final Saver<EmojiSupportMatch, Object> emojiSupportMatchSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.Savers_androidKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object emojiSupportMatchSaver$lambda$0;
            emojiSupportMatchSaver$lambda$0 = Savers_androidKt.emojiSupportMatchSaver$lambda$0((SaverScope) obj, (EmojiSupportMatch) obj2);
            return emojiSupportMatchSaver$lambda$0;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.Savers_androidKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            EmojiSupportMatch emojiSupportMatchSaver$lambda$1;
            emojiSupportMatchSaver$lambda$1 = Savers_androidKt.emojiSupportMatchSaver$lambda$1(obj);
            return emojiSupportMatchSaver$lambda$1;
        }
    });
    private static final Saver<LineBreak, Object> LineBreakSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.Savers_androidKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object LineBreakSaver$lambda$0;
            LineBreakSaver$lambda$0 = Savers_androidKt.LineBreakSaver$lambda$0((SaverScope) obj, (LineBreak) obj2);
            return LineBreakSaver$lambda$0;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.Savers_androidKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            LineBreak LineBreakSaver$lambda$1;
            LineBreakSaver$lambda$1 = Savers_androidKt.LineBreakSaver$lambda$1(obj);
            return LineBreakSaver$lambda$1;
        }
    });
    private static final Saver<TextMotion, Object> TextMotionSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.Savers_androidKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object TextMotionSaver$lambda$0;
            TextMotionSaver$lambda$0 = Savers_androidKt.TextMotionSaver$lambda$0((SaverScope) obj, (TextMotion) obj2);
            return TextMotionSaver$lambda$0;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.Savers_androidKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            TextMotion TextMotionSaver$lambda$1;
            TextMotionSaver$lambda$1 = Savers_androidKt.TextMotionSaver$lambda$1(obj);
            return TextMotionSaver$lambda$1;
        }
    });
    private static final Saver<TextMotion.Linearity, Object> TextMotionLinearitySaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.Savers_androidKt$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object TextMotionLinearitySaver$lambda$0;
            TextMotionLinearitySaver$lambda$0 = Savers_androidKt.TextMotionLinearitySaver$lambda$0((SaverScope) obj, (TextMotion.Linearity) obj2);
            return TextMotionLinearitySaver$lambda$0;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.Savers_androidKt$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            TextMotion.Linearity TextMotionLinearitySaver$lambda$1;
            TextMotionLinearitySaver$lambda$1 = Savers_androidKt.TextMotionLinearitySaver$lambda$1(obj);
            return TextMotionLinearitySaver$lambda$1;
        }
    });

    public static final Saver<PlatformParagraphStyle, Object> getSaver(PlatformParagraphStyle.Companion companion) {
        return PlatformParagraphStyleSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object PlatformParagraphStyleSaver$lambda$0(SaverScope saverScope, PlatformParagraphStyle platformParagraphStyle) {
        return CollectionsKt.arrayListOf(SaversKt.save(Boolean.valueOf(platformParagraphStyle.getIncludeFontPadding())), SaversKt.save(EmojiSupportMatch.m7521boximpl(platformParagraphStyle.m7603getEmojiSupportMatch_3YsG6Y()), getSaver(EmojiSupportMatch.Companion), saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlatformParagraphStyle PlatformParagraphStyleSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Boolean bool = obj2 != null ? (Boolean) obj2 : null;
        Intrinsics.checkNotNull(bool);
        boolean booleanValue = bool.booleanValue();
        Object obj3 = list.get(1);
        Saver<EmojiSupportMatch, Object> saver = getSaver(EmojiSupportMatch.Companion);
        EmojiSupportMatch restore = ((!Intrinsics.areEqual(obj3, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) ? saver.restore(obj3) : null;
        Intrinsics.checkNotNull(restore);
        return new PlatformParagraphStyle(restore.m7527unboximpl(), booleanValue, (DefaultConstructorMarker) null);
    }

    public static final Saver<EmojiSupportMatch, Object> getSaver(EmojiSupportMatch.Companion companion) {
        return emojiSupportMatchSaver;
    }

    public static final Saver<EmojiSupportMatch, Object> getEmojiSupportMatchSaver() {
        return emojiSupportMatchSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object emojiSupportMatchSaver$lambda$0(SaverScope saverScope, EmojiSupportMatch emojiSupportMatch) {
        return Integer.valueOf(emojiSupportMatch.m7527unboximpl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EmojiSupportMatch emojiSupportMatchSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return EmojiSupportMatch.m7521boximpl(EmojiSupportMatch.m7522constructorimpl(((Integer) obj).intValue()));
    }

    public static final Saver<LineBreak, Object> getSaver(LineBreak.Companion companion) {
        return LineBreakSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LineBreakSaver$lambda$0(SaverScope saverScope, LineBreak lineBreak) {
        return Integer.valueOf(lineBreak.m8046unboximpl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LineBreak LineBreakSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return LineBreak.m8034boximpl(LineBreak.m8035constructorimpl(((Integer) obj).intValue()));
    }

    public static final Saver<TextMotion, Object> getSaver(TextMotion.Companion companion) {
        return TextMotionSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextMotionSaver$lambda$0(SaverScope saverScope, TextMotion textMotion) {
        return CollectionsKt.arrayListOf(SaversKt.save(TextMotion.Linearity.m8171boximpl(textMotion.m8170getLinearity4e0Vf04$ui_text()), getSaver(TextMotion.Linearity.Companion), saverScope), SaversKt.save(Boolean.valueOf(textMotion.getSubpixelTextPositioning$ui_text())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextMotion TextMotionSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<TextMotion.Linearity, Object> saver = getSaver(TextMotion.Linearity.Companion);
        TextMotion.Linearity restore = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Intrinsics.checkNotNull(restore);
        int m8177unboximpl = restore.m8177unboximpl();
        Object obj3 = list.get(1);
        Boolean bool = obj3 != null ? (Boolean) obj3 : null;
        Intrinsics.checkNotNull(bool);
        return new TextMotion(m8177unboximpl, bool.booleanValue(), null);
    }

    private static final Saver<TextMotion.Linearity, Object> getSaver(TextMotion.Linearity.Companion companion) {
        return TextMotionLinearitySaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextMotionLinearitySaver$lambda$0(SaverScope saverScope, TextMotion.Linearity linearity) {
        return Integer.valueOf(linearity.m8177unboximpl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextMotion.Linearity TextMotionLinearitySaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return TextMotion.Linearity.m8171boximpl(TextMotion.Linearity.m8172constructorimpl(((Integer) obj).intValue()));
    }
}
