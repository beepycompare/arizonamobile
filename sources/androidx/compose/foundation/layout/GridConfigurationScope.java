package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
/* compiled from: Grid.kt */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0011J\u0012\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0015\u001a\u00020\u0016H&J\u0017\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¢\u0006\u0004\b\u001b\u0010\u0011J\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H&¢\u0006\u0004\b\u001c\u0010\u0011J\u0012\u0010\u001a\u001a\u00020\r2\b\b\u0001\u0010\u0015\u001a\u00020\u0016H&J\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0017H&¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u000fH&¢\u0006\u0004\b \u0010\u0011J\u001f\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000fH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u000fH&¢\u0006\u0004\b$\u0010\u0011J\u0017\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u000fH&¢\u0006\u0004\b&\u0010\u0011J\u001f\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u0013H\u0017¢\u0006\u0004\b*\u0010+R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010,\u001a\u00020\u0013*\u00020-8VX\u0097\u0004¢\u0006\f\u0012\u0004\b.\u0010\u000b\u001a\u0004\b/\u00100R\u001e\u0010,\u001a\u00020\u0013*\u00020\u00168VX\u0097\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0011\u001a\u0004\b/\u00101R\u001e\u0010,\u001a\u00020\u0013*\u0002028VX\u0097\u0004¢\u0006\f\u0012\u0004\b.\u00103\u001a\u0004\b/\u00104ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00065À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/layout/GridConfigurationScope;", "Landroidx/compose/ui/unit/Density;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-msEJaDk", "()J", "flow", "Landroidx/compose/foundation/layout/GridFlow;", "getFlow-ITJdzs4", "()I", "setFlow-4t4_IgM", "(I)V", "column", "", "size", "Landroidx/compose/ui/unit/Dp;", "column-0680j_4", "(F)V", "weight", "Landroidx/compose/foundation/layout/Fr;", "column-XZblgos", "percentage", "", "Landroidx/compose/foundation/layout/GridTrackSize;", "column-118E5d0", "(J)V", "row", "row-0680j_4", "row-XZblgos", "row-118E5d0", "gap", TtmlNode.COMBINE_ALL, "gap-0680j_4", "gap-YgX7TsA", "(FF)V", "columnGap", "columnGap-0680j_4", "rowGap", "rowGap-0680j_4", "minmax", "min", "max", "minmax-1z8F7YY", "(FF)J", "fr", "", "getFr-9P9H2UQ$annotations", "getFr-9P9H2UQ", "(I)F", "(F)F", "", "(D)V", "(D)F", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface GridConfigurationScope extends Density {
    /* renamed from: getFr-9P9H2UQ$annotations  reason: not valid java name */
    static /* synthetic */ void m936getFr9P9H2UQ$annotations(double d) {
    }

    /* renamed from: getFr-9P9H2UQ$annotations  reason: not valid java name */
    static /* synthetic */ void m937getFr9P9H2UQ$annotations(float f) {
    }

    /* renamed from: getFr-9P9H2UQ$annotations  reason: not valid java name */
    static /* synthetic */ void m938getFr9P9H2UQ$annotations(int i) {
    }

    void column(float f);

    /* renamed from: column-0680j_4  reason: not valid java name */
    void mo939column0680j_4(float f);

    /* renamed from: column-118E5d0  reason: not valid java name */
    void mo940column118E5d0(long j);

    /* renamed from: column-XZblgos  reason: not valid java name */
    void mo941columnXZblgos(float f);

    /* renamed from: columnGap-0680j_4  reason: not valid java name */
    void mo942columnGap0680j_4(float f);

    /* renamed from: gap-0680j_4  reason: not valid java name */
    void mo943gap0680j_4(float f);

    /* renamed from: gap-YgX7TsA  reason: not valid java name */
    void mo944gapYgX7TsA(float f, float f2);

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    long mo945getConstraintsmsEJaDk();

    /* renamed from: getFlow-ITJdzs4  reason: not valid java name */
    int mo946getFlowITJdzs4();

    void row(float f);

    /* renamed from: row-0680j_4  reason: not valid java name */
    void mo951row0680j_4(float f);

    /* renamed from: row-118E5d0  reason: not valid java name */
    void mo952row118E5d0(long j);

    /* renamed from: row-XZblgos  reason: not valid java name */
    void mo953rowXZblgos(float f);

    /* renamed from: rowGap-0680j_4  reason: not valid java name */
    void mo954rowGap0680j_4(float f);

    /* renamed from: setFlow-4t4_IgM  reason: not valid java name */
    void mo955setFlow4t4_IgM(int i);

    /* renamed from: minmax-1z8F7YY  reason: not valid java name */
    default long m950minmax1z8F7YY(float f, float f2) {
        return GridTrackSize.Companion.m994MinMax1z8F7YY(f, f2);
    }

    /* renamed from: getFr-9P9H2UQ  reason: not valid java name */
    default float m949getFr9P9H2UQ(int i) {
        return Fr.m930constructorimpl(i);
    }

    /* renamed from: getFr-9P9H2UQ  reason: not valid java name */
    default float m948getFr9P9H2UQ(float f) {
        return Fr.m930constructorimpl(f);
    }

    /* renamed from: getFr-9P9H2UQ  reason: not valid java name */
    default float m947getFr9P9H2UQ(double d) {
        return Fr.m930constructorimpl((float) d);
    }
}
