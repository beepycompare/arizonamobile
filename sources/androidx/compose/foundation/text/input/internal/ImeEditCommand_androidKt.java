package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBufferKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.adjust.sdk.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
/* compiled from: ImeEditCommand.android.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u001c\u0010\f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0000\u001a\u001c\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0000\u001a\f\u0010\u0010\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\u001c\u0010\u0011\u001a\u00020\u0006*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0001\u001a$\u0010\u0015\u001a\u00020\u0006*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0016H\u0001\u001a\u001c\u0010\u0017\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0000\u001a8\u0010\u0018\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u001a\b\u0002\u0010\u0019\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u001c0\u001bj\u0002`\u001d\u0018\u00010\u001aH\u0000\u001a\u001c\u0010\u001e\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0000¨\u0006\u001f"}, d2 = {"isSurrogatePair", "", Constants.HIGH, "", Constants.LOW, "commitText", "", "Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "text", "", "newCursorPosition", "", "deleteSurroundingText", "lengthBeforeCursor", "lengthAfterCursor", "deleteSurroundingTextInCodePoints", "finishComposingText", "imeDelete", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", TtmlNode.START, TtmlNode.END, "imeReplace", "", "setComposingRegion", "setComposingText", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "setSelection", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ImeEditCommand_androidKt {
    public static final void commitText(ImeEditCommandScope imeEditCommandScope, final String str, final int i) {
        imeEditCommandScope.edit(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$commitText$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldBuffer textFieldBuffer) {
                invoke2(textFieldBuffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldBuffer textFieldBuffer) {
                TextRange m1193getCompositionMzsxiRA$foundation_release = textFieldBuffer.m1193getCompositionMzsxiRA$foundation_release();
                if (m1193getCompositionMzsxiRA$foundation_release != null) {
                    ImeEditCommand_androidKt.imeReplace(textFieldBuffer, TextRange.m6147getStartimpl(m1193getCompositionMzsxiRA$foundation_release.m6151unboximpl()), TextRange.m6142getEndimpl(m1193getCompositionMzsxiRA$foundation_release.m6151unboximpl()), str);
                } else {
                    ImeEditCommand_androidKt.imeReplace(textFieldBuffer, TextRange.m6147getStartimpl(textFieldBuffer.m1195getSelectiond9O1mEE()), TextRange.m6142getEndimpl(textFieldBuffer.m1195getSelectiond9O1mEE()), str);
                }
                int m6147getStartimpl = TextRange.m6147getStartimpl(textFieldBuffer.m1195getSelectiond9O1mEE());
                int i2 = i;
                textFieldBuffer.m1197setSelection5zctL8(TextRangeKt.TextRange(RangesKt.coerceIn(i2 > 0 ? (m6147getStartimpl + i2) - 1 : (m6147getStartimpl + i2) - str.length(), 0, textFieldBuffer.getLength())));
            }
        });
    }

    public static final void setComposingRegion(ImeEditCommandScope imeEditCommandScope, final int i, final int i2) {
        imeEditCommandScope.edit(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$setComposingRegion$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldBuffer textFieldBuffer) {
                invoke2(textFieldBuffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldBuffer textFieldBuffer) {
                if (textFieldBuffer.hasComposition$foundation_release()) {
                    textFieldBuffer.commitComposition$foundation_release();
                }
                int coerceIn = RangesKt.coerceIn(i, 0, textFieldBuffer.getLength());
                int coerceIn2 = RangesKt.coerceIn(i2, 0, textFieldBuffer.getLength());
                if (coerceIn != coerceIn2) {
                    if (coerceIn < coerceIn2) {
                        TextFieldBuffer.setComposition$foundation_release$default(textFieldBuffer, coerceIn, coerceIn2, null, 4, null);
                    } else {
                        TextFieldBuffer.setComposition$foundation_release$default(textFieldBuffer, coerceIn2, coerceIn, null, 4, null);
                    }
                }
            }
        });
    }

    public static /* synthetic */ void setComposingText$default(ImeEditCommandScope imeEditCommandScope, String str, int i, List list, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            list = null;
        }
        setComposingText(imeEditCommandScope, str, i, list);
    }

    public static final void setComposingText(ImeEditCommandScope imeEditCommandScope, final String str, final int i, final List<AnnotatedString.Range<AnnotatedString.Annotation>> list) {
        imeEditCommandScope.edit(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$setComposingText$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldBuffer textFieldBuffer) {
                invoke2(textFieldBuffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldBuffer textFieldBuffer) {
                TextRange m1193getCompositionMzsxiRA$foundation_release = textFieldBuffer.m1193getCompositionMzsxiRA$foundation_release();
                if (m1193getCompositionMzsxiRA$foundation_release != null) {
                    ImeEditCommand_androidKt.imeReplace(textFieldBuffer, TextRange.m6147getStartimpl(m1193getCompositionMzsxiRA$foundation_release.m6151unboximpl()), TextRange.m6142getEndimpl(m1193getCompositionMzsxiRA$foundation_release.m6151unboximpl()), str);
                    if (str.length() > 0) {
                        textFieldBuffer.setComposition$foundation_release(TextRange.m6147getStartimpl(m1193getCompositionMzsxiRA$foundation_release.m6151unboximpl()), TextRange.m6147getStartimpl(m1193getCompositionMzsxiRA$foundation_release.m6151unboximpl()) + str.length(), list);
                    }
                } else {
                    int m6147getStartimpl = TextRange.m6147getStartimpl(textFieldBuffer.m1195getSelectiond9O1mEE());
                    ImeEditCommand_androidKt.imeReplace(textFieldBuffer, m6147getStartimpl, TextRange.m6142getEndimpl(textFieldBuffer.m1195getSelectiond9O1mEE()), str);
                    if (str.length() > 0) {
                        textFieldBuffer.setComposition$foundation_release(m6147getStartimpl, str.length() + m6147getStartimpl, list);
                    }
                }
                int m6147getStartimpl2 = TextRange.m6147getStartimpl(textFieldBuffer.m1195getSelectiond9O1mEE());
                int i2 = i;
                textFieldBuffer.m1197setSelection5zctL8(TextRangeKt.TextRange(RangesKt.coerceIn(i2 > 0 ? (m6147getStartimpl2 + i2) - 1 : (m6147getStartimpl2 + i2) - str.length(), 0, textFieldBuffer.getLength())));
            }
        });
    }

    public static final void deleteSurroundingText(ImeEditCommandScope imeEditCommandScope, final int i, final int i2) {
        imeEditCommandScope.edit(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$deleteSurroundingText$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldBuffer textFieldBuffer) {
                invoke2(textFieldBuffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldBuffer textFieldBuffer) {
                int i3 = i;
                boolean z = i3 >= 0 && i2 >= 0;
                int i4 = i2;
                if (!z) {
                    InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i3 + " and " + i4 + " respectively.");
                }
                int m6142getEndimpl = TextRange.m6142getEndimpl(textFieldBuffer.m1195getSelectiond9O1mEE());
                int i5 = i2;
                int i6 = m6142getEndimpl + i5;
                if (((m6142getEndimpl ^ i6) & (i5 ^ i6)) < 0) {
                    i6 = textFieldBuffer.getLength();
                }
                ImeEditCommand_androidKt.imeDelete(textFieldBuffer, TextRange.m6142getEndimpl(textFieldBuffer.m1195getSelectiond9O1mEE()), Math.min(i6, textFieldBuffer.getLength()));
                int m6147getStartimpl = TextRange.m6147getStartimpl(textFieldBuffer.m1195getSelectiond9O1mEE());
                int i7 = i;
                int i8 = m6147getStartimpl - i7;
                if (((m6147getStartimpl ^ i8) & (i7 ^ m6147getStartimpl)) < 0) {
                    i8 = 0;
                }
                ImeEditCommand_androidKt.imeDelete(textFieldBuffer, Math.max(0, i8), TextRange.m6147getStartimpl(textFieldBuffer.m1195getSelectiond9O1mEE()));
            }
        });
    }

    public static final void deleteSurroundingTextInCodePoints(ImeEditCommandScope imeEditCommandScope, final int i, final int i2) {
        imeEditCommandScope.edit(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$deleteSurroundingTextInCodePoints$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldBuffer textFieldBuffer) {
                invoke2(textFieldBuffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldBuffer textFieldBuffer) {
                boolean isSurrogatePair;
                boolean isSurrogatePair2;
                int i3 = i;
                int i4 = 0;
                boolean z = i3 >= 0 && i2 >= 0;
                int i5 = i2;
                if (!z) {
                    InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i3 + " and " + i5 + " respectively.");
                }
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    if (i6 < i) {
                        int i8 = i7 + 1;
                        if (TextRange.m6147getStartimpl(textFieldBuffer.m1195getSelectiond9O1mEE()) > i8) {
                            isSurrogatePair2 = ImeEditCommand_androidKt.isSurrogatePair(textFieldBuffer.asCharSequence().charAt((TextRange.m6147getStartimpl(textFieldBuffer.m1195getSelectiond9O1mEE()) - i8) - 1), textFieldBuffer.asCharSequence().charAt(TextRange.m6147getStartimpl(textFieldBuffer.m1195getSelectiond9O1mEE()) - i8));
                            i7 = isSurrogatePair2 ? i7 + 2 : i8;
                            i6++;
                        } else {
                            i7 = TextRange.m6147getStartimpl(textFieldBuffer.m1195getSelectiond9O1mEE());
                            break;
                        }
                    } else {
                        break;
                    }
                }
                int i9 = 0;
                while (true) {
                    if (i4 >= i2) {
                        break;
                    }
                    int i10 = i9 + 1;
                    if (TextRange.m6142getEndimpl(textFieldBuffer.m1195getSelectiond9O1mEE()) + i10 < textFieldBuffer.getLength()) {
                        isSurrogatePair = ImeEditCommand_androidKt.isSurrogatePair(textFieldBuffer.asCharSequence().charAt((TextRange.m6142getEndimpl(textFieldBuffer.m1195getSelectiond9O1mEE()) + i10) - 1), textFieldBuffer.asCharSequence().charAt(TextRange.m6142getEndimpl(textFieldBuffer.m1195getSelectiond9O1mEE()) + i10));
                        i9 = isSurrogatePair ? i9 + 2 : i10;
                        i4++;
                    } else {
                        i9 = textFieldBuffer.getLength() - TextRange.m6142getEndimpl(textFieldBuffer.m1195getSelectiond9O1mEE());
                        break;
                    }
                }
                ImeEditCommand_androidKt.imeDelete(textFieldBuffer, TextRange.m6142getEndimpl(textFieldBuffer.m1195getSelectiond9O1mEE()), TextRange.m6142getEndimpl(textFieldBuffer.m1195getSelectiond9O1mEE()) + i9);
                ImeEditCommand_androidKt.imeDelete(textFieldBuffer, TextRange.m6147getStartimpl(textFieldBuffer.m1195getSelectiond9O1mEE()) - i7, TextRange.m6147getStartimpl(textFieldBuffer.m1195getSelectiond9O1mEE()));
            }
        });
    }

    public static final void finishComposingText(ImeEditCommandScope imeEditCommandScope) {
        imeEditCommandScope.edit(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$finishComposingText$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldBuffer textFieldBuffer) {
                invoke2(textFieldBuffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldBuffer textFieldBuffer) {
                textFieldBuffer.commitComposition$foundation_release();
            }
        });
    }

    public static final void setSelection(final ImeEditCommandScope imeEditCommandScope, final int i, final int i2) {
        imeEditCommandScope.edit(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$setSelection$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldBuffer textFieldBuffer) {
                invoke2(textFieldBuffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldBuffer textFieldBuffer) {
                long mo1234mapToTransformedGEjPoXI = ImeEditCommandScope.this.mo1234mapToTransformedGEjPoXI(TextRangeKt.TextRange(0, textFieldBuffer.getLength()));
                int i3 = i;
                int m6145getMinimpl = TextRange.m6145getMinimpl(mo1234mapToTransformedGEjPoXI);
                int m6144getMaximpl = TextRange.m6144getMaximpl(mo1234mapToTransformedGEjPoXI);
                if (i3 < m6145getMinimpl) {
                    i3 = m6145getMinimpl;
                }
                if (i3 <= m6144getMaximpl) {
                    m6144getMaximpl = i3;
                }
                int i4 = i2;
                int m6145getMinimpl2 = TextRange.m6145getMinimpl(mo1234mapToTransformedGEjPoXI);
                int m6144getMaximpl2 = TextRange.m6144getMaximpl(mo1234mapToTransformedGEjPoXI);
                if (i4 < m6145getMinimpl2) {
                    i4 = m6145getMinimpl2;
                }
                if (i4 <= m6144getMaximpl2) {
                    m6144getMaximpl2 = i4;
                }
                textFieldBuffer.m1197setSelection5zctL8(ImeEditCommandScope.this.mo1233mapFromTransformedGEjPoXI(TextRangeKt.TextRange(m6144getMaximpl, m6144getMaximpl2)));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isSurrogatePair(char c, char c2) {
        return Character.isHighSurrogate(c) && Character.isLowSurrogate(c2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
        if (r8 == r2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
        r6.commitComposition$foundation_release();
        r6.clearHighlight$foundation_release();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void imeReplace(TextFieldBuffer textFieldBuffer, int i, int i2, CharSequence charSequence) {
        int min = Math.min(i, i2);
        int max = Math.max(i, i2);
        int i3 = 0;
        int i4 = min;
        while (i4 < max && i3 < charSequence.length() && charSequence.charAt(i3) == textFieldBuffer.asCharSequence().charAt(i4)) {
            i3++;
            i4++;
        }
        int length = charSequence.length();
        while (max > i4 && length > i3 && charSequence.charAt(length - 1) == textFieldBuffer.asCharSequence().charAt(max - 1)) {
            length--;
            max--;
        }
        textFieldBuffer.replace(i4, max, charSequence.subSequence(i3, length));
        textFieldBuffer.m1197setSelection5zctL8(TextRangeKt.TextRange(min + charSequence.length()));
    }

    public static final void imeDelete(TextFieldBuffer textFieldBuffer, int i, int i2) {
        TextRange m1193getCompositionMzsxiRA$foundation_release = textFieldBuffer.m1193getCompositionMzsxiRA$foundation_release();
        int min = Math.min(i, i2);
        int max = Math.max(i, i2);
        TextFieldBufferKt.delete(textFieldBuffer, min, max);
        if (m1193getCompositionMzsxiRA$foundation_release != null) {
            m1193getCompositionMzsxiRA$foundation_release.m6151unboximpl();
            long m1201adjustTextRangevJH6DeI = TextFieldBufferKt.m1201adjustTextRangevJH6DeI(m1193getCompositionMzsxiRA$foundation_release.m6151unboximpl(), min, max, 0);
            if (TextRange.m6141getCollapsedimpl(m1201adjustTextRangevJH6DeI)) {
                textFieldBuffer.commitComposition$foundation_release();
            } else {
                TextFieldBuffer.setComposition$foundation_release$default(textFieldBuffer, TextRange.m6145getMinimpl(m1201adjustTextRangevJH6DeI), TextRange.m6144getMaximpl(m1201adjustTextRangevJH6DeI), null, 4, null);
            }
        }
    }
}
