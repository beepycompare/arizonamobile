package com.androidplot.xy;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.androidplot.ui.Formatter;
import com.androidplot.ui.RenderStack;
import com.androidplot.ui.SeriesBundle;
import com.androidplot.xy.CandlestickFormatter;
import java.util.List;
/* loaded from: classes3.dex */
public class CandlestickRenderer<FormatterType extends CandlestickFormatter> extends GroupRenderer<FormatterType> {
    protected static final int CLOSE_INDEX = 3;
    protected static final int HIGH_INDEX = 0;
    protected static final int LOW_INDEX = 1;
    protected static final int OPEN_INDEX = 2;

    protected void doDrawLegendIcon(Canvas canvas, RectF rectF, FormatterType formattertype) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.androidplot.ui.SeriesRenderer
    protected /* bridge */ /* synthetic */ void doDrawLegendIcon(Canvas canvas, RectF rectF, Formatter formatter) {
        doDrawLegendIcon(canvas, rectF, (RectF) ((CandlestickFormatter) formatter));
    }

    public CandlestickRenderer(XYPlot xYPlot) {
        super(xYPlot);
    }

    @Override // com.androidplot.xy.GroupRenderer
    public void onRender(Canvas canvas, RectF rectF, List<SeriesBundle<XYSeries, ? extends FormatterType>> list, int i, RenderStack renderStack) {
        List<SeriesBundle<XYSeries, ? extends FormatterType>> list2 = list;
        int i2 = 0;
        FormatterType formatter = list2.get(0).getFormatter();
        int i3 = 0;
        while (i3 < i) {
            XYSeries series = list2.get(i2).getSeries();
            XYSeries series2 = list2.get(1).getSeries();
            XYSeries series3 = list2.get(2).getSeries();
            XYSeries series4 = list2.get(3).getSeries();
            Number x = series.getX(i3);
            Number y = series.getY(i3);
            Number y2 = series2.getY(i3);
            Number y3 = series3.getY(i3);
            Number y4 = series4.getY(i3);
            PointF transformScreen = ((XYPlot) getPlot()).getBounds().transformScreen(x, y, rectF);
            PointF transformScreen2 = ((XYPlot) getPlot()).getBounds().transformScreen(x, y2, rectF);
            PointF transformScreen3 = ((XYPlot) getPlot()).getBounds().transformScreen(x, y3, rectF);
            PointF transformScreen4 = ((XYPlot) getPlot()).getBounds().transformScreen(x, y4, rectF);
            drawWick(canvas, transformScreen, transformScreen2, formatter);
            drawBody(canvas, transformScreen3, transformScreen4, formatter);
            drawUpperCap(canvas, transformScreen, formatter);
            drawLowerCap(canvas, transformScreen2, formatter);
            PointLabelFormatter pointLabelFormatter = formatter.hasPointLabelFormatter() ? formatter.getPointLabelFormatter() : null;
            PointLabeler pointLabeler = formatter.getPointLabeler();
            if (pointLabelFormatter != null && pointLabeler != null) {
                drawTextLabel(canvas, transformScreen, pointLabeler.getLabel(series, i3), pointLabelFormatter);
                drawTextLabel(canvas, transformScreen2, pointLabeler.getLabel(series2, i3), pointLabelFormatter);
                drawTextLabel(canvas, transformScreen3, pointLabeler.getLabel(series3, i3), pointLabelFormatter);
                drawTextLabel(canvas, transformScreen4, pointLabeler.getLabel(series4, i3), pointLabelFormatter);
            }
            i3++;
            list2 = list;
            i2 = 0;
        }
    }

    protected void drawTextLabel(Canvas canvas, PointF pointF, String str, PointLabelFormatter pointLabelFormatter) {
        if (str != null) {
            canvas.drawText(str, pointF.x + pointLabelFormatter.hOffset, pointF.y + pointLabelFormatter.vOffset, pointLabelFormatter.getTextPaint());
        }
    }

    protected void drawWick(Canvas canvas, PointF pointF, PointF pointF2, FormatterType formattertype) {
        canvas.drawLine(pointF.x, pointF.y, pointF2.x, pointF2.y, formattertype.getWickPaint());
    }

    protected void drawBody(Canvas canvas, PointF pointF, PointF pointF2, FormatterType formattertype) {
        float bodyWidth = formattertype.getBodyWidth() / 2.0f;
        RectF rectF = new RectF(pointF.x - bodyWidth, pointF.y, pointF2.x + bodyWidth, pointF2.y);
        Paint risingBodyFillPaint = pointF.y >= pointF2.y ? formattertype.getRisingBodyFillPaint() : formattertype.getFallingBodyFillPaint();
        Paint risingBodyStrokePaint = pointF.y >= pointF2.y ? formattertype.getRisingBodyStrokePaint() : formattertype.getFallingBodyStrokePaint();
        int i = AnonymousClass1.$SwitchMap$com$androidplot$xy$CandlestickFormatter$BodyStyle[formattertype.getBodyStyle().ordinal()];
        if (i == 1) {
            canvas.drawRect(rectF, risingBodyFillPaint);
            canvas.drawRect(rectF, risingBodyStrokePaint);
        } else if (i != 2) {
        } else {
            drawTriangle(canvas, rectF, risingBodyFillPaint, risingBodyStrokePaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.androidplot.xy.CandlestickRenderer$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$androidplot$xy$CandlestickFormatter$BodyStyle;

        static {
            int[] iArr = new int[CandlestickFormatter.BodyStyle.values().length];
            $SwitchMap$com$androidplot$xy$CandlestickFormatter$BodyStyle = iArr;
            try {
                iArr[CandlestickFormatter.BodyStyle.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$androidplot$xy$CandlestickFormatter$BodyStyle[CandlestickFormatter.BodyStyle.TRIANGULAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    protected void drawUpperCap(Canvas canvas, PointF pointF, FormatterType formattertype) {
        float upperCapWidth = formattertype.getUpperCapWidth();
        canvas.drawLine(pointF.x - upperCapWidth, pointF.y, pointF.x + upperCapWidth, pointF.y, formattertype.getUpperCapPaint());
    }

    protected void drawLowerCap(Canvas canvas, PointF pointF, FormatterType formattertype) {
        float lowerCapWidth = formattertype.getLowerCapWidth();
        canvas.drawLine(pointF.x - lowerCapWidth, pointF.y, pointF.x + lowerCapWidth, pointF.y, formattertype.getLowerCapPaint());
    }

    protected void drawTriangle(Canvas canvas, RectF rectF, Paint paint, Paint paint2) {
        Path path = new Path();
        path.moveTo(rectF.centerX(), rectF.bottom);
        path.lineTo(rectF.left, rectF.top);
        path.lineTo(rectF.right, rectF.top);
        path.close();
        canvas.drawPath(path, paint);
        canvas.drawPath(path, paint2);
    }
}
