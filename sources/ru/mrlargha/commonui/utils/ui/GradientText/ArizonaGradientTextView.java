package ru.mrlargha.commonui.utils.ui.GradientText;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
/* compiled from: ArizonaGradientTextView.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0014\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/utils/ui/GradientText/ArizonaGradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "colorArrayList", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setColorList", "colorList", "", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ArizonaGradientTextView extends AppCompatTextView {
    private int[] colorArrayList;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ArizonaGradientTextView(Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ArizonaGradientTextView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaGradientTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.colorArrayList = new int[]{Color.parseColor("#FCD80F"), Color.parseColor("#FF9112")};
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ArizonaGradientTextView, 0, 0);
        try {
            this.colorArrayList = new int[]{obtainStyledAttributes.getColor(R.styleable.ArizonaGradientTextView_startColor, this.colorArrayList[0]), obtainStyledAttributes.getColor(R.styleable.ArizonaGradientTextView_endColor, this.colorArrayList[1])};
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        String obj = getText().toString();
        TextPaint paint = getPaint();
        paint.setShader(new LinearGradient(0.0f, 0.0f, paint.measureText(obj), getTextSize(), this.colorArrayList, (float[]) null, Shader.TileMode.CLAMP));
        super.onDraw(canvas);
    }

    public final void setColorList(List<String> colorList) {
        Intrinsics.checkNotNullParameter(colorList, "colorList");
        ArrayList arrayList = new ArrayList();
        for (String str : colorList) {
            arrayList.add(Integer.valueOf(Color.parseColor(str)));
        }
        this.colorArrayList = CollectionsKt.toIntArray(arrayList);
        invalidate();
    }
}
