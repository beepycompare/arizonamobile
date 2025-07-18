package androidx.compose.ui.layout;

import kotlin.Metadata;
/* compiled from: ContentScale.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/ContentScale;", "", "computeScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeScaleFactor-H7hwNQA", "(JJ)J", "Companion", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ContentScale {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* renamed from: computeScaleFactor-H7hwNQA  reason: not valid java name */
    long mo5431computeScaleFactorH7hwNQA(long j, long j2);

    /* compiled from: ContentScale.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0007R\u001c\u0010\u0017\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/layout/ContentScale$Companion;", "", "()V", "Crop", "Landroidx/compose/ui/layout/ContentScale;", "getCrop$annotations", "getCrop", "()Landroidx/compose/ui/layout/ContentScale;", "FillBounds", "getFillBounds$annotations", "getFillBounds", "FillHeight", "getFillHeight$annotations", "getFillHeight", "FillWidth", "getFillWidth$annotations", "getFillWidth", "Fit", "getFit$annotations", "getFit", "Inside", "getInside$annotations", "getInside", "None", "Landroidx/compose/ui/layout/FixedScale;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/layout/FixedScale;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ContentScale Crop = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Crop$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo5431computeScaleFactorH7hwNQA(long j, long j2) {
                float m5435computeFillMaxDimensioniLBOSCw;
                m5435computeFillMaxDimensioniLBOSCw = ContentScaleKt.m5435computeFillMaxDimensioniLBOSCw(j, j2);
                return ScaleFactor.m5521constructorimpl((Float.floatToRawIntBits(m5435computeFillMaxDimensioniLBOSCw) << 32) | (4294967295L & Float.floatToRawIntBits(m5435computeFillMaxDimensioniLBOSCw)));
            }
        };
        private static final ContentScale Fit = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Fit$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo5431computeScaleFactorH7hwNQA(long j, long j2) {
                float m5436computeFillMinDimensioniLBOSCw;
                m5436computeFillMinDimensioniLBOSCw = ContentScaleKt.m5436computeFillMinDimensioniLBOSCw(j, j2);
                return ScaleFactor.m5521constructorimpl((Float.floatToRawIntBits(m5436computeFillMinDimensioniLBOSCw) << 32) | (4294967295L & Float.floatToRawIntBits(m5436computeFillMinDimensioniLBOSCw)));
            }
        };
        private static final ContentScale FillHeight = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillHeight$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo5431computeScaleFactorH7hwNQA(long j, long j2) {
                float intBitsToFloat = Float.intBitsToFloat((int) (j2 & 4294967295L)) / Float.intBitsToFloat((int) (j & 4294967295L));
                return ScaleFactor.m5521constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L));
            }
        };
        private static final ContentScale FillWidth = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillWidth$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo5431computeScaleFactorH7hwNQA(long j, long j2) {
                float intBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) / Float.intBitsToFloat((int) (j >> 32));
                return ScaleFactor.m5521constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L));
            }
        };
        private static final ContentScale Inside = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Inside$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo5431computeScaleFactorH7hwNQA(long j, long j2) {
                float m5436computeFillMinDimensioniLBOSCw;
                if (Float.intBitsToFloat((int) (j >> 32)) > Float.intBitsToFloat((int) (j2 >> 32)) || Float.intBitsToFloat((int) (j & 4294967295L)) > Float.intBitsToFloat((int) (j2 & 4294967295L))) {
                    m5436computeFillMinDimensioniLBOSCw = ContentScaleKt.m5436computeFillMinDimensioniLBOSCw(j, j2);
                    return ScaleFactor.m5521constructorimpl((Float.floatToRawIntBits(m5436computeFillMinDimensioniLBOSCw) << 32) | (Float.floatToRawIntBits(m5436computeFillMinDimensioniLBOSCw) & 4294967295L));
                }
                return ScaleFactor.m5521constructorimpl((Float.floatToRawIntBits(1.0f) << 32) | (Float.floatToRawIntBits(1.0f) & 4294967295L));
            }
        };
        private static final FixedScale None = new FixedScale(1.0f);
        private static final ContentScale FillBounds = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillBounds$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo5431computeScaleFactorH7hwNQA(long j, long j2) {
                return ScaleFactor.m5521constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 >> 32)) / Float.intBitsToFloat((int) (j >> 32))) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)) / Float.intBitsToFloat((int) (j & 4294967295L))) & 4294967295L));
            }
        };

        public static /* synthetic */ void getCrop$annotations() {
        }

        public static /* synthetic */ void getFillBounds$annotations() {
        }

        public static /* synthetic */ void getFillHeight$annotations() {
        }

        public static /* synthetic */ void getFillWidth$annotations() {
        }

        public static /* synthetic */ void getFit$annotations() {
        }

        public static /* synthetic */ void getInside$annotations() {
        }

        public static /* synthetic */ void getNone$annotations() {
        }

        private Companion() {
        }

        public final ContentScale getCrop() {
            return Crop;
        }

        public final ContentScale getFit() {
            return Fit;
        }

        public final ContentScale getFillHeight() {
            return FillHeight;
        }

        public final ContentScale getFillWidth() {
            return FillWidth;
        }

        public final ContentScale getInside() {
            return Inside;
        }

        public final FixedScale getNone() {
            return None;
        }

        public final ContentScale getFillBounds() {
            return FillBounds;
        }
    }
}
