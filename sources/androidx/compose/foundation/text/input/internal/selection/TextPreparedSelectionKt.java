package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
/* compiled from: TextPreparedSelection.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"calculateNextCursorPositionAndWedgeAffinity", "Landroidx/compose/foundation/text/input/internal/selection/CursorAndWedgeAffinity;", "proposedCursor", "", "cursor", "transformedTextFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "(IILandroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)J", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextPreparedSelectionKt {

    /* compiled from: TextPreparedSelection.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IndexTransformationType.values().length];
            try {
                iArr[IndexTransformationType.Untransformed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IndexTransformationType.Deletion.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IndexTransformationType.Replacement.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IndexTransformationType.Insertion.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final long calculateNextCursorPositionAndWedgeAffinity(int i, int i2, TransformedTextFieldState transformedTextFieldState) {
        IndexTransformationType indexTransformationType;
        if (i == -1) {
            return CursorAndWedgeAffinity.m1346constructorimpl(i2);
        }
        boolean z = i > i2;
        long m1331mapFromTransformedjx7JFs = transformedTextFieldState.m1331mapFromTransformedjx7JFs(i);
        long m1334mapToTransformedGEjPoXI = transformedTextFieldState.m1334mapToTransformedGEjPoXI(m1331mapFromTransformedjx7JFs);
        if (TextRange.m6141getCollapsedimpl(m1331mapFromTransformedjx7JFs) && TextRange.m6141getCollapsedimpl(m1334mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Untransformed;
        } else if (!TextRange.m6141getCollapsedimpl(m1331mapFromTransformedjx7JFs) && !TextRange.m6141getCollapsedimpl(m1334mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Replacement;
        } else if (TextRange.m6141getCollapsedimpl(m1331mapFromTransformedjx7JFs) && !TextRange.m6141getCollapsedimpl(m1334mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Insertion;
        } else {
            indexTransformationType = IndexTransformationType.Deletion;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[indexTransformationType.ordinal()];
        if (i3 == 1) {
            return CursorAndWedgeAffinity.m1347constructorimpl(i, z ? WedgeAffinity.Start : WedgeAffinity.End);
        } else if (i3 != 2) {
            if (i3 == 3) {
                if (z) {
                    return CursorAndWedgeAffinity.m1347constructorimpl(TextRange.m6142getEndimpl(m1334mapToTransformedGEjPoXI), WedgeAffinity.Start);
                }
                return CursorAndWedgeAffinity.m1347constructorimpl(TextRange.m6147getStartimpl(m1334mapToTransformedGEjPoXI), WedgeAffinity.End);
            } else if (i3 == 4) {
                if (z) {
                    if (i == TextRange.m6147getStartimpl(m1334mapToTransformedGEjPoXI)) {
                        return CursorAndWedgeAffinity.m1347constructorimpl(i, WedgeAffinity.Start);
                    }
                    return CursorAndWedgeAffinity.m1347constructorimpl(TextRange.m6142getEndimpl(m1334mapToTransformedGEjPoXI), WedgeAffinity.End);
                } else if (i == TextRange.m6142getEndimpl(m1334mapToTransformedGEjPoXI)) {
                    return CursorAndWedgeAffinity.m1347constructorimpl(i, WedgeAffinity.End);
                } else {
                    return CursorAndWedgeAffinity.m1347constructorimpl(TextRange.m6147getStartimpl(m1334mapToTransformedGEjPoXI), WedgeAffinity.Start);
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            return CursorAndWedgeAffinity.m1346constructorimpl(i);
        }
    }
}
