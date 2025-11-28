package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Brush.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0011\u001a\u00060\u0012j\u0002`\u00132\u0006\u0010\u0014\u001a\u00020\u0007H&¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0002J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR*\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/Brush;", "<init>", "()V", "internalTransformShader", "Landroidx/compose/ui/graphics/TransformShader;", "createdSize", "Landroidx/compose/ui/geometry/Size;", "J", "value", "Landroidx/compose/ui/graphics/Matrix;", "transform", "getTransform-3i98HWw", "()[F", "setTransform-Q8lPUPs", "([F)V", "[F", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "obtainTransformShader", "applyTo", "", TtmlNode.TAG_P, "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ShaderBrush extends Brush {
    private long createdSize;
    private TransformShader internalTransformShader;
    private float[] transform;

    /* renamed from: createShader-uvyYCjk */
    public abstract Shader mo5249createShaderuvyYCjk(long j);

    public ShaderBrush() {
        super(null);
        this.createdSize = Size.Companion.m5113getUnspecifiedNHjbRc();
    }

    /* renamed from: getTransform-3i98HWw  reason: not valid java name */
    public final float[] m5605getTransform3i98HWw() {
        return this.transform;
    }

    /* renamed from: setTransform-Q8lPUPs  reason: not valid java name */
    public final void m5606setTransformQ8lPUPs(float[] fArr) {
        this.transform = fArr;
        TransformShader transformShader = this.internalTransformShader;
        if (transformShader != null) {
            transformShader.m5689transformQ8lPUPs(fArr);
        }
    }

    private final TransformShader obtainTransformShader() {
        TransformShader transformShader = this.internalTransformShader;
        if (transformShader == null) {
            TransformShader transformShader2 = new TransformShader();
            this.internalTransformShader = transformShader2;
            return transformShader2;
        }
        return transformShader;
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* renamed from: applyTo-Pq9zytI */
    public final void mo5226applyToPq9zytI(long j, Paint paint, float f) {
        TransformShader transformShader = this.internalTransformShader;
        if (transformShader == null || !Size.m5101equalsimpl0(this.createdSize, j)) {
            if (Size.m5107isEmptyimpl(j)) {
                this.internalTransformShader = null;
                this.createdSize = Size.Companion.m5113getUnspecifiedNHjbRc();
                transformShader = null;
            } else {
                transformShader = obtainTransformShader();
                float[] fArr = this.transform;
                if (fArr != null) {
                    transformShader.m5689transformQ8lPUPs(fArr);
                }
                transformShader.setShader(mo5249createShaderuvyYCjk(j));
                this.internalTransformShader = transformShader;
                this.createdSize = j;
            }
        }
        if (!Color.m5281equalsimpl0(paint.mo5151getColor0d7_KjU(), Color.Companion.m5306getBlack0d7_KjU())) {
            paint.mo5157setColor8_81llA(Color.Companion.m5306getBlack0d7_KjU());
        }
        if (!Intrinsics.areEqual(paint.getShader(), transformShader != null ? transformShader.getShader() : null)) {
            paint.setShader(transformShader != null ? transformShader.getShader() : null);
        }
        if (paint.getAlpha() == f) {
            return;
        }
        paint.setAlpha(f);
    }
}
